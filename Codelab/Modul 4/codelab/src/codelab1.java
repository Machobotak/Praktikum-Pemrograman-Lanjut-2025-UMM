import java.util.Scanner;

public class codelab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Kalimat: ");
        String kalimat = sc.nextLine();

        String[] ArrayKata = kalimat.split(" ");//implemntasi api
        if (ArrayKata.length>=2){
            System.out.println("Kata kedua: "+ArrayKata[1]);
        }else {
            System.out.println("Kalimat tidak memiliki dua kata");
        }

        String kapital = kalimat.toUpperCase();//implementasu api
        System.out.println("Huruf kapital: "+kapital);

        boolean mengandungJava = kalimat.toLowerCase().contains("java");//implemnetasi api
        System.out.println("Apakah mengandung kata 'java'? : "+mengandungJava);

        System.out.print("Masukan kata/kalimat untuk ditambahkan di akhir: ");
        String tambahKalimat = sc.nextLine();
        StringBuilder sb = new StringBuilder(kalimat);
        sb.append(" ").append(tambahKalimat);//implemnetasi api
        String kalimatBaru = sb.toString();//implemnetasi api
        System.out.println("Setelah menambah kata/kalimat : "+kalimatBaru );

        StringBuilder balik = new StringBuilder(kalimatBaru);
        balik.reverse();//implemnetasi api
        System.out.println("Kalimat terbalik: "+balik.toString());//implemnetasi api

    }
}