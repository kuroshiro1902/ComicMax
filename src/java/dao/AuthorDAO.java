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
import model.Author;

/**
 *
 * @author emsin
 */
public class AuthorDAO {
    public Author getAuthorById(int id){
        
        String query = "select * from Author where id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Author result = new Author(rs.getInt(1),
                                 rs.getString(2)
               );
                return result;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public List<Author> getAllAuthors(){
        List<Author> list = new ArrayList<>();
        String query = "select * from Author"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Author(rs.getInt(1),
                                  rs.getString(2)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
}
