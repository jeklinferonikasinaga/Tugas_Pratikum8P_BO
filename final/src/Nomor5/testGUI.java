package Nomor5;
import static java.lang.String.valueOf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testGUI extends JFrame {
    private static final int HEIGHT = 50;
    private static final int WIDTH = 50;
    private static final int BAR_WIDTH = 50;
    Font newFont = new Font("TAHOMA", Font.BOLD, 14);

    Random rand = new Random();

    private static JPanel panel;

    private static int[] data = { 20, 80, 32, 124, 70, 43, 55, 35, 67 };

    public testGUI() {

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int x = 10;
                for (int i = 0; i < data.length; i++) {
                    g.setFont(newFont);
                    g.setColor(Color.decode("#0ea5e9"));
                    g.fillRect(x, (getHeight()-200) - data[i], BAR_WIDTH, data[i]);
                    g.setColor(Color.BLACK);
                    g.drawString(valueOf(data[i]), x + 15, (getHeight()-220));
                    g.drawString(valueOf(i), x + 15, (getHeight()-180));
                    x += BAR_WIDTH + 5;
                }

            }

        };
        add(panel);
        setVisible(true);
        bubbleSort();
    }

    public static void bubbleSort() {
        Thread thread = new Thread();
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap data[j] and data[j+1]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    try {
                        thread.sleep(12000 / 60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    panel.repaint();
                }
            }
        }
    }

    public static void main(String[] args) {
        new testGUI();
    }

}