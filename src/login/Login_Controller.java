/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import DAO.Admin_DAO;
import Model.Admin_Model;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author Ezik Haq Wahid
 */
public class Login_Controller {
    Login_View view;
    Admin_Model model;
    Admin_DAO dao;
    Connection con;
    Koneksi k;
    
    public Login_Controller(Login_View view ){
        this.view = view;
        dao = new Admin_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    public String login() throws SQLException{
        model = new Admin_Model();
        model.setUsername(view.getTxtUsername().getText());
        model.setPassword(view.getTxtPassword().getText());
        
        try{
            if(dao.login(model) !=null){
                javax.swing.JOptionPane.showMessageDialog(null, "Login Berhasil");
                return dao.login(model);
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Data Salah atau Tidak Tersedia");
            }
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());     }
        return null;
    }
}
