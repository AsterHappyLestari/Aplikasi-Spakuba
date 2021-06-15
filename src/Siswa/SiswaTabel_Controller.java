/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siswa;

import DAO.Siswa_DAO;
import Model.Siswa_Model;
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
public class SiswaTabel_Controller {
    SiswaTabel_View view;
    Siswa_Model model;
    Siswa_DAO dao;
    Connection con;
    Koneksi k;

    public SiswaTabel_Controller(SiswaTabel_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Siswa_DAO();
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
                rs.getString(5),
                rs.getString(6)
            };
            tableModel.addRow(data);
        }
        } catch (SQLDataException ex){
            java.util.logging.Logger.getLogger(SiswaTabel_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
