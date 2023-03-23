/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
