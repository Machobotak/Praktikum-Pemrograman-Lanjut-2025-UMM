import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Aplikasi Nota Pemenasan ===");
        System.out.print("Nama Menu: ");
        String nama = sc.nextLine();

        System.out.print("Harga satuan: ");
        double harga = sc.nextDouble();

        System.out.print("Jumlah: ");
        int jumlah = sc.nextInt();

        System.out.print("Apakah pelanggan member? (y/n): ");
        char member = sc.next().charAt(0);

        Menu menu = new Menu(nama,harga,jumlah);
        NotaRestoran nota = new NotaRestoran();
        nota.isMember = (member == 'y' || member =='Y');

        nota.cetakNota(menu);


    }
}