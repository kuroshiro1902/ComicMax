/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.util.Collections;
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
                        rs.getInt(3),
                rs.getInt(4))
                );
            }
        } catch (Exception e) {}
        Collections.reverse(list);
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
                        rs.getInt(3),
                rs.getInt(4)
                );
                return item;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public float getTotalPriceByItemList(List<Item> list){
        float total = 0f;
        for(Item item: list){
            int amount = item.getAmount();
            float price = new BookDAO().getBookById(item.getPid()).getPrice();
            total += price*amount;
        }
        return (float) Math.round((total*100))/100;
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
        int effectRow=0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
                String query = "UPDATE Item set amount = ? where username = ? and book_id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, item.getAmount());
                ps.setString(2, item.getUsername());
                ps.setInt(3, item.getPid());
                
           
            effectRow = ps.executeUpdate();
        } catch (Exception e) {}
        return effectRow>0;
    }
}
