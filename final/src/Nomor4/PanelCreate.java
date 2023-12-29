package Nomor4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class PanelCreate extends JPanel {
    PanelCreate(){
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        JLabel tittle = new JLabel("Create File");
        tittle.setBounds(90,0,200,30);
        tittle.setFont(new Font("Poppins",Font.BOLD,12));
        add(tittle);
        JLabel labelNama = new JLabel("Nama : ");
        labelNama.setBounds(10,20,100,50);
        labelNama.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField nama = new JTextField();
        nama.setBounds(10,60,230,30);


        JLabel labelNIM = new JLabel("NIM : ");
        labelNIM.setBounds(10,80,100,50);
        labelNIM.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField nim = new JTextField();
        nim.setBounds(10,120,230,30);


        JLabel labelJurusan = new JLabel("Jurusan : ");
        labelJurusan.setBounds(10,140,100,50);
        labelJurusan.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField jurusan = new JTextField();
        jurusan.setBounds(10,180,230,30);

        JLabel labelSemester = new JLabel("Semester : ");
        labelSemester.setBounds(10,200,100,50);
        labelJurusan.setFont(new Font("Poppins",Font.PLAIN,12));
        JTextField semester = new JTextField();
        semester.setBounds(10,240,230,30);
        add(labelJurusan);
        add(jurusan);
        add(labelNIM);
        add(nim);
        add(labelSemester);
        add(semester);
        add(labelNama);
        add(nama);

        JButton tombolCreate =new JButton("Create");
        tombolCreate.setBounds(10,290,230,30);
        add(tombolCreate);
        tombolCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buat(nama.getText(),nim.getText(),jurusan.getText(),semester.getText());
                nama.setText("");
                nim.setText("");
                jurusan.setText("");
                semester.setText("");
            }
        });

    }
    public void buat(String nama,String nim,String jurusan,String semester){
        try {
            String namaFile = nama+".csv" ;
            StringBuffer sb =new StringBuffer();
            sb.append(nama+';'+nim+';'+jurusan+';'+semester);
            File f = new File("C:\\PBO CODE\\FinalBOSS\\src\\Nomor4\\Data\\"+namaFile);
            Files.writeString(f.toPath(),sb.toString());
            File d = new File("C:\\PBO CODE\\FinalBOSS\\src\\list.txt");
            Files.writeString(d.toPath(),namaFile+"\n", StandardOpenOption.APPEND);
            Vector<Object>tamp = new Vector<>();
            tamp.add(namaFile);
            DataList.getInstance().addData(tamp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
