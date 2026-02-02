import java.util.InputMismatchException;
import java.util.Scanner;

public class tugas3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();
        double nilai = 0;
        while (true){
            try {
                System.out.print("Masukkan nilai akhir: ");
                nilai = sc.nextDouble();
                if(nilai<0||nilai>100){
                    throw new InvalidScoreException("Nilai harus berada di range 0-100");
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("input harus berupa angka");
                sc.nextLine();
            }catch (InvalidScoreException e){
                System.out.println(e.getMessage());
            }
        }
        String status;
        if(nilai>=60){
            status = "lulus";
        }else{
            status = "tidak lulus";
        }
        System.out.println("\n--- Hasil Kelulusan ---");
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("Nilai Ujian    : " + nilai);
        System.out.println("Status         : " + status);
        sc.close();
    }
}
