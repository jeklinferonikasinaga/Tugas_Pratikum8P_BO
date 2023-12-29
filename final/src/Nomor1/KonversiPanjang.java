package Nomor1;

import javax.swing.*;
import java.awt.*;


public class KonversiPanjang extends JFrame {
    KonversiPanjang(){
        setTitle("konversiPanjang");
        setSize(700,400);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KotakPanel panel = new KotakPanel();
        panel.setBounds(45,10,600,300);
        add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KonversiPanjang();
            }
        });
    }
}
