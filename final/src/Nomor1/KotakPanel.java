package Nomor1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KotakPanel extends JPanel {
    public String[] satuan ={"KM","HM","DAM","M","DM","CM","MM"};
   public JLabel judul1,judul2,judul3;
    private JTextField input,output;
    private  JComboBox inputCombo,outputcombo;
    private JButton tombol;
    public KotakPanel(){
        setBackground(Color.WHITE);

        judul2 = new JLabel("Awal :");
        judul3 = new JLabel("Hasil:");
        input = new JTextField(10);
        output = new JTextField(10);
        output.setEditable(false);
        inputCombo =  new  JComboBox<>(satuan);
        inputCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kerjakan();
            }
        });
        outputcombo = new JComboBox<>(satuan);
        outputcombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kerjakan();
            }
        });
        tombol = new JButton("Convert");
        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kerjakan();
            }
        });


        add(judul2);
        add(input);
        add(inputCombo);
        add(tombol);
        add(judul3);
        add(output);
        add(outputcombo);





    }
    public void kerjakan (){
        double awal = Double.parseDouble(input.getText());
        String satuanAwal = String.valueOf(inputCombo.getSelectedItem());
        String satuanAkhir = String.valueOf(outputcombo.getSelectedItem());
        output.setText(String.valueOf(hitung(awal,satuanAwal,satuanAkhir)));

    }
    public  double hitung (double awal,String satuanAwal,String satuanAkhir){
        double tampungan = awal;
        switch (satuanAwal) {
            case "KM":
                tampungan *= 1000;
                break;
            case "HM":
                tampungan *= 100;
                break;
            case "DAM":
                tampungan *= 10;
                break;
            case "M":
                break;
            case "DM":
                tampungan /= 10;
                break;
            case "CM":
                tampungan /= 100;
                break;
            case "MM":
                tampungan /= 1000;
                break;
        }
        switch (satuanAkhir){
            case "KM":
                tampungan/=1000;
                break;
            case "HM":
                tampungan/=100;
                break;
            case "DAM":
                tampungan/=10;
                break;
            case "M":
                break;
            case"DM":
                tampungan*=10;
                break;
            case"CM":
                tampungan*=100;
                break;
            case"MM":
                tampungan*=1000;
                break;



        }
        return tampungan;
    }
}

