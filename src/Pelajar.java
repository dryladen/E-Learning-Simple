import java.io.IOException;
import java.util.ArrayList;

public class Pelajar extends Akun implements UserLevelB {

    // Constructor
    public Pelajar(String id, String username, String password, String nama, String jenisKelamin, String alamat,
            String isPengajar) {
        super(id, username, password, nama, jenisKelamin, alamat, isPengajar);
    }

    // Setter & Getter
    public ArrayList<Kelas> getKelas() {
        return kelas;
    }

    public void setKelas(ArrayList<Kelas> kelas) {
        this.kelas = kelas;
    }

    @Override
    public void joinKelas() {
        try {
            ArrayList<Kelas> dataKelas = database.getDataKelas();
            for (Kelas kelas : dataKelas) {
                System.out.println(kelas.getKode() + ". " + kelas.getNama());
            }
            System.out.print("Masukan kode kelas : ");
            String kodeKelas = input.readLine();
            for (Kelas kelas : dataKelas) {
                if (kelas.getKode().equals(kodeKelas)) {
                    for (Kelas kelas2 : this.kelas) {
                        if (kelas2.getKode().equals(kodeKelas)) {
                            System.out.println("Anda sudah terdaftar di kelas ini");
                            return;
                        }
                    }
                    this.kelas.add(kelas);
                    database.joinKelas(this.id, kelas.getId());
                    System.out.println("Kelas berhasil ditambahkan");
                    return;
                }
            }
            System.out.println("Kelas tidak ditemukan");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void keluarKelas() {
        try {
            if (this.kelas.isEmpty()) {
                System.out.println("Kelas kosong");
            } else {
                System.out.print("Masukan kode kelas : ");
                String kodeKelas;
                kodeKelas = input.readLine();
                for (int i = 0; i < this.kelas.size(); i++) {
                    if (this.kelas.get(i).getKode().equals(kodeKelas)) {
                        database.keluarKelas(this.id, this.kelas.get(i).getId());
                        this.kelas.remove(i);
                        System.out.println("Kelas berhasil dihapus");
                        return;
                    }
                }
                System.out.println("Kelas tidak ditemukan");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void lihatKelas() {
        System.out.println("=========================================================");
        System.out.println("Kelas yang diikuti : ");
        for (Kelas k : this.kelas) {
            System.out.println("Nama kelas : " + k.getNama());
            System.out.println("Kode kelas : " + k.getKode());
            System.out.println("Pengajar   : " + k.getPengajar());
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
                System.out.println("3. Keluar  Kelas");
                System.out.println("4. Profile");
                System.out.println("5. Logout");
                System.out.println("==========================");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        this.lihatKelas();
                        break;
                    case 2:
                        this.joinKelas();
                        break;
                    case 3:
                        this.keluarKelas();
                        break;
                    case 4:
                        this.profile();
                        break;
                    case 5:
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
