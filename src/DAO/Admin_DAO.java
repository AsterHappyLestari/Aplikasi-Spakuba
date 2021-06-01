/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Admin_DAO {
   Connection con;
   
   public Admin_DAO(){
       Koneksi k = new Koneksi();
       con = k.getConnection();
   }
   
   public void insert(Connection con, Admin_Model admin){
       String sql = "insert into admin values(?,?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.setString(2, admin.getNamaadmin());
       ps.setString(3, admin.getNamacompany());
       ps.setString(4, admin.getNotelpadmin());
       ps.setString(5, admin.getAlamatadmin());
       ps.setString(6, admin.getUsername());
       ps.setString(7, admin.getPassword());
   }
   public static void update(Connection con, Admin_Model admin){
       String sql = "update admin set username=?, password=?"
               +"where namaadmin=? and namacompany=? and notelpadmin=? and alamatadmin=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.setString(1, admin.getId_admin());
   }
}
