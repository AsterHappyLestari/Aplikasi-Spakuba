/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelas;

import DAO.Kelas_DAO;
import Pengajar.*;
import DAO.Pengajar_DAO;
import Model.Kelas_Model;
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
public class TabelJepang_Controller {
    BahasaJepang_View view;
    Kelas_Model model;
    Kelas_DAO dao;
    Connection con;
    Koneksi k;

    public TabelJepang_Controller(BahasaJepang_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Kelas_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    public void viewTable() throws SQLException{
        try{
        DefaultTableModel tableModel = (DefaultTableModel)view.getTbBahasaJepang().getModel();
        tableModel.setRowCount(0);
        ResultSet rs = k.getQuery(con, "SELECT id_kelas, NamaKelas, programkls, hari from kelas where programkls= 'bahasa jepang'");
        
        while(rs.next()){
            Object data[] = {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            };
            tableModel.addRow(data);
        }
        } catch (SQLDataException ex){
            java.util.logging.Logger.getLogger(TabelJepang_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
