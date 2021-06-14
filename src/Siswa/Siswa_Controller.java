/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siswa;

import DAO.Siswa_DAO;
import Model.Siswa_Model;
import java.sql.Connection;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Siswa_Controller {
    SiswaForm_View view;
    Siswa_Model model;
    Siswa_DAO dao;
    Connection con;
    Koneksi k;

    public Siswa_Controller(SiswaForm_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Siswa_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }

    
    
    public void siswa(){
        model = new Siswa_Model();
        model.setId_siswa(view.getTxtId_siswa().getText());
        model.setNamasiswa(view.getTxtNamasiswa().getText());
        model.setTtlsiswa(view.getTxtTtl().getText());
        model.setNotelpsiswa(view.getTxtNotelpsiswa().getText());
        model.setAlamatsiswa(view.getTxtAlamatsiswa().getText());
        model.setId_kelas(view.getTxtId_kelas().getText());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Input Data Siswa Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
    
    public void onClickTable(){
        int index = view.geTabelSiswa().getSelectedRow();
        
    }
}
