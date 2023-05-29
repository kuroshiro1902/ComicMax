/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Item;

/**
 *
 * @author emsin
 */
public class ItemDAO {
    public List<Item> getAllItemsByUser(Account a){
        List list = new ArrayList<>();
        String query = "select * from Item where username = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, a.getUsername());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Item(rs.getString(1), 
                        rs.getInt(2), 
                        rs.getInt(3))
                );
            }
        } catch (Exception e) {}
        return list;
    }
    public Item getItemByUsernameAndBookId(String username, int book_id){
        String query = "select * from Item where username = ? and book_id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, book_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Item item = new Item(rs.getString(1),
                                 rs.getInt(2),
                                rs.getInt(3)
                );
                return item;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public boolean addItemToCart(Item item){
        String query;
        int effectRow=0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
            Item instanceItem = this.getItemByUsernameAndBookId(item.getUsername(), item.getPid());
            if(instanceItem!=null){ //neu item da co trong gio hang
                item.setAmount(instanceItem.getAmount()+item.getAmount()); //them so luong vao
                query = "update Item set amount = ? where username = ? and book_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, item.getAmount());
                ps.setString(2, item.getUsername());
                ps.setInt(3, item.getPid());
                
            }
            else{ //neu item chua co trong gio hang
                query = "insert into Item values (?,?,?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, item.getUsername());
                ps.setInt(2, item.getPid());
                ps.setInt(3, item.getAmount());
            }
            effectRow = ps.executeUpdate();
        } catch (Exception e) {}
        return effectRow>0;
    }
    public boolean deleteItem(Item item){
        String query = "DELETE FROM Item WHERE book_id = ? and username = ? ";
        int effectRow=0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement(query);
            ps.setInt(1, item.getPid());
            ps.setString(2, item.getUsername());
            effectRow = ps.executeUpdate();
        } catch (Exception e) {}
        return effectRow>0;
    }
    public boolean modifyItemInCart(Item item){
        String query="";
        int effectRow=0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
                query = "";
                ps = conn.prepareStatement(query);
                ps.setInt(1, item.getAmount());
                ps.setString(2, item.getUsername());
                ps.setInt(3, item.getPid());
                
           
            effectRow = ps.executeUpdate();
        } catch (Exception e) {}
        return effectRow>0;
    }
}
