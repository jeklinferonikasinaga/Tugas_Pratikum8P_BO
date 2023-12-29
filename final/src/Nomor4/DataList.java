package Nomor4;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class DataList {
    private static DataList instance;
    private DefaultTableModel tableModel;
    private DataList() {
        String[] columns = {"Nama"};
        tableModel = new DefaultTableModel(null, columns);
    }
    public static DataList getInstance() {
        if (instance == null) {
            instance = new DataList();
        }
        return instance;

    }
    public void addData(Vector<Object> rowData) {

        tableModel.addRow(rowData);
    }
    public DefaultTableModel getTableModel() {
        try {
            FileReader fr = new FileReader("C:\\PBO CODE\\FinalBOSS\\src\\list.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                Vector<String> baris = new Vector<>();
                baris.add(temp);
                tableModel.addRow(baris);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tableModel;
    }
}
