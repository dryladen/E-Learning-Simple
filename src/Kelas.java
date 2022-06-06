public class Kelas {
    private int id;
    private String nama, kode, id_pengajar, pengajar;

    public Kelas(int id, String nama, String kode, String id_pengajar, String pengajar) {
        this.id = id;
        this.nama = nama;
        this.kode = kode;
        this.id_pengajar = id_pengajar;
        this.pengajar = pengajar;
    }

    public void displayKelas() {
        System.out.println("Nama kelas : " + this.nama);
        System.out.println("Kode kelas : " + this.kode);
        System.out.println("Pengajar   : " + this.pengajar);
        System.out.println("=========================================================");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_pengajar() {
        return id_pengajar;
    }

    public void setId_pengajar(String id_pengajar) {
        this.id_pengajar = id_pengajar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

}
