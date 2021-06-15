/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pengajar;

import DAO.Pengajar_DAO;
import Model.Pengajar_Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author user
 */
public class PengajarTabel_Controller {
    PengajarTabel_View view;
    Pengajar_Model model;
    Pengajar_DAO dao;
    Connection con;
    Koneksi k;

    public PengajarTabel_Controller(PengajarTabel_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Pengajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    public void viewTable() throws SQLException{
        try{
        DefaultTableModel tableModel = (DefaultTableModel)view.getTabel().getModel();
        tableModel.setRowCount(0);
        ResultSet rs = k.getQuery(con, "SELECT id_pengajar, namapengajar, email, notelppengajar, alamatpengajar from pengajar");
        
        while(rs.next()){
            Object data[] = {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            };
            tableModel.addRow(data);
        }
        } catch (SQLDataException ex){
            java.util.logging.Logger.getLogger(PengajarTabel_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
