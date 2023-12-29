package Nomor4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class PanelTranskrip extends JPanel {

    private DefaultTableModel tableModel;

    PanelTranskrip(){
        setBackground(Color.white);
        setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("Transkrip Nilai");
        title.setFont(new Font("Poppins", Font.BOLD, 16));
        JPanel infoPanel = new JPanel(new GridLayout(5,2,0,10));
        titlePanel.add(title);
        titlePanel.add(infoPanel);
        String[] columns = {"Kode MK", "Matakuliah", "SKS", "Nilai"};
        tableModel = new DefaultTableModel(null, columns);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(titlePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        JButton deleteButton = new JButton("Delete");
        JButton closeButton = new JButton("Close");
        JButton updateButton = new JButton("Update");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Menghapus semua baris dari tableModel
                PanelBio.reset();
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DataCenter.getInstance().removeData(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a row to delete.");
                }
            }
        });

        table.setModel(DataCenter.getInstance().getTableModel());

    }


}
