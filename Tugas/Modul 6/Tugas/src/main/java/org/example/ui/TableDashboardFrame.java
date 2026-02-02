package org.example.ui;

import org.example.Bill;
import org.example.BillData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TableDashboardFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private BillData billData;

    public TableDashboardFrame(){
        billData = new BillData();
        initUI();
        loadTableData();
    }

    private void initUI(){
        setTitle("Dashboard Data Tagihan");
        setSize(650,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JLabel title = new JLabel("Data Tagihan Kost",SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI",Font.BOLD,18));
        title.setForeground(new Color(30,215,96));
        add(title,BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Lokasi","Wi-Fi","Listrik","Penghuni"},0);
        table = new JTable(tableModel);
        table.setRowHeight(24);
        table.setFont(new Font("Segoe UI",Font.PLAIN,13));
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,13));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));

        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Hapus");
        JButton backBtn = new JButton("Kembali");
        JButton summaryBtn = new JButton("Lihat Summary");

        styleButton(editBtn);
        styleButton(deleteBtn);
        styleButton(backBtn);
        styleButton(summaryBtn);

        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(backBtn);
        buttonPanel.add(summaryBtn);

        add(buttonPanel,BorderLayout.SOUTH);

        editBtn.addActionListener(e -> editData());
        deleteBtn.addActionListener(e -> deleteData());
        summaryBtn.addActionListener(e -> showSummary());
        backBtn.addActionListener(e -> {
            dispose();
            new formInputFrame().setVisible(true);
        });



    }
    private void styleButton(JButton button){
        button.setBackground(new Color(30,215,96));
        button.setForeground(Color.white);
        button.setFont(new Font("Roboto",Font.BOLD,14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void loadTableData(){
        tableModel.setRowCount(0);
        List<Bill> bills = billData.getBills();

        for(Bill bill : bills){
            tableModel.addRow(new Object[]{
                    bill.getLokasi(),
                    bill.getWifi(),
                    bill.getListrik(),
                    bill.getPenghuni()
            });
        }
    }

    private void editData(){
        int row = table.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this,"Pilih data yang ingin diedit!");
            return;
        }
        Bill bill = billData.getBills().get(row);
        JTextField lokasiField = new JTextField(bill.getLokasi());
        JTextField wifiField = new JTextField(String.valueOf(bill.getWifi()));
        JTextField listrikField = new JTextField(String.valueOf(bill.getListrik()));
        JTextField penghuniField = new JTextField(String.valueOf(bill.getPenghuni()));

        Object[]message = {
                "Lokasi:",lokasiField,
                "Wi-Fi:",wifiField,
                "Listrik:",listrikField,
                "Penghuni:",penghuniField
        };

        int option = JOptionPane.showConfirmDialog(this,message,"Edit Data",JOptionPane.OK_CANCEL_OPTION);
        if(option==JOptionPane.OK_OPTION){
            try {
                Bill updatedBill = new Bill(
                        Double.parseDouble(wifiField.getText()),
                        Double.parseDouble(listrikField.getText()),
                        Integer.parseInt(penghuniField.getText()),
                        lokasiField.getText()
                );
                billData.updateBill(row,updatedBill);
                loadTableData();
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this,"Input angka tidak valid");
            }
        }

    }

    private void deleteData(){
        int row = table.getSelectedRow();
        if (row==-1){
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!");
            return;
        }
        Bill bill = billData.getBills().get(row);
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm==JOptionPane.YES_OPTION){
            billData.deleteBill(row);
            loadTableData();
        }
    }
    private void showSummary(){
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih satu data terlebih dahulu!");
            return;
        }

        Bill bill = billData.getBills().get(row);

        double pajak = (bill.getWifi() + bill.getListrik()) * Bill.TAX_RATE;
        double total = bill.calculatedTotal(Bill.ADMIN_FEE, pajak);
        double perOrang = bill.calculatedPerPerson(total);
        double setelahDiskon = perOrang - (perOrang * 0.1);

        String message =
                "Lokasi: " + bill.getLokasi() + "\n\n" +
                        "Wi-Fi      : Rp " + bill.getWifi() + "\n" +
                        "Listrik    : Rp " + bill.getListrik() + "\n" +
                        "Admin      : Rp " + Bill.ADMIN_FEE + "\n" +
                        "Pajak (5%) : Rp " + pajak + "\n\n" +
                        "Total Tagihan : Rp " + total + "\n" +
                        "Jumlah Penghuni : " + bill.getPenghuni() + "\n\n" +
                        "Per Orang : Rp " + String.format("%.2f",perOrang) + "\n" +
                        "Per Orang (Diskon 10%) : Rp " + String.format("%.2f",setelahDiskon);

        JOptionPane.showMessageDialog(
                this,
                message,
                "Ringkasan Tagihan",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
