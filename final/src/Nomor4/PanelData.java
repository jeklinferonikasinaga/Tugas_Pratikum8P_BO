    package Nomor4;


    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.BufferedReader;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.StandardOpenOption;
    import java.util.ArrayList;
    import java.util.Vector;

    public class PanelData extends JPanel {
        private JButton openButton;
        private DefaultTableModel tableModel;

        PanelData() {
            setBackground(Color.white);
            setLayout(new BorderLayout());



            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            openButton = new JButton("Open");
            buttonPanel.add(openButton);

            add(scrollPane, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            table.setModel(DataList.getInstance().getTableModel());
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        String filePilih="";
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            filePilih = (String) table.getValueAt(selectedRow,0);

                        } else {
                            JOptionPane.showMessageDialog(null, "Select a row to delete.");
                        }
                        String namaFile = "C:\\PBO CODE\\FinalBOSS\\src\\Nomor4\\Data\\"+filePilih;
                        FileReader fr = new FileReader(namaFile);
                        BufferedReader br = new BufferedReader(fr);
                        String identitas = br.readLine();
                        String[]id = identitas.split(";");
                        DataCenter.setIdentitas(id);
                        PanelBio.update();
                        DataCenter.setFileTerbuka(namaFile);
                        String temp;
                        while ((temp = br.readLine()) != null) {
                            Vector<Object> data = new Vector<>();
                            String[] dataBrs = temp.split(";");
                            for (int i = 0; i < dataBrs.length ; i++) {
                                data.add(dataBrs[i]);
                            }
                            DataCenter.getInstance().addData(data);
                        }

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });


        }



    }
