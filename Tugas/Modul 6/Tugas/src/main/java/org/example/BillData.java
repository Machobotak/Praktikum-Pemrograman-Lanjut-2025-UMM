package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillData {
    private static final String FILE_PATH = "bills.json";
    private List<Bill> bills;

    public BillData(){
        bills = new ArrayList<>();
        loadData();
    }

    public void  loadData(){
        bills.clear();
        File file = new File(FILE_PATH);
        if (!file.exists()){
            try {
                file.createNewFile();
                saveData();
            }catch (IOException e){
                System.err.println("Gagal membuat file JSON: "+e.getMessage());
            }
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line);
            }
            if (sb.length()>0){
                JSONArray arr = new JSONArray(sb.toString());
                for (int i=0;i<arr.length();i++){
                    JSONObject obj = arr.getJSONObject(i);
                    bills.add(new Bill(obj));
                }
            }
        }catch (Exception e){
            System.err.println("Gagal membaca file JSON: "+e.getMessage());
        }
    }

    public void saveData(){
        JSONArray arr = new JSONArray();
        for(Bill bill : bills){
            arr.put(bill.toJSON());
        }
        try(FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(arr.toString(4));
            file.flush();
        }catch (IOException e){
            System.err.println("Gagal Menyimpan data ke JSON: "+e.getMessage());
        }
    }

    public void addBill(Bill bill){
        bills.add(bill);
        saveData();
    }

    public void updateBill(int index, Bill updatedBill){
        if(index>=0&&index<bills.size()){
            bills.set(index,updatedBill);
            saveData();
        }
    }
    public void deleteBill(int index){
        if(index>=0&&index<bills.size()){
            bills.remove(index);
            saveData();
        }
    }

    public List<Bill>getBills(){
        return bills;
    }

    public boolean isEmpty(){
        return bills.isEmpty();
    }
}
