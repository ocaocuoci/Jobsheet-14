import java.util.Scanner;
public class tugas1B{
   public static void main(String[] args){
    Scanner input =new Scanner(System.in);

    System.out.print("Inputkan nilai n: ");
    int n = input.nextInt();

    cetakNilaiIteratif(n);
   }
   public static int hitungIteratig(int n){
    int total = 0;

    for (int i = 1; i <= n; i++){
        total += i;
    }
    return total;
   }
   public static void cetakNilaiIteratif( int n){
    System.out.println("Perhitungan iteratif: ");

    for(int i = 1; i <=n; i++){
        System.out.println("Nilai ke-" + i + "= " + hitungIteratig(i));
    }
   }
    
}