/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Siswa_Model;
import java.sql.Connection;
import Model.Siswa_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import koneksi.Koneksi;
/**
 *
 * @author Ezik Haq Wahid
 */
public class Siswa_DAO {
    Connection con;
    
    public Siswa_DAO(){
       Koneksi k = new Koneksi();
       con = k.getConnection();
   }
   
   public void insert(Connection con, Siswa_Model siswa) throws SQLException{
       String sql = "insert into siswa values(?,?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_siswa());
       ps.setString(2, admin.getIdsiswa());
       ps.setString(3, admin.getTtlsiswa());
       ps.setString(4, admin.getNotelpadmin());
       ps.setString(5, admin.getAlamatadmin());
       ps.setString(6, admin.getUsername());
       ps.setString(7, admin.getPassword());
   }
   public static void update(Connection con, Admin_Model admin) throws SQLException{
       String sql = "update admin set username=?, password=?"
               +"where namaadmin=? and namacompany=? and notelpadmin=? and alamatadmin=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.setString(1, admin.getId_admin());
   }
}
