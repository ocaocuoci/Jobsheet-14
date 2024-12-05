import java.util.*;
public class ocee{

    static Scanner sc =new Scanner(System.in);

    public static void main (String[] args){
            System.out.println("==== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();

            switch(pilihan) {
                case 1:
                tambahDataKRS();
                break;
            }

        }
    public static void tambahDataKRS(){
        System.out.println("=== Tambah Data KRS ===");

        System.out.print("Nama Mahasiswa\t: ");
        String namaMhs =sc.nextLine();
        sc.nextLine();

        System.out.print("NIM\t\t: ");
        String nim = sc.nextLine();
    
        while(true){
            System.out.print("Kode Mata Kuliah: ");
            String kode = sc.nextLine();

            System.out.print("Nama Mata Kuliah: ");
            String matkul = sc.nextLine();

            System.out.print("Jumlah SKS (1-3): ");
            int sks = sc.nextInt();
            sc.nextLine();

            if (sks > 1 && sks <= 3){
                System.out.println("Data mata kuliah berhasil ditambahkan.");
            } else {
                System.out.println("Jumlah SKS tidak valid! SKS harus antara 1 dan 3");
            }

        }
        
    }

    
}