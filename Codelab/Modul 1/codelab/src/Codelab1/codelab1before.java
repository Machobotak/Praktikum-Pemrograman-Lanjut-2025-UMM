package Codelab1;

public class codelab1before {
    public static void main(String[] args) {
        String []nama = {"Adi","Budi","Cahyo","Diana","Eva"};
        String namaTerpanjang = cariNamaterpanjang(nama);
        System.out.println("nama terpanjang adalah: "+namaTerpanjang);
    }

    public static String cariNamaterpanjang(String[]array){
        String namaMax = array[0];
        for(String nama : array){
            if (nama.length()>namaMax.length()){
                namaMax = nama;
            }
        }
        return namaMax;
    }
}
