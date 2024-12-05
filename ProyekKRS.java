import java.util.Scanner;

public class ProyekKRS {
    // array untuk menyimpan data KRS
    static String[][] data = new String[26][5]; // maks 26 mahasiswa, 5 kolom data per mahasiswa
    static int jmlData = 0; // menyimpan jumlah data mahasiswa yang sudah dimasukkan
    static Scanner sc = new Scanner(System.in); // scanner untuk input

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahDataKRS(); // menambah data KRS
                    break;
                case 2:
                    tampilkanDaftarKRS(); //menampilkan daftar KRS
                    break;
                case 3:
                    analisisDataKRS(); // menampilkan analisis data KRS
                    break;
                case 4:
                    System.out.println("Terima kasih!"); // keluar dari program
                    break;
                default:
                    System.out.println("Pilihan tidak valid!"); // salah pilih
                    break;
            }
        } while (pilihan != 4); //mengulangi jika yang dipilih bukan 4
    }
    // menambah data KRS
    public static void tambahDataKRS() {
        System.out.println("\n--- Tambah Data KRS ---");
        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        int totalSKS = 0; // variabel untuk menyimpan total SKS yg diambil

        // Loop menambah mata kuliah
        while (true) {
            System.out.print("Kode Mata Kuliah: ");
            String kodeMatkul = sc.nextLine();
            System.out.print("Nama Mata Kuliah: ");
            String namaMatkul = sc.nextLine();
            System.out.print("Jumlah SKS (1-3): ");
            int sks = sc.nextInt(); // SKS matkul
            sc.nextLine(); // bersihkan newline

            // validasi jumlh SKS
            if (sks < 1 || sks > 3) {
                System.out.println("Jumlah SKS tidak valid! SKS harus antara 1 dan 3.");
                continue; // kembali ke awal loop
            } else if (totalSKS + sks > 24) {
                System.out.println("Total SKS melebihi 24! Data tidak bisa ditambahkan.");
                break; // keluar loop
            }

            // simpan data ke array
            data[jmlData][0] = nama; // nama mahasiswa
            data[jmlData][1] = nim; // NIM mahasiswa
            data[jmlData][2] = kodeMatkul; // kode matakul
            data[jmlData][3] = namaMatkul; // nama matakul
            data[jmlData][4] = String.valueOf(sks); // jumlah SKS
            jmlData++; // tambah jumlah data

            totalSKS += sks; // tambah total SKS
            System.out.println("Data mata kuliah berhasil ditambahkan.");

            // apakah ingin menambah mata kuliah lain
            System.out.print("Tambah mata kuliah lain? (y/t): ");
            String pilihan = sc.nextLine();
            if (pilihan.equalsIgnoreCase("t")) {
                break; // keluar loop
            }
        }
        System.out.println("Total SKS yang diambil: " + totalSKS + "\n");
    }
    // menampilkan daftar KRS mhs dengan NIM
    public static void tampilkanDaftarKRS() {
        System.out.println("\n--- Tampilkan Daftar KRS Mahasiswa ---");
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.nextLine();
        int totalSKS = 0; // variabel hitumg SKS untuk NIM yang dimasukkan
        
        System.out.println("Daftar KRS: ");
        System.out.println("NIM\t\t\tNama\t\t\tKode MK\t\t\tNama Mata Kuliah\t\t\tSKS");
        
        for (int i = 0; i < jmlData; i++) {
            if (data[i][1].equals(nim)) {
            System.out.println(data[i][1] + "\t\t\t" + data[i][0] + "\t\t\t" + data[i][2] + "\t\t\t" + data[i][3] + "\t\t\t\t\t" + data[i][4]); 
            totalSKS += Integer.valueOf(data[i][4]); // hitung total SKS
            }
        }
        // menampilkan total SKS
        if (totalSKS == 0) {
            System.out.println("Tidak ada data KRS untuk NIM tersebut.");
        } else {
            System.out.println("Total SKS: " + totalSKS + "\n");
        }
    }
    // analisis data KRS
    public static void analisisDataKRS() {
        System.out.println("\n--- Analisis Data KRS ---");
        int SKSKurang20 = 0; // variabel hitung mahasiswa yang mengambil SKS kurang dari 20
        boolean[] mahasiswaDihitung = new boolean[jmlData]; // array menandai mahasiswa yang sudah dihitung
        
        for (int i = 0; i < jmlData; i++) {
            String nim = data[i][1];
    
            if (!mahasiswaDihitung[i]) {
                int totalSKS = 0;
    
                for (int j = 0; j < jmlData; j++) {
                    if (data[j][1].equals(nim)) {
                        totalSKS += Integer.parseInt(data[j][4]);
                    }
                } 
                
                if (totalSKS < 20) {
                    SKSKurang20++;
                } 
                // menandai mhs yg sudah di hitung
                for (int x = 0; x < jmlData; x++) {
                    if (data[x][1].equals(nim)) {
                        mahasiswaDihitung[x] = true;
                    }
                }
            }
        }    
    System.out.println("Jumlah mahasiswa yang mengambil SKS kurang dari 20: " + SKSKurang20 + "\n");
    }
}