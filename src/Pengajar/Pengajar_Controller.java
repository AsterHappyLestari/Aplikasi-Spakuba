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
    Pengajar_View view;
    Pengajar_Model model;
    Pengajar_DAO dao;
    Connection con;
    Koneksi k;

    public Pengajar_Controller(Pengajar_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Pengajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    
    
    public void admin(){
        model = new Admin_Model();
        model.setId_admin(view.getTxtid().getText());
        model.setNamaadmin(view.getTxtnama().getText());
        model.setNamacompany(view.getTxtcompany().getText());
        model.setNotelpadmin(view.getTxtnotelp().getText());
        model.setAlamatadmin(view.getTxtalamat().getText());
        model.setUsername(view.getTxtemail().getText());
        model.setPassword(view.getTxtpassword().getText());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Register Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}
