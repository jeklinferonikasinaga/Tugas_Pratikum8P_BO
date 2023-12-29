package Nomor4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class PanelInsert extends JPanel {
    PanelInsert (){
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        JLabel tittle = new JLabel("Insert Nilai");
        tittle.setBounds(90,5,200,50);
        tittle.setFont(new Font("Poppins",Font.BOLD,14));

        JLabel labelKD = new JLabel("Kode MK : ");
        labelKD.setBounds(10,40,100,50);
        labelKD.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField kd = new JTextField();
        kd.setBounds(10,80,230,30);

        JLabel labelMK = new JLabel("Nama MK : ");
        labelMK.setBounds(10,100,100,50);
        labelMK.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField mk = new JTextField();
        mk.setBounds(10,140,230,30);


        JLabel labelSKS = new JLabel("SKS : ");
        labelSKS.setBounds(10,160,100,50);
        labelSKS.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField sks = new JTextField();
        sks.setBounds(10,200,230,30);

        JLabel labelNilai = new JLabel("Nilai : ");
        labelNilai.setBounds(10,220,100,50);
        labelNilai.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField nilai = new JTextField();
        nilai.setBounds(10,260,230,30);

        JButton tombolInsert =new JButton("Insert");
        tombolInsert.setBounds(10,300,230,30);
        tombolInsert.addActionListener(e -> {
            String kodeMK = kd.getText();
            String namaMK = mk.getText();
            String sksValue = sks.getText();
            String nilaiValue = nilai.getText();

            // Validate input if needed

            Vector<Object> rowData = new Vector<>();
            rowData.add(kodeMK);
            rowData.add(namaMK);
            rowData.add(sksValue);
            rowData.add(nilaiValue);

            // Add data to the data controller
            DataCenter.getInstance().addData(rowData);

            try {
                File d = new File(DataCenter.fileTerbuka);
                Files.writeString(d.toPath(),"\n"+kodeMK+";"+namaMK+";"+sksValue+";"+nilaiValue, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            kd.setText("");
            mk.setText("");
            sks.setText("");
            nilai.setText("");
        });


        add(labelKD);
        add(labelMK);
        add(labelSKS);
        add(labelNilai);
        add(kd);
        add(mk);
        add(sks);
        add(nilai);
        add(tittle);
        add(tombolInsert);
    }
}
