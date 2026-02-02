package org.example.ui;

import org.example.Bill;
import org.example.BillData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class formInputFrame extends JFrame {
    private JTextField lokasiField, wifiField, listrikField, penghuniField;
    private JButton submitButton, lihatDataButton;
    private BillData billData;

    public formInputFrame(){
        billData = new BillData();
        initUI();
    }

    private void initUI(){
        setTitle("Input Tagihan Kost");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JLabel title = new JLabel("Form Input Tagihan Kost",SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI",Font.BOLD,18));
        title.setForeground(new Color(30,215,96));
        add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel lokasiLabel = new JLabel("Lokasi:");
        JLabel wifiLabel = new JLabel("Wifi (Rp):");
        JLabel listrikLabel = new JLabel("Listrik (Rp):");
        JLabel penghuniLabel = new JLabel("Jumlah Penghuni:");

        lokasiField = new JTextField();
        wifiField = new JTextField();
        listrikField = new JTextField();
        penghuniField = new JTextField();

        formPanel.add(lokasiLabel);
        formPanel.add(lokasiField);
        formPanel.add(wifiLabel);
        formPanel.add(wifiField);
        formPanel.add(listrikLabel);
        formPanel.add(listrikField);
        formPanel.add(penghuniLabel);
        formPanel.add(penghuniField);

        add(formPanel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));

        submitButton = new JButton("Tambah Data");
        lihatDataButton = new JButton("Lihat Data");

        styleButton(submitButton);
        styleButton(lihatDataButton);

        buttonPanel.add(lihatDataButton);
        buttonPanel.add(submitButton);
        add(buttonPanel,BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData();
            }
        });
        lihatDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TableDashboardFrame().setVisible(true);
            }
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

    private void tambahData(){
        String lokasi = lokasiField.getText().trim();
        String wifiText = wifiField.getText().trim();
        String listrikText = listrikField.getText().trim();
        String penghuniText = penghuniField.getText().trim();

        if(lokasi.isEmpty()||wifiText.isEmpty()||listrikText.isEmpty()||penghuniText.isEmpty()){
            JOptionPane.showMessageDialog(this,"Semua Field wajib diisi!","Peringatan",JOptionPane.WARNING_MESSAGE);
        }
        try {
            double wifi = Double.parseDouble(wifiText);
            double listrik = Double.parseDouble(listrikText);
            int penghuni = Integer.parseInt(penghuniText);

            Bill bill = new Bill(wifi,listrik,penghuni,lokasi);
            billData.addBill(bill);

            JOptionPane.showMessageDialog(this,"Data berhasil ditambahkan!","Sukses",JOptionPane.INFORMATION_MESSAGE);

            lokasiField.setText("");
            wifiField.setText("");
            listrikField.setText("");
            penghuniField.setText("");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Wifi,Listrik,dan Penghuni harus berupa angka!","Error",JOptionPane.ERROR_MESSAGE);
        }


    }
}
