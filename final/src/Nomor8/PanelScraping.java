package Nomor8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class PanelScraping extends JPanel {
    PanelScraping(){
        setLayout(null);
        setVisible(true);
        JLabel titleLabel =new JLabel("Scraping Web");
        titleLabel.setBounds(150,10,200,30);
        titleLabel.setFont(new Font("Poppins",Font.BOLD,20));

        JLabel urlLabel = new JLabel("Url :");
        urlLabel.setBounds(20,70,50,30);
        urlLabel.setFont(new Font("Poppins",Font.PLAIN,14));
        JTextField inputURL = new JTextField();
        inputURL.setBounds(70,70,200,30);
        JTextArea teks = new JTextArea();
        JScrollPane scrollTeks = new JScrollPane(teks);
        scrollTeks.setBounds(20,120,360,250);
        JButton tombol = new JButton("Scraping");
        tombol.setBounds(280,70,100,30);
        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document doc;
                try {
                    String url = inputURL.getText();
                    doc = Jsoup.connect(url).get();
                    String text = doc.text();
                    HashMap<String,Integer> kata = frekuensi(text);
                    for (String kunci : kata.keySet()){
                        teks.append(kunci+" : "+kata.get(kunci)+"\n");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        add(urlLabel);
        add(inputURL);
        add(scrollTeks);
        add(tombol);
        add(titleLabel);
    }
    public HashMap<String,Integer> frekuensi (String teks){
        String[] kata = teks.split("\\s+");
        HashMap<String,Integer> frekuensiKata = new HashMap<>();
        for (String bait : kata){
            String kataBersih = bait.replaceAll("[^a-z A-Z]","").toLowerCase();
            if(kataBersih.equals("")){
                continue;
            }
            frekuensiKata.put(kataBersih,frekuensiKata.getOrDefault(kataBersih,0)+1);
        }

        return frekuensiKata;
    }
}
