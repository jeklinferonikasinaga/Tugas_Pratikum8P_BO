package Nomor2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNilai extends JPanel {
    private JTextField inputAwal;
    private JTextField result;
    private JLabel awalLabel = new JLabel();
    private JLabel akhirLabel = new JLabel();
    private String awal = "Nilai Angka";
    private String akhir = "Nilai Huruf";


    public String getAwal() {
        return awal;
    }

    public void setAwal(String awal) {
        this.awal = awal;
    }

    public String getAkhir() {
        return akhir;
    }

    public void setAkhir(String akhir) {
        this.akhir = akhir;
    }

    public PanelNilai(){
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);


        JLabel judul = new JLabel("Konversi Nilai");
        judul.setBounds(115,30,250,50);
        judul.setFont(new Font("Poppins",Font.BOLD,26));
        add(judul);

        awalLabel.setText(getAwal());
        awalLabel.setBounds(70,100,250,50);
        awalLabel.setFont(new Font("Poppins",Font.BOLD,16));
        add(awalLabel);

        akhirLabel.setText(getAkhir());
        akhirLabel.setBounds(230,100,250,50);
        akhirLabel.setFont(new Font("Poppins",Font.BOLD,16));
        add(akhirLabel);
        JButton tombolSwicth = new JButton("⇆");
        tombolSwicth.setBounds(165,118,55,20);
        tombolSwicth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tukar();
                ubah();

            }
        });
        add(tombolSwicth);
        inputAwal = new JTextField(10);
        inputAwal.setBounds(85,150,210,30);
        inputAwal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ubah();
            }
        });
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        inputAwal.setBorder(border);
        add(inputAwal);
        result = new JTextField();
        result.setBounds(85,200,210,30);
        result.setEditable(false);
        add(result);

        JButton tombol = new JButton("Convert");
        tombol.setBounds(140,250,100,30);
        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ubah();
            }
        });
        add(tombol);
    }
    public void tukar(){
        String tamp = getAwal();
        setAwal(getAkhir());
        setAkhir(tamp);
        awalLabel.setText(getAwal());
        akhirLabel.setText(getAkhir());

    }
    public void ubah (){

        if (awal.equals("Nilai Angka")){
            int angka = Integer.parseInt(inputAwal.getText());
            if(angka>=85 && angka<=100){
                result.setText("A");
            } else if (angka>=80 && angka<85) {
                result.setText("A-");
            }else if (angka>=75 && angka<80){
                result.setText("B+");
            } else if (angka<75 && angka>=70) {
                result.setText("B");
            }else if (angka>=65 && angka<70){
                result.setText("B-");
            }else if (angka>=50 && angka<65){
                result.setText("C");
            }else if (angka>=40 && angka<50){
                result.setText("D");
            }else if (angka<40 && angka>=0){
                result.setText("E");
            } else if (angka>100 || angka <0) {
                result.setText("Nilai Tidak Cocok");
            }else {
                result.setText("Input Nilai Tidak Cocok");
            }
        } else if (awal.equals("Nilai Huruf")) {
            String huruf = inputAwal.getText();
            if (huruf.equals("A")){
                result.setText("85 - 100");
            } else if (huruf.equals("A-")) {
                result.setText("80 - 84");
            }else if (huruf.equals("B+")) {
                result.setText("75 - 79");
            }else if (huruf.equals("B")) {
                result.setText("70 - 74");
            }else if (huruf.equals("B-")) {
                result.setText("65 - 69");
            }else if (huruf.equals("C")) {
                result.setText("50 - 64");
            }else if (huruf.equals("D")) {
                result.setText("40 - 49");
            }else if (huruf.equals("E")) {
                result.setText("0 - 39");
            }else {
                result.setText("Nilai Tidak Sesuai");
            }

        }
    }
}
