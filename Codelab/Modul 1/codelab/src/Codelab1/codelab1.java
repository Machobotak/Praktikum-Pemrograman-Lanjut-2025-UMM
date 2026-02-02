package Codelab1;
public class codelab1 {
    public static void main(String[] args) {
        String[] nama = {"Adi","Budi","Cahyo","Diana","Eva","ibrahim"};
        cariNamaTerpanjang(nama);
    }
    public static void cariNamaTerpanjang(String[]array){
        int maxLength = array[0].length();
        for(String nama : array){
            if(nama.length()>maxLength){
                maxLength = nama.length();
            }
        }
        System.out.println("nama terpanjang adalah");
        for(String nama : array){
            if(nama.length()==maxLength){
                System.out.println("- "+nama);
            }
        }
    }
}