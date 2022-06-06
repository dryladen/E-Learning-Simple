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
        String fileAbsolutePath = getFilePath.concat("\\databaseKelas.db");
        if (isDatabaseExists(fileAbsolutePath)) {
            try {
                this.koneksi = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error koneksi database : " + ex);
            }
        }
        return koneksi;
    }

    // ! Manajement Kelas
    public void getData(ArrayList<Kelas> kelas) {
        try {
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            result = stm.executeQuery("SELECT * FROM Kelas");
            while (result.next()) {
                // kelas.add(new Kelas(result.getInt(1), result.getString(2),
                // result.getFloat(3), result.getInt(4)));
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
    }

    public void addKelas(Kelas Kelas) {
        try {
            sql = "INSERT INTO Kelas (nama,price,amount) VALUES ('%s','%f','%d')";
            sql = String.format(sql);
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void updateKelas(Kelas Kelas) {
        try {
            sql = "UPDATE Kelas SET nama=?,price=?,amount=? WHERE id=?";
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
            String sql = "DELETE FROM Kelas WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
