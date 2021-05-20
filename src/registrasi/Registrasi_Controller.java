/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi;

import java.sql.Connection;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Registrasi_Controller {
    Registrasi_View view;
    Registrasi_Model model;
    Registrasi_DAO dao;
    Connection con;
    Koneksi k;
    
    public Registrasi_Controller(Registrasi_View view){
        this.view = view;
        dao = new Registrasi_DAO();
        k = new Koneksi();
        
        try{
            con = k.getConnection();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void register(){
        model = new Registrasi_Model();
        model.setId_admin(view.getTxtid().getText());
        model.setNamaadmin(view.getTxtnama().getText());
        model.setNamacompany(view.getTxtcompany().getText());
        model.setNotelpadmin(view.getTxtnotelp().getText());
        model.setAlamatadmin(view.getTxtalamat().getText());
        model.setUsername(view.getTxtemail().getText());
        model.setPassword(view.getTxtpassword().getText());
        
        try{
            dao.register(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Register Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}