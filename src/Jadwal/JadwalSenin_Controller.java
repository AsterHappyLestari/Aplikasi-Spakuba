/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jadwal;

import DAO.Ajar_DAO;
import Model.Ajar_Model;
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
public class JadwalSenin_Controller {
    JadwalSenin_View view;
    Ajar_Model model;
    Ajar_DAO dao;
    Connection con;
    Koneksi k;

    public JadwalSenin_Controller(JadwalSenin_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Ajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    public void viewTable() throws SQLException{
        try{
        DefaultTableModel tableModel = (DefaultTableModel)view.getTabel().getModel();
        tableModel.setRowCount(0);
        ResultSet rs = k.getQuery(con, "select id_kelas, id_pengajar, waktu from ajar");
        
        while(rs.next()){
            Object data[] = {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3)
            };
            tableModel.addRow(data);
        }
        } catch (SQLDataException ex){
            java.util.logging.Logger.getLogger(JadwalSenin_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
