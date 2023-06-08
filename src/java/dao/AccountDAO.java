/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import context.DBContext;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AccountDAO {
    public Account login(String username, String password){
        String query = "select * from Account where username = ? ";
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Account a =  new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                a.setPassword(Utils.decrypt(a.getPassword()));
                return a;
            }
            
        } catch (Exception e) {}
        return null;
    }
    public Account existedAccount(String username){
        String query = "select * from Account where username = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Account a =  new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                a.setPassword(Utils.decrypt(a.getPassword()));
                return a;
            }
        } catch (Exception e) {}
        return null;
    }
    public void createAccount(String fullname, String username, String password){
        String query = "insert into Account values(?,?,?,null,0)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, username.trim());
            ps.setString(3, Utils.encrypt(password));
            ps.executeUpdate();
        } catch (Exception e) {}
    }
    public String getFullnameByUsername(String username){
        String query = "select * from account where username = '" + username + "'";
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            return query;
        }
        return null;
    }
    public int countAccount(){
        String query = "select count(username) from account where isAdmin = 0";
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
}
