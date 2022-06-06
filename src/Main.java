import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        ArrayList<Akun> dataAkun = new ArrayList<Akun>();
        int pilihan;
        while (true) {
            System.out.println("=================================");
            System.out.println("E-Learning");
            System.out.println("=================================");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Masukan pilihan : ");
            pilihan = Integer.parseInt(input.readLine());
            if (pilihan == 1) {
                System.out.print("Masukan username : ");
                String username = input.readLine();
                System.out.print("Masukan password : ");
                String password = input.readLine();
                for (Akun akun : dataAkun) {
                    if (username.equals(akun.getUsername()) && password.equals(akun.getPassword())) {
                        akun.menu();
                        continue;
                    }
                }
                System.out.println("Username atau password salah");
            } else {
                System.out.println("Terima kasih");
                break;
            }
        }
    }
}
