package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data_mahasiswa.xlsx");
        Scanner input = new Scanner(System.in);
        Set<String> namaTerpakai = new HashSet<>();
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Workbook wb = new XSSFWorkbook(fis)) {
                Sheet s = wb.getSheetAt(0);
                int lastRow = s.getLastRowNum();

                for (int i = 1; i <= lastRow; i++) {
                    Row row = s.getRow(i);
                    if (row != null && row.getCell(0) != null) {
                        String namaDiFile = row.getCell(0).getStringCellValue();
                        namaTerpakai.add(namaDiFile.toLowerCase());
                    }
                }
            } catch (IOException e) {
                System.out.println("Gagal membaca data lama: " + e.getMessage());
            }
        }
        System.out.println("Masukkan data mahasiswa. Ketik 'selesai' pada nama untuk mengakhiri");


        while (true){
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine().trim().toLowerCase();

            if(nama.equalsIgnoreCase("selesai")){
                System.out.println("Terima Kasih !");
                break;
            }
            if (namaTerpakai.contains(nama)){
                System.out.println("Nama sudah ada, masukkan nama yang berbeda !");
                continue;
            }
            System.out.print("Masukkan Semester: ");
            int semester;
            try {
                semester = Integer.parseInt(input.nextLine().trim());
                if (semester<1||semester>14){
                    System.out.println("semester harus kurang dari 15 dan lebih dari 0");
                    continue;
                }
            }catch (Exception e){
                System.out.println("input Harus angka");
                continue;
            }
            System.out.print("Masukkan Mata Kuliah: ");
            String mataKuliah = input.nextLine().trim();

            try {
                Workbook workbook;
                Sheet sheet;
                if (file.exists()){
                    try(FileInputStream fis = new FileInputStream(file)) {
                        workbook = new XSSFWorkbook(fis);
                        sheet = workbook.getSheetAt(0);
                    }
                }else {
                    workbook = new XSSFWorkbook();
                    sheet = workbook.createSheet("Data Mahasiswa");
                    Row header = sheet.createRow(0);
                    header.createCell(0).setCellValue("Nama");
                    header.createCell(1).setCellValue("Semester");
                    header.createCell(2).setCellValue("Mata Kuliah");
                }
                int lastRow = sheet.getLastRowNum();
                Row row = sheet.createRow(lastRow+1);

                row.createCell(0).setCellValue(nama);
                row.createCell(1).setCellValue(semester);
                row.createCell(2).setCellValue(mataKuliah);

                try(FileOutputStream fos = new FileOutputStream(file)) {
                    workbook.write(fos);
                }
                workbook.close();
                namaTerpakai.add(nama);

            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }

}