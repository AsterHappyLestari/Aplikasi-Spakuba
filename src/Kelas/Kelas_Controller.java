/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelas;

import DAO.Kelas_DAO;
import Model.Kelas_Model;
import java.sql.Connection;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */


public class Kelas_Controller {
    CobaKelasForm_View view;
    Kelas_Model model;
    Kelas_DAO dao;
    Connection con;
    Koneksi k;

    public Kelas_Controller(CobaKelasForm_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Kelas_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    
    
    public void kelas(){
        model = new Kelas_Model();
        model.setId_kelas(view.getTxtId_kelas().getText());
        model.setNamaSiswa(view.getTxtNamaSiswa().getText());
        model.setProgramkls(view.getCbProgramkls().getSelectedItem().toString());
        model.setHari(view.getCbHari().getSelectedItem().toString());

        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Input Data Kelas Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}
