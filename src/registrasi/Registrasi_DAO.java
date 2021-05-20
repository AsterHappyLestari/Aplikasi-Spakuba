/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import koneksi.Koneksi;

/**
 *
 * @author USER
 */
public class Registrasi_DAO {
    Connection con ;
    public Registrasi_DAO() throws ClassNotFoundException{
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void register(Registrasi_Model Model) throws SQLException{
        String sql = "insert into admin values (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Model.getId_admin());
        ps.setString(2, Model.getNamaadmin());
        ps.setString(3, Model.getNamacompany());
        ps.setString(4, Model.getNotelpadmin());
        ps.setString(5, Model.getAlamatadmin());
        ps.setString(6, Model.getUsername());
        ps.setString(7, Model.getPassword());
        ps.executeUpdate();
    }
}
