package Nomor2;

import javax.swing.*;
import java.awt.*;

public class KonversiNilai extends JFrame {
    KonversiNilai(){
        setTitle("Konversi Nilai");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelNilai pN = new PanelNilai();
        pN.setBounds(45,50,400,300);
        add(pN);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KonversiNilai();
            }
        });
    }
}
