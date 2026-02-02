
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//API
        System.out.print("Masukkan jumlah uang: ");
        double jumlahUang;
        try {
            jumlahUang = input.nextDouble();//API
        }catch (Exception e){
            System.out.println("Input jumlah uang harus angka.");
            input.close();//API
            return;
        }
        input.nextLine();//API
        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String tanggalStr = input.nextLine();//API
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        Date tanggal;
        try {
            tanggal = sdf.parse(tanggalStr);
        }catch (ParseException e){
            System.out.println("Format tanggal salah. Gunakan dd-MM-yyyy (contoh: 10-12-2025).");
            input.close();
            return;
        }

        Locale[] locales={
                new Locale("ja","JP"),
                new Locale("pt", "PT"),
                new Locale("en","AU")
        };
        System.out.println();

        for (Locale locale : locales){
            tampilkanFormat(locale,jumlahUang,tanggal);
            System.out.println();
        }
        input.close();
    }
    private static void tampilkanFormat(Locale locale, double jumlah, Date tanggal) {
        Currency currency = Currency.getInstance(locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);//API FORMAT UANG SESUAI NEGARA
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);//FORMAT TANGGAL SESSUAI NEGARANYA
        System.out.println("=== Locale: " + locale + " ===");
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Currency Code: " + currency.getCurrencyCode());
        System.out.println("Currency Symbol: " + currency.getSymbol(locale));
        System.out.println("Formatted currency: " + currencyFormat.format(jumlah));
        System.out.println("Formatted date: " + dateFormat.format(tanggal));
    }
}
