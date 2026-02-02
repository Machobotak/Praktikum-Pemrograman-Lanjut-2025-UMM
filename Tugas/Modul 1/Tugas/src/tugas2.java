import java.util.InputMismatchException;
import java.util.Scanner;

public class tugas2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n;
        while (true) {
            try {
                System.out.print("masukkan angka positif: ");
                n = sc.nextDouble();
                if (n <= 0) {
                    throw new InvalidNumberException("Angka harus positif");
                }
                System.out.println("input valid: "+n);
                break;
            } catch (InputMismatchException e) {
                System.out.println("input tidak valid. masukkan angka");
                sc.nextLine();
            }catch (InvalidNumberException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}
