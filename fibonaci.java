import java.util.Scanner;

public class fibonaci{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);

    System.out.print("Input jumlah deret: ");
    int n = input.nextInt();

        System.out.println("Deret fibonaci: ");
        for(int i = 0; i < n; i++){
        System.out.print(fibonaci(i) + " ");
      }
    }
    public static int fibonaci(int n){
        if (n <= 1){
            return n;
        }
        return fibonaci(n - 1) + fibonaci(n - 2);
    }
}
