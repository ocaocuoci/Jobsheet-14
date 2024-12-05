import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BismillahLancar {

    static class KRS {
        String namaMahasiswa;
        int nim;
        String kodeMataKuliah;
        String namaMataKuliah;
        int jumlahSKS;

        KRS(String namaMahasiswa, int nim, String kodeMataKuliah, String namaMataKuliah, int jumlahSKS) {
            this.namaMahasiswa = namaMahasiswa;
            this.nim = nim;
            this.kodeMataKuliah = kodeMataKuliah;
            this.namaMataKuliah = namaMataKuliah;
            this.jumlahSKS = jumlahSKS;
        }
    }

    private static List<KRS> krsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahDataKRS(scanner);
                    break;
                case 2:
                    tampilkanDaftarKRS();
                    break;
                case 3:
                    analisisDataKRS();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
            }
        } while (pilihan != 4);
        scanner.close();
    }

    private static void tambahDataKRS(Scanner scanner) {
        System.out.println("Tambah Data KRS");
        System.out.print("Nama Mahasiswa: ");
        String namaMahasiswa = scanner.nextLine();
        System.out.print("NIM: ");
        int nim = scanner.nextInt();
        scanner.nextLine(); 

        boolean tambahLain = true;
        while (tambahLain) {
            System.out.print("Kode Mata Kuliah: ");
            String kodeMataKuliah = scanner.nextLine();
            System.out.print("Nama Mata Kuliah: ");
            String namaMataKuliah = scanner.nextLine();
            System.out.print("Jumlah SKS (1-3): ");
            int jumlahSKS = scanner.nextInt();
            scanner.nextLine(); 


            if (jumlahSKS < 1 || jumlahSKS > 3) {
                System.out.println("Jumlah SKS tidak valid. Harus antara 1 dan 3.");
                continue;
            }

            krsList.add(new KRS(namaMahasiswa, nim, kodeMataKuliah, namaMataKuliah, jumlahSKS));
            System.out.println("Data KRS berhasil ditambahkan.");

            System.out.print("Tambah data KRS lain? (ya/tidak): ");
            String jawab = scanner.nextLine();
            tambahLain = jawab.equalsIgnoreCase("ya");
        }
    }

    private static void tampilkanDaftarKRS() {
        System.out.println("Daftar KRS Mahasiswa:");
        for (KRS krs : krsList) {
            System.out.println("NIM: " + krs.nim + ", Nama: " + krs.namaMahasiswa + 
                               " Kode: " + krs.kodeMataKuliah + 
                               " Nama Mata Kuliah: " + krs.namaMataKuliah + 
                               " SKS: " + krs.jumlahSKS);
        }
    }

    private static void analisisDataKRS() {
        System.out.println("Analisis Data KRS:");
    }
}