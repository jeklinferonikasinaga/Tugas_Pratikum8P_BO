package Nomor4;

import javax.swing.*;
import java.awt.*;

public class PanelBio extends JPanel{
    private static JLabel nameLabel,nimLabel,jurusanLabel,semesterLabel;

    PanelBio(){
        setBackground(Color.white);
        setLayout(null);
        nameLabel = new JLabel("Nama        : ");
        nameLabel.setBounds(10,5,350,30);
        nameLabel.setFont(new Font("Poppins",Font.PLAIN,16));

        add(nameLabel);

        nimLabel = new JLabel("NIM           : ");
        nimLabel.setBounds(10,35,350,30);
        nimLabel.setFont(new Font("Poppins",Font.PLAIN,16));
        add(nimLabel);

        jurusanLabel = new JLabel("Jurusan    : ");
        jurusanLabel.setBounds(10,65,350,30);
        jurusanLabel.setFont(new Font("Poppins",Font.PLAIN,16));
        add(jurusanLabel);

        semesterLabel = new JLabel("Semester  : ");
        semesterLabel.setBounds(10,95,350,30);
        semesterLabel.setFont(new Font("Poppins",Font.PLAIN,16));
        add(semesterLabel);


    }
    public static void update(){
        nameLabel.setText("Nama        : "+DataCenter.identitas[0]);
        nimLabel.setText("NIM           : "+DataCenter.identitas[1]);
        jurusanLabel.setText("Jurusan    : "+DataCenter.identitas[2]);

        semesterLabel.setText("Semester  : "+DataCenter.identitas[3]);
    }
    public  static  void reset(){
        nameLabel.setText("Nama        : ");
        nimLabel.setText("NIM           : ");
        jurusanLabel.setText("Jurusan    : ");
        semesterLabel.setText("Semester  : ");
    }
}
