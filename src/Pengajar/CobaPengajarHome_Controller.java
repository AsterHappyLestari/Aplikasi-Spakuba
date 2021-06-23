/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pengajar;

import DAO.Pengajar_DAO;
import Model.Pengajar_Model;
import java.sql.Connection;
import java.util.HashMap;
import koneksi.Koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class CobaPengajarHome_Controller {
    CobaPengajarHome_View view;
    Pengajar_Model model;
    Pengajar_DAO dao;
    Connection con;
    Koneksi k;

    public CobaPengajarHome_Controller(CobaPengajarHome_View view) throws ClassNotFoundException{

        this.view = view;
        dao = new Pengajar_DAO();
        k = new Koneksi();
        con = k.getConnection();
    }



//      public void previewrapor_siswa(){
//        HashMap parameter = new HashMap();
//        JasperPrint jasperPrint = null;
//        try {
//            jasperPrint = JasperFillManager.fillReport("report/rapor_siswa.jasper", parameter, con);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (Exception ex) {
//            System.out.print(ex.toString());
//        }
//    }
//public void siswa(){
//        model = new Siswa_Model();
//        model.setId_siswa(view.getTxtId_siswa().getText());
//        model.setNamasiswa(view.getTxtNama_siswa().getText());
//        model.setTtlsiswa(view.getTxtTtl().getText());
//        model.setNotelpsiswa(view.getTxtNotelp().getText());
//        model.setAlamatsiswa(view.getTxtAlamat().getText());
//        model.setId_kelas(view.getTxtId_kelas().getText());
//        
//        try{
//            dao.insert(con, model);
//            javax.swing.JOptionPane.showMessageDialog(null, "Input Data Siswa Berhasil");
//        }catch(Exception ex){
//            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
//        }
//}
      public void previewdata_pengajar_(){
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/data_pengajar.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
        }
    }

}
    
    
       



