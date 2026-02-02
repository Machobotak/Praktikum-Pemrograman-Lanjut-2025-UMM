package org.example;
import org.json.JSONObject;

public class Bill implements IBillCalculator {
    public static final int ADMIN_FEE = 2500;
    public static final double TAX_RATE =0.05;

    private double wifi;
    private  double listrik;
    private int penghuni;
    private String lokasi;

    public Bill(double wifi, double listrik, int penghuni, String lokasi) {
        this.wifi = wifi;
        this.listrik = listrik;
        this.penghuni = penghuni;
        this.lokasi = lokasi;
    }

    public Bill(JSONObject obj){
        this.lokasi=obj.getString("lokasi");
        this.wifi=obj.getDouble("wifi");
        this.listrik=obj.getDouble("listrik");
        this.penghuni=obj.getInt("penghuni");
    }
    public Bill() {
        this.lokasi = "";
        this.wifi = 0;
        this.listrik = 0;
        this.penghuni = 0;
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("lokasi",lokasi);
        obj.put("wifi",wifi);
        obj.put("listrik",listrik);
        obj.put("penghuni",penghuni);
        return obj;
    }

    @Override
    public void printSummary() {
        System.out.println("Lokasi  : "+lokasi);
        System.out.println("Wi-fi   : Rp "+wifi);
        System.out.println("Listrik : Rp "+listrik);

        double pajak = (wifi+listrik)*TAX_RATE;
        double total = calculatedTotal(ADMIN_FEE,pajak);
        double perOrang = calculatedPerPerson(total);

        System.out.println("Total       : Rp "+total);
        System.out.println("Per Orang   : Rp "+perOrang);
        System.out.println("Per Orang (diskon 10%): Rp "+calculatedDiscount(perOrang));
        System.out.println("-------------------------------");
    }

    private double calculatedDiscount(double perOrang){
        return perOrang-(perOrang*0.1);
    }

    @Override
    public double calculatedPerPerson(double total) {
        return total/penghuni;
    }

    @Override
    public double calculatedTotal(double admin, double pajak) {
        return wifi+listrik+admin+pajak;
    }

    public double getWifi() {
        return wifi;
    }

    public void setWifi(double wifi) {
        this.wifi = wifi;
    }

    public double getListrik() {
        return listrik;
    }

    public void setListrik(double listrik) {
        this.listrik = listrik;
    }

    public int getPenghuni() {
        return penghuni;
    }

    public void setPenghuni(int penghuni) {
        this.penghuni = penghuni;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    @Override
    public String toString() {
        return String.format("Lokasi: %s | Wifi: %.0f | Listrik: %.0f | Penghuni: %d",
                lokasi, wifi, listrik, penghuni);
    }

}
