import java.util.InputMismatchException;
import java.util.Scanner;

public class tugas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                System.out.print("masukkan berapa angka yang akan dihitung rata ratanya: ");
                n = sc.nextInt();
                if (n<=0){
                    System.out.println("jumlah harus lebih dari 0. coba lagi");
                    continue;
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("input harus angka. coba lagi");
                sc.nextLine();
            }
        }
        int[] angka = new int[n];
        int total = 0;
        for (int i = 0;i<n;i++){
            while (true) {
                try {
                    System.out.print("masukkan angka ke-" + (i + 1) + ": ");
                    angka[i] = sc.nextInt();
                    sc.nextLine();
                    total += angka[i];
                    break;
                }catch (InputMismatchException e){
                    System.out.println("input harus berupa angka. coba lagi");
                    sc.nextLine();
                }
            }
        }
        double rataRata = (double) total/n;
        System.out.println("Rata-rata adalah: "+rataRata);
        sc.close();
    }
}