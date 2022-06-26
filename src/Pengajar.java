import java.io.IOException;
import java.util.ArrayList;

public class Pengajar extends Akun implements UserLevelA, UserLevelB {

    public Pengajar(String id, String username, String password, String nama, String jenisKelamin, String alamat,
            String isPengajar) {
        super(id, username, password, nama, jenisKelamin, alamat, isPengajar);
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
    public void buatKelas() {
        try {
            System.out.println("Masukan nama kelas : ");
            String namaKelas = input.readLine();
            System.out.println("Masukan kode kelas : ");
            String kodeKelas = input.readLine();
            if (database.isKelasExist(namaKelas, kodeKelas)) {
                System.out.println("Kelas sudah ada");
                return;
            }
            database.buatKelas(namaKelas, kodeKelas, this.id);
            System.out.println("Kelas berhasil dibuat");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void hapusKelas() {
        try {
            if (this.kelas.isEmpty()) {
                System.out.println("Kelas kosong");
            } else {
                System.out.println("Masukan kode kelas : ");
                String kodeKelas;
                kodeKelas = input.readLine();
                for (int i = 0; i < this.kelas.size(); i++) {
                    if (this.kelas.get(i).getNama().equals(kodeKelas)) {
                        if (database.isKelasPengajarExist(nama, id)) {
                            database.deleteKelas(kodeKelas, id);
                            System.out.println("Kelas berhasil dihapus");
                            return;
                        } else {
                            System.out.println("Anda bukan pengajar di kelas ini");
                            return;
                        }
                    }
                }
                System.out.println("Kelas tidak ditemukan");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lihatKelas() {
        if (this.kelas.isEmpty()) {
            System.out.println("Dosen : " + this.nama + " belum memiliki kelas");
        } else {
            System.out.println("===============================");
            System.out.println("Kelas yang dimiliki : ");
            System.out.println("===============================");
            for (Kelas kelas2 : this.kelas) {
                System.out.println("Kelas ke-" + kelas.indexOf(kelas2) + 1 + " : ");
                System.out.println("Nama Kelas : " + kelas2.getNama());
                System.out.println("Kode Kelas : " + kelas2.getKode());
                System.out.println("-------------------------------");
            }
        }
    }

    @Override
    public void ubahKelas() {
        try {
            if (this.kelas.isEmpty()) {
                System.out.println("Dosen : " + this.nama + " belum memiliki kelas");
            } else {
                System.out.println("Masukan kode kelas : ");
                String kodeKelas = input.readLine();
                if (database.isKelasPengajarExist(kodeKelas, id)) {
                    System.out.println("Masukan nama kelas : ");
                    String namaKelas = input.readLine();
                    database.updateKelas(namaKelas, id);
                    System.out.println("Kelas berhasil diubah");
                } else {
                    System.out.println("Anda bukan pengajar di kelas ini");
                }
                System.out.println("Kelas tidak ditemukan");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void menu() {
        try {
            while (true) {
                kelas = database.getDataKelas(id);
                System.out.println("==========================");
                System.out.println("1. Lihat Kelas");
                System.out.println("2. Buat Kelas");
                System.out.println("3. Hapus Kelas");
                System.out.println("4. Ubah Kelas");
                System.out.println("5. Join Kelas");
                System.out.println("6. Profile");
                System.out.println("7. Logout");
                System.out.println("==========================");
                System.out.println("Pilih menu: ");
                pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        this.lihatKelas();
                        break;
                    case 2:
                        this.buatKelas();
                        break;
                    case 3:
                        this.hapusKelas();
                        break;
                    case 4:
                        this.ubahKelas();
                        break;
                    case 5:
                        this.joinKelas();
                        break;
                    case 6:
                        this.profile();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void keluarKelas() {

    }
}
