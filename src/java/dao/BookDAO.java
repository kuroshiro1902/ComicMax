/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emsin
 */
public class BookDAO {
    public Book getBookById(int id){
        
        String query = "select * from Book where id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book  result = new Book(rs.getInt(1),
                                 rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6),
                                rs.getFloat(7),
                               rs.getInt(8),
                               rs.getInt(9),
                               rs.getInt(10),
                               rs.getInt(11)
               );
                return result;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public Book getAllCategoriesOfBookId(int id){
        Book result = null;
        String query = "select * from Book where id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id+"");
            ResultSet rs = ps.executeQuery();
               result = new Book(rs.getInt(1),
                                 rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6),
                                rs.getFloat(7),
                               rs.getInt(8),
                               rs.getInt(9),
                               rs.getInt(10),
                               rs.getInt(11)
               );
            
            
        } catch (Exception e) {}
        return result;
    }
//    public List<Category>
}

