package Nomor3;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUang extends JPanel {
    private JTextField inputAwal;
    private JTextField result;
    private JLabel awalLabel = new JLabel();
    private JLabel akhirLabel = new JLabel();
    private String awal = "Rupiah";
    private String akhir = "Dollar";


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

    public PanelUang(){
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);


        JLabel judul = new JLabel("Konversi Uang");
        judul.setBounds(115,30,250,50);
        judul.setFont(new Font("Poppins",Font.BOLD,26));
        add(judul);

        awalLabel.setText(getAwal());
        awalLabel.setBounds(70,100,250,50);
        awalLabel.setFont(new Font("Poppins",Font.BOLD,16));
        add(awalLabel);

        akhirLabel.setText(getAkhir());
        akhirLabel.setBounds(270,100,250,50);
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

        if (awal.equals("Rupiah")){
            double angka = Double.parseDouble(inputAwal.getText());

            double hasil = angka/15522;
            result.setText("$."+hasil);

        } else if (awal.equals("Dollar")) {
            double angka = Double.parseDouble(inputAwal.getText());

            double hasil = angka*15.522;
            result.setText("Rp."+hasil);
        }
    }
}
