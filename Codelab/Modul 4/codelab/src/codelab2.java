import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class codelab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int pilihan = 0;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Menghasilkan Bilangan Bulat Acak");
            System.out.println("2. Mengambil Karakter Acak dari String");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            try {
                pilihan = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("input tidak valid");
                sc.nextLine();
            }

            switch (pilihan){
                case 1:
                    try {
                        System.out.print("Masukkan nilai minimum: ");
                        int min = sc.nextInt();
                        System.out.print("Masukkan nilai maksimal: ");
                        int max = sc.nextInt();
                        if(min>max){
                            System.out.print("min harus lebih kecil dari max");
                            return;
                        }
                        int randomNumber = random.nextInt((max-min)+1)+min;//implemnetasi api
                        System.out.println("bilangan bulat acak antara "+min+" dan "+max+": "+randomNumber);
                    }catch (NumberFormatException e){
                        System.out.println("Input tidak valid");
                        sc.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Input harus bilangan bulat");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("Masukkan sebuah kata: ");
                    String kata = sc.nextLine();
                    if (kata.isEmpty()){
                        System.out.println("String kosong. Masukkan minimal satu huruf");
                        return;
                    }else {
                        int indeks = random.nextInt(kata.length());//implemnetasi api
                        char randomChar = kata.charAt(indeks);
                        System.out.println("Karakter acak dari string: "+randomChar);
                    }
                    break;
                case 3:
                    System.out.println("keluar dari program");
                    break;
                default:
                    System.out.println("pilihan tidak valid");
                    break;
            }

        }while (pilihan!=3);

    }
}
