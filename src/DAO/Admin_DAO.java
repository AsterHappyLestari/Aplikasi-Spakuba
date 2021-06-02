/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Admin_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
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
   public String login(Admin_Model log) throws SQLException{
       String sql = "Select * from admin where username = ? and password = ?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,log.getUsername());
       ps.setString(2,log.getPassword());
       ResultSet rs = ps.executeQuery();
       
       if(rs.next()){
           return
           rs.getString(4);
       }
       return null;
   }
   
   public void insert(Connection con, Admin_Model admin) throws SQLException{
       String sql = "insert into admin values(?,?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.setString(2, admin.getNamaadmin());
       ps.setString(3, admin.getNamacompany());
       ps.setString(4, admin.getNotelpadmin());
       ps.setString(5, admin.getAlamatadmin());
       ps.setString(6, admin.getUsername());
       ps.setString(7, admin.getPassword());
       ps.executeUpdate();
   }
   public static void update(Connection con, Admin_Model admin) throws SQLException{
       String sql = "update admin set username=?, password=?"
               +"where namaadmin=? and namacompany=? and notelpadmin=? and alamatadmin=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.setString(2, admin.getNamaadmin());
       ps.setString(3, admin.getNamacompany());
       ps.setString(4, admin.getNotelpadmin());
       ps.setString(5, admin.getAlamatadmin());
       ps.setString(6, admin.getUsername());
       ps.setString(7, admin.getPassword());
       ps.executeUpdate();
   }
   public static void delete(Connection con, Admin_Model admin) throws SQLException{
       String sql = "delete from admin where id_admin=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, admin.getId_admin());
       ps.executeUpdate();

   }
   public static Admin_Model getAdmin(Connection con, String id_admin) throws SQLException{
       String sql = "select * from admin where id_admin=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, id_admin);
       Admin_Model admin = null;
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           admin = new Admin_Model();
           admin.setId_admin(rs.getString(1));
           admin.setNamaadmin(rs.getString(2));
           admin.setNamacompany(rs.getString(3));
           admin.setNotelpadmin(rs.getString(4));
           admin.setAlamatadmin(rs.getString(5));
           admin.setUsername(rs.getString(6));
           admin.setPassword(rs.getString(7));
       }
       return admin;
   } 
}
