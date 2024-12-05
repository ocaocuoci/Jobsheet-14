import java.util.Scanner;
public class tugas1A{
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);

        System.out.print("Inputkan nilai n: ");
        int n = input.nextInt();

        cetakNilaiRekrusif(n);
        input.close();

    }
    public static int hitungRekrusif(int n){
        if (n <= 1){
            return n;
        }
        return n + hitungRekrusif(n - 1);
    }
    public static void cetakNilaiRekrusif(int n){
        System.out.println("Perhitungan Rekrusif: ");

        for (int i = 1; i <= n; i++){
            int hasil = hitungRekrusif(i);
            System.out.println("angka ke-" + i + " = " + hasil);
        }
    }
}