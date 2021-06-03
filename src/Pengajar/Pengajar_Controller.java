/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pengajar;

import DAO.Pengajar_DAO;
import Model.Pengajar_Model;
import java.sql.Connection;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Pengajar_Controller {
    PengajarForm_View view;
    Pengajar_Model model;
    Pengajar_DAO dao;
    Connection con;
    Koneksi k;

    public Pengajar_Controller(PengajarForm_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Pengajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    
    
    public void admin(){
        model = new Pengajar_Model();
        model.setId_pengajar(view.getTxtId_pengajar().getText());
        model.setNamapengajar(view.getTxtNamapengajar().getText());
        model.setEmail(view.getTxtEmail().getText());
        model.setNotelppengajar(view.getTxtNotelppengajar().getText());
        model.setAlamatpengajar(view.getTxtAlamat().getText());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Register Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}
