# E-Learning-Simple

## Query
- Select Kelas : 
SELECT Kelas.id, Kelas.nama, Kelas.kode, Akun.nama as pengajar FROM ((Kelas INNER JOIN Akun ON Kelas.id_pengajar = Akun.id) INNER JOIN Kelas_Akun ON Kelas_Akun.id_kelas = Kelas.id) WHERE Kelas_Akun.id_user = 2;

- Select semua kelas : 
SELECT Kelas.id, Kelas.nama, Kelas.kode, Akun.nama as pengajar FROM (Kelas INNER JOIN Akun ON Kelas.id_pengajar = Akun.id);

## Database
