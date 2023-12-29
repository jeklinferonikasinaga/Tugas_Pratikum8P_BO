package Nomor4;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class DataCenter {
    public static String fileTerbuka;
    private static DataCenter instance;
    private DefaultTableModel tableModel;
    public  static String[] identitas = new String[4];

    public static void setFileTerbuka(String nama){
        fileTerbuka = nama;
    }

    public static void setIdentitas(String[] cd) {
        identitas = cd;
    }

    private DataCenter() {
        String[] columns = {"Kode MK", "Matakuliah", "SKS", "Nilai"};
        tableModel = new DefaultTableModel(null, columns);
    }

    public static DataCenter getInstance() {
        if (instance == null) {
            instance = new DataCenter();
        }
        return instance;
    }


    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addData(Vector<Object> rowData) {

        tableModel.addRow(rowData);
    }
    public void removeData(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            tableModel.removeRow(rowIndex);
        }
    }

    public void updateData(int rowIndex, String newData) {

    }
    public static void reset(){
        instance = null;
        instance = new DataCenter();
    }

}
