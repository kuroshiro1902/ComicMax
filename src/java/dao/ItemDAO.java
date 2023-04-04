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
    public List<Item> getAllItemsByUsername(Account a){
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
                                rs.getInt(3));
                return item;
            }
          
        } catch (Exception e) {}
        return null;
    }
//    public void addItemToCart(Item item){
//        String insert_query = "insert into Item values (?,?,?)"; //lay tu db ra
//        try {
//            DBContext db = DBContext.getInstance();
//            Connection conn = db.getConnection();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Category result = new Category(rs.getInt(1),
//                                 rs.getString(2),
//                                rs.getString(3)          
//               );
//                return result;
//            }
//          
//        } catch (Exception e) {}
//    }
}
