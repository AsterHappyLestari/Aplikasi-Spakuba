/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ajar_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Ajar_DAO {
    Connection con;
   
   public Ajar_DAO(){
       Koneksi k = new Koneksi();
       con = k.getConnection();
   }
   
   public void insert(Connection con, Ajar_Model ajar) throws SQLException{
       String sql = "insert into ajar values(?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, ajar.getId_kelas());
       ps.setString(2, ajar.getId_pengajar());
       ps.setString(3, ajar.getTanggal());
       ps.setString(4, ajar.getWaktu());
       ps.executeUpdate();
   }
   public static void update(Connection con, Ajar_Model ajar) throws SQLException{
       String sql = "update ajar set id_pengajar=?, tanggal=?, waktu=?"
               +"where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, ajar.getId_kelas());
       ps.setString(2, ajar.getId_pengajar());
       ps.setString(3, ajar.getTanggal());
       ps.setString(4, ajar.getWaktu());
       ps.executeUpdate();
   }
   public static void delete(Connection con, Ajar_Model ajar) throws SQLException{
       String sql = "delete from ajar where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, ajar.getId_kelas());
       ps.executeUpdate();

   }
   public static Ajar_Model getAjar(Connection con, String id_kelas) throws SQLException{
       String sql = "select * from ajar where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, id_kelas);
       Ajar_Model ajar = null;
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           ajar = new Ajar_Model();
           ajar.setId_kelas(rs.getString(1));
           ajar.setId_pengajar(rs.getString(2));
           ajar.setTanggal(rs.getString(3));
           ajar.setWaktu(rs.getString(4));
       }
       return ajar;
   } 
}
