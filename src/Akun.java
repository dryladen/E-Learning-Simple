import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Akun {
    protected int id;
    protected String username, password, nama, jenisKelamin, alamat;
    protected InputStreamReader prepare = new InputStreamReader(System.in);
    protected BufferedReader input = new BufferedReader(prepare);
    protected int pilihan;
    protected static int jumlah = 0;
    protected int isPengajar = 0;
    protected ArrayList<Kelas> kelas;
    protected Database database;

    // Constructor
    public Akun(int id, String username, String password, String nama, String jenisKelamin, String alamat,
            int isPengajar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.isPengajar = isPengajar;
        prepare = new InputStreamReader(System.in);
        input = new BufferedReader(prepare);
        jumlah++;
        database = new Database();
        kelas = database.getDataKelas(id);
    }

    public void profile() {
        System.out.println("=========================================================");
        System.out.println("Nomor ID      : " + this.id);
        System.out.println("Username      : " + this.username);
        System.out.println("Password      : " + this.password);
        System.out.println("Nama          : " + this.nama);
        System.out.println("Jenis Kelamin : " + this.jenisKelamin);
        System.out.println("Alamat        : " + this.alamat);
        System.out.println("=========================================================");
    }

    public int isPengajar() {
        return isPengajar;
    }

    public void setPengajar(int isPengajar) {
        this.isPengajar = isPengajar;
    }

    public static int getJumlah() {
        return jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
