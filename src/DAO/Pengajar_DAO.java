/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pengajar_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Pengajar_DAO {
     Connection con;
   
   public Pengajar_DAO(){
       Koneksi k = new Koneksi();
       con = k.getConnection();
   }
   
   public void insert(Connection con, Pengajar_Model pengajar) throws SQLException{
       String sql = "insert into ajar values(?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, pengajar.getId_pengajar());
       ps.setString(2, pengajar.getNamapengajar());
       ps.setString(3, pengajar.getEmail());
       ps.setString(4, pengajar.getNotelppengajar());
       ps.setString(5, pengajar.getAlamatpengajar());
       ps.executeUpdate();
   }
   public static void update(Connection con, Pengajar_Model pengajar) throws SQLException{
       String sql = "update ajar set namapengajar=?, email=?, notelppengajar=?, alamatpengajar=?"
               +"where id_pengajar=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, pengajar.getId_pengajar());
       ps.setString(2, pengajar.getNamapengajar());
       ps.setString(3, pengajar.getEmail());
       ps.setString(4, pengajar.getNotelppengajar());
       ps.setString(5, pengajar.getAlamatpengajar());
       ps.executeUpdate();
   }
   public static void delete(Connection con, Pengajar_Model pengajar) throws SQLException{
       String sql = "delete from ajar where id_pengajar=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, pengajar.getId_pengajar());
       ps.executeUpdate();

   }
   public static Pengajar_Model getPengajar(Connection con, String id_pengajar) throws SQLException{
       String sql = "select * from ajar where id_pengajar=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, id_pengajar);
       Pengajar_Model pengajar = null;
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           pengajar = new Pengajar_Model();
           pengajar.setId_pengajar(rs.getString(1));
           pengajar.setNamapengajar(rs.getString(2));
           pengajar.setEmail(rs.getString(3));
           pengajar.setNotelppengajar(rs.getString(4));
           pengajar.setAlamatpengajar(rs.getString(4));
       }
       return pengajar;
   } 
}
