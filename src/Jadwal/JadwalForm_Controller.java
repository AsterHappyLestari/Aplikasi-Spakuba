/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jadwal;

import DAO.Ajar_DAO;
import Model.Ajar_Model;
import java.sql.Connection;
import koneksi.Koneksi;

/**
 *
 * @author user
 */
public class JadwalForm_Controller {
    
    JadwalForm_View view;
    Ajar_Model model;
    Ajar_DAO dao;
    Connection con;
    Koneksi k;

    public JadwalForm_Controller(JadwalForm_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Ajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    
    
    public void JadwalForm(){
        model = new Ajar_Model();
        model.setId_kelas(view.getTxtId_Kelas().getText());
        model.setId_pengajar(view.getTxtNamaPengajar().getText());
        model.setWaktu(view.getTxtWaktu().getText());
        model.setHari(view.getCbHari().getSelectedItem().toString());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Input Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}
