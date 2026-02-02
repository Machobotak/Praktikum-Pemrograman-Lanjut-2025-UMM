package Codelab2;

import java.util.Scanner;

public class codelab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan umur kamu: ");
            int umur = sc.nextInt();
            if(umur <= 0 || umur >= 120){
                throw new InvalidAgeException("Usia tidak valid! usia harus lebih dari 0 dan kurang dari 120");
            }
            System.out.println("umur kamu: "+umur);
        }catch (InvalidAgeException e){
            System.out.println("Error: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Input tidak valid silahkan masukkan angka");
        }
        sc.close();

    }
}
