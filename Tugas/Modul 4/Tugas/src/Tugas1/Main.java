package Tugas1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Film> daftarFilm = new ArrayList<>();//API
        daftarFilm.add(new Film("Bleach", 2004));//masukkan film kedalam list
        daftarFilm.add(new Film("Naruto", 2002));
        daftarFilm.add(new Film("One Piece", 1999));
        while (true){
            System.out.println("=== Menu Manajemen  ===");
            System.out.println("1. Film Baru");
            System.out.println("2. Urutkan Berdasarkan Nama Tugas1.Film (A-Z)");
            System.out.println("3. Urutkan Berdasarkan Tahun (Ascending)");
            System.out.println("4. Keluar Program");
            System.out.print("Masukkan Pilihan: ");
            int pilihan=0;
            try {
                pilihan = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("input harus angka");
            }
            switch (pilihan){
                case 1:
                    System.out.print("Masukkan Judul Tugas1.Film: ");
                    String judul = input.nextLine();
                    if(judul.isEmpty()){
                        System.out.println("Judul tidak boleh kosong");
                        return;
                    }
                    int tahun;
                    System.out.print("Masukkan tahun rilis: ");
                    try {
                        tahun  = input.nextInt();
                        input.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Input bukan angka");
                        input.nextLine();
                        return;
                    }
                    daftarFilm.add(new Film(judul,tahun));
                    System.out.println("Tugas1.Film Berhasil ditambahkan");
                    break;
                case 2:
                    Collections.sort(daftarFilm, new Comparator<Film>() {
                        @Override
                        public int compare(Film o1, Film o2) {
                            return o1.getJudulFilm().compareToIgnoreCase(o2.getJudulFilm());
                        }
                    });
                    tampilkan(daftarFilm,"Urutan Nama A-Z");
                    break;
                case 3:
                    Collections.sort(daftarFilm, new Comparator<Film>() {
                        @Override
                        public int compare(Film o1, Film o2) {
                            return Integer.compare(o1.getTahunRilis(),o2.getTahunRilis());
                        }
                    });
                    tampilkan(daftarFilm,"Urut Tahun Ascending");
                    break;
                case 4:
                    System.out.println("Keluar dari program");
                    input.close();
                    return;
                default:
                    System.out.print("pilihan tidak valid\n");
            }
        }

    }
    public static void tampilkan(List<Film>daftarFilm,String keterangan){
        System.out.println("\n === Daftar Tugas1.Film ("+keterangan+") ===");
        if (daftarFilm.isEmpty()){
            System.out.println("Belum ada film");
            return;
        }
        for (Film f : daftarFilm){
            System.out.println(f.toString());
        }
    }
}