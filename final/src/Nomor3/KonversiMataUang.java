package Nomor3;

import javax.swing.*;
import java.awt.*;

public class KonversiMataUang extends JFrame {
    KonversiMataUang(){
        setTitle("Konversi Uang");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelUang pN = new PanelUang();
        pN.setBounds(45,50,400,300);
        add(pN);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KonversiMataUang();
            }
        });
    }
}
