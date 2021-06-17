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
import java.sql.ResultSet;
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
       String sql = "insert into siswa values(?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, siswa.getId_siswa());
       ps.setString(2, siswa.getNamasiswa());
       ps.setString(3, siswa.getTtlsiswa());
       ps.setString(4, siswa.getNotelpsiswa());
       ps.setString(5, siswa.getAlamatsiswa());
       ps.setString(6, siswa.getId_kelas());
       ps.executeUpdate();
       
   }
 public static void update(Connection con, Siswa_Model siswa) throws SQLException{
       String sql = "update siswa set username=?, password=?"
               +"where namasiswa=? and ttlsiswa=? and notelpsiswa=? and alamatsiswa=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, siswa.getId_siswa());
       ps.setString(2, siswa.getNamasiswa());
       ps.setString(3, siswa.getTtlsiswa());
       ps.setString(4, siswa.getNotelpsiswa());
       ps.setString(5, siswa.getAlamatsiswa());
       ps.setString(6, siswa.getId_kelas());
       ps.executeUpdate();
   }
 
    public static void delete(Connection con, Siswa_Model siswa) throws SQLException{
       String sql = "delete from siswa where id_siswa=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, siswa.getId_siswa());
       ps.executeUpdate();
    }
    
    public static Siswa_Model getSiswa(Connection con, String id_siswa) throws SQLException{
       String sql = "select * from siswa where id_siswa=?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, id_siswa);
       Siswa_Model siswa = null;
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           siswa = new Siswa_Model();
           siswa.setId_siswa(rs.getString(1));
           siswa.setNamasiswa(rs.getString(2));
           siswa.setTtlsiswa(rs.getString(3));
           siswa.setNotelpsiswa(rs.getString(4));
           siswa.setAlamatsiswa(rs.getString(5));
           siswa.setId_kelas(rs.getString(6));
 
       }
       return siswa;
   } 
}
