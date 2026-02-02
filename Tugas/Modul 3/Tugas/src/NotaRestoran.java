public class NotaRestoran {
    boolean isMember;
    double pajakRate = 0.12;
    double discountRate = 0.10;

    double hitungTotal(Menu menu){
        double subtotal = menu.hitungSubtotal();
        double diskon;
        if (isMember) {
            diskon = subtotal * discountRate ;
        } else {
            diskon = 0;
        }
        double pajak = (subtotal - diskon) *pajakRate ;
        double total = subtotal - diskon + pajak;
        return total;
    }

    void cetakNota(Menu menu){
        double subtotal = menu.hitungSubtotal();
        double diskon;
        if (isMember) {
            diskon = subtotal * discountRate;
        } else {
            diskon = 0;
        }
        double pajak = (subtotal - diskon) * pajakRate;
        double total = hitungTotal(menu);

        System.out.println("\n======= NOTA PEMBAYARAN =======");
        System.out.println("Nama Menu : " + menu.nama);
        System.out.println("Harga     : Rp" + menu.harga);
        System.out.println("Jumlah    : " + menu.jumlah);
        System.out.println("--------------------------------");
        System.out.println("Subtotal  : Rp" + subtotal);
        System.out.println("Diskon    : Rp" + diskon);
        System.out.println("Pajak 11% : Rp" + pajak);
        System.out.println("--------------------------------");
        System.out.println("Total Bayar: Rp" + total);
        System.out.println("================================");
        System.out.println()
        ;

    }





}
