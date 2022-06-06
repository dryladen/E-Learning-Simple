import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Akun {
    protected String username, password, nama, jenisKelamin, alamat;
    protected InputStreamReader prepare = new InputStreamReader(System.in);
    protected BufferedReader input = new BufferedReader(prepare);
    protected int pilihan;
    protected static int jumlah = 0;
    protected boolean isPengajar = false;
    protected ArrayList<Kelas> kelas;

    // Constructor
    public Akun(String username, String password, String nama, String jenisKelamin, String alamat) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        prepare = new InputStreamReader(System.in);
        input = new BufferedReader(prepare);
        jumlah++;
    }

    public void profile() {
        System.out.println("Nama          : " + this.nama);
        System.out.println("Jenis Kelamin : " + this.jenisKelamin);
        System.out.println("Alamat        : " + this.alamat);
    }

    public boolean isPengajar() {
        return isPengajar;
    }

    public void setPengajar(boolean isPengajar) {
        this.isPengajar = isPengajar;
    }

    public static int getJumlah() {
        return jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void menu();

}
