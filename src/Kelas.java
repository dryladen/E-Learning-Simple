public class Kelas {
    private String nama;
    private String kode;
    private String dosen;

    public Kelas(String nama, String kode, String dosen) {
        this.nama = nama;
        this.kode = kode;
        this.dosen = dosen;
    }

    public void displayKelas() {
        System.out.println("=========================================================");
        System.out.println("Nama kelas : " + this.nama);
        System.out.println("Kode kelas : " + this.kode);
        System.out.println("Dosen      : " + this.dosen);
        System.out.println("=========================================================");
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

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

}
