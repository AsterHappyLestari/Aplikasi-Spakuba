/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class Koneksi {
    private final String url = "jdbc:mysql://localhost/db_spakuba";
    private final String username = "root";
    private final String password = "";
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return java.sql.DriverManager.getConnection(url,username,password);
        }catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    public ResultSet getQuery(Connection con, String sql) throws SQLException{
        return con.createStatement().executeQuery(sql);
    }
    public static void main(String[] args){
        Koneksi koneksi = new Koneksi();
        if(koneksi.getConnection() != null){
            javax.swing.JOptionPane.showMessageDialog(null, "Koneksi OK");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }
}