/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi;

import DAO.Admin_DAO;
import Model.Admin_Model;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.HEAD;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Registrasi_Controller {
    Registrasi_View view;
    Admin_Model model;
    Admin_DAO dao;
    Connection con;
    Koneksi k;

    public Registrasi_Controller(Registrasi_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Admin_DAO();
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
