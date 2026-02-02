public class Menu {
    String nama;
    double harga;
    int jumlah;

    public Menu(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    double hitungSubtotal(){
        return harga*jumlah;
    }

}
