/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emsin
 */
public class CategoryDAO {
    public Category getCategoryById(int id){
        
        String query = "select * from Category where id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category result = new Category(rs.getInt(1),
                                 rs.getString(2),
                                rs.getString(3)          
               );
                return result;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public List<Category> getAllCategories(){
        List<Category> list = new ArrayList<>();
        String query = "select * from Category"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Category(rs.getInt(1),
                                  rs.getString(2),
                                    rs.getString(3)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Category> getAllCategoriesOfBookId(int id){
        List<Category> list = new ArrayList<>();
        String query = "select Category.* from Book_Category Join Category on  Book_Category.Category_id = Category.id where Book_Category.book_id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Category(rs.getInt(1),
                                  rs.getString(2),
                                    rs.getString(3)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
}
