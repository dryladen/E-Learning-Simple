import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;

public class Database {
    // ! Nama database yang digunakan & pastikan database sudah dibuat
    private final String url = "jdbc:sqlite:elearning.db";
    private PreparedStatement pst;
    private Connection koneksi;
    private ResultSet result;
    private Statement stm;
    private String sql;

    public boolean isDatabaseExists(String dbFilePath) {
        File database = new File(dbFilePath);
        return database.exists();
    }

    public Connection getKoneksi() { // ! menghubungkan ke database
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\elearning.db");
        if (isDatabaseExists(fileAbsolutePath)) {
            try {
                koneksi = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error koneksi database : " + ex);
            }
        }
        return koneksi;
    }

    // ! Manajement Kelas
    public ArrayList<Kelas> getDataKelas() {
        ArrayList<Kelas> kelas = new ArrayList<>();
        try {
            sql = "SELECT Kelas.id, Kelas.nama, Kelas.kode,Akun.id as id_pengajar, Akun.nama as pengajar FROM Kelas INNER JOIN Akun ON Kelas.id_pengajar = Akun.id";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            result = pst.executeQuery();
            while (result.next()) {
                kelas.add(new Kelas(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        } finally {
            try {
                result.close();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error set data : " + ex);
            }
        }
        return kelas;
    }

    // Overloading
    public ArrayList<Kelas> getDataKelas(String id) {
        ArrayList<Kelas> kelas = new ArrayList<>();
        try {
            sql = "SELECT Kelas.id, Kelas.nama, Kelas.kode,Akun.id as id_pengajar, Akun.nama as pengajar FROM ((Kelas INNER JOIN Akun ON Kelas.id_pengajar = Akun.id) INNER JOIN Kelas_Akun ON Kelas_Akun.id_kelas = Kelas.id) WHERE Kelas_Akun.id_user = ?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            result = pst.executeQuery();
            while (result.next()) {
                kelas.add(new Kelas(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        } finally {
            try {
                result.close();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error set data : " + ex);
            }
        }
        return kelas;
    }

    public void joinKelas(String id_user, int id_kelas) {
        try {
            sql = "INSERT INTO Kelas_Akun (id_user,id_kelas) VALUES (?,?)";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, id_user);
            pst.setInt(2, id_kelas);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void keluarKelas(String id_user, int id_kelas) {
        try {
            sql = "DELETE FROM Kelas_Akun WHERE id_user = ? AND id_kelas = ?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, id_user);
            pst.setInt(2, id_kelas);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void updateKelas(Kelas Kelas) {
        try {
            sql = "UPDATE Kelas SET nama=? WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void deleteKelas(int id) {
        try {
            sql = "DELETE FROM Kelas WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // ! Manajement Akun
    public ArrayList<Akun> getDataAkun() {
        ArrayList<Akun> akun = new ArrayList<>();
        try {
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery("SELECT * FROM Akun");
            while (result.next()) {
                if (result.getInt(7) == 1) {
                    akun.add(new Pengajar(result.getString(1), result.getString(2), result.getString(3),
                            result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
                } else {
                    akun.add(new Pelajar(result.getString(1), result.getString(2), result.getString(3),
                            result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error set data : " + ex);
            }
        }
        return akun;
    }
}
