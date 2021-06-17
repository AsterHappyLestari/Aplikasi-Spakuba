/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Kelas_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.Koneksi;
/**
 *
 * @author user
 */
public class Kelas_DAO {
    Connection con;
    
    public Kelas_DAO(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void insert(Connection con, Kelas_Model kelas) throws SQLException{
       String sql = "insert into kelas values(?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, kelas.getId_kelas());
       ps.setString(2, kelas.getNamaSiswa());
       ps.setString(3, kelas.getProgramkls());
       ps.setString(4, kelas.getHari());
   }
   public static void update(Connection con, Kelas_Model kelas) throws SQLException{
       String sql = "update kelas set NamaSiswa=?, programkls=?, hari=?"
               +"where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, kelas.getId_kelas());
       ps.setString(2, kelas.getNamaSiswa());
       ps.setString(3, kelas.getProgramkls());
       ps.setString(4, kelas.getHari());
       ps.executeUpdate();
   }
   public static void delete(Connection con, Kelas_Model kelas) throws SQLException{
       String sql = "delete from admin where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, kelas.getId_kelas());
       ps.executeUpdate();
   }
   
   public static Kelas_Model getKelas(Connection con, String id_kelas) throws SQLException{
       String sql = "select * from admin where id_kelas=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, id_kelas);
       Kelas_Model kelas = null;
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           kelas = new Kelas_Model();
           kelas.setId_kelas(rs.getString(1));
           kelas.setNamaSiswa(rs.getString(2));
           kelas.setProgramkls(rs.getString(3));
           kelas.setHari(rs.getString(4));
       }
       return kelas;
   }
}
