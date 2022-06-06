# E-Learning-Simple

## Query
- Select Kelas : 
    SELECT Kelas.id, Kelas.nama, Kelas.kode, Akun.nama as pengajar
    FROM ((Kelas_Akun INNER JOIN Kelas ON Kelas_Akun.id_kelas = Kelas.id)
    INNER JOIN Akun ON Kelas_Akun.id_pengajar = Akun.id) WHERE Kelas_Akun.id_user = 2;