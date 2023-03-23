/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Publisher;

/**
 *
 * @author emsin
 */
public class PublisherDAO {
    public Publisher getPublisherById(int id){
        
        String query = "select * from Publisher where id = ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Publisher result = new Publisher(rs.getInt(1),
                                 rs.getString(2)
               );
                return result;
            }
          
        } catch (Exception e) {}
        return null;
    }
}
