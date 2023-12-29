package Nomor8;

import javax.swing.*;
import java.awt.*;

public class ScrapingWeb extends JFrame {
    ScrapingWeb (){
        setTitle("Scraping WEB");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelScraping pS = new PanelScraping();
        pS.setBounds(50,30,400 ,400);
        add(pS);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScrapingWeb();
            }
        });
    }
}
