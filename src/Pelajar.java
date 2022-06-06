import java.io.IOException;
import java.util.ArrayList;

/*
 *
 * @author Laden
 */
public class Pelajar extends Akun implements UserLevelB {

    private String nim;

    // Constructor
    public Pelajar(String username, String password, String nama, String jenisKelamin, String alamat, String nim) {
        super(username, password, nama, jenisKelamin, alamat);
        this.nim = nim;
    }

    // Setter & Getter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public ArrayList<Kelas> getKelas() {
        return kelas;
    }

    public void setKelas(ArrayList<Kelas> kelas) {
        this.kelas = kelas;
    }

    @Override
    public void profile() {
        System.out.println("=========================================================");
        super.profile();
        System.out.println("NIP           : " + this.nim);
        System.out.println("=========================================================");
    }

    @Override
    public void joinKelas() {
        try {
            System.out.println("Masukan kode kelas : ");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void lihatKelas() {
        // TODO Auto-generated method stub
        System.out.println("=========================================================");
        System.out.println("Kelas yang diikuti : ");
        for (Kelas k : this.kelas) {
            System.out.println("Nama kelas : " + k.getNama());
            System.out.println("Kode kelas : " + k.getKode());
            System.out.println("Dosen      : " + k.getDosen());
            System.out.println("=========================================================");
        }
    }

    @Override
    public void menu() {
        try {
            while (true) {
                System.out.println("==========================");
                System.out.println("1. Lihat Kelas");
                System.out.println("2. Join  Kelas");
                System.out.println("3. Profile");
                System.out.println("4. Logout");
                System.out.println("==========================");
                System.out.println("Pilih menu: ");
                pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        this.lihatKelas();
                        break;
                    case 2:
                        this.joinKelas();
                        break;
                    case 3:
                        this.profile();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}