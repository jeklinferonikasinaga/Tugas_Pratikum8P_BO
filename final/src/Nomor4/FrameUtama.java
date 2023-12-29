package Nomor4;

import javax.swing.*;
import java.awt.*;

public class FrameUtama extends JFrame {

    FrameUtama(){
        setTitle("CRUD Transkrip");
        setSize(1200,600);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelTranskrip pT = new PanelTranskrip();
        pT.setBounds(390,10,380,400);
        PanelInsert pI = new PanelInsert();
        pI.setBounds(800,10,250,350);
        PanelCreate pC = new PanelCreate();
        pC.setBounds(120,10,250,350);
        getContentPane().add(new PanelTranskrip());

        PanelData pD = new PanelData();
        pD.setBounds(120,380,250,170);

        PanelBio bP = new PanelBio();
        bP.setBounds(390,430,380,200);
        add(bP);
        add(pD);
        add(pC);
        add(pI);
        add(pT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new FrameUtama();
            }
        });
    }
}
