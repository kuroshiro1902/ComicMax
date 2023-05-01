/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 *
 * @author emsin
 */
public class BookDAO {
    private int [] convertStringArrayToIntArray(String[] a){
        int n = a.length;
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(a[i]);
        }
        return list;
    }
//    public List<Book> getList(String query, String n){
//        
//    }
    public List<Book> getTop(int n){
        List<Book> list = new ArrayList<>();
        String query = "select top "+ n +" * from Book order by sold DESC"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
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
                               rs.getFloat(10),
                               rs.getInt(11)
               );
                return result;
            }
          
        } catch (Exception e) {}
        return null;
    }
    public List<Book> getAllBooksLike(String s){
        List<Book> list = new ArrayList<>();
        String query = "exec getAllBooksLike ?"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> getTopNewestBooks(int n){
        List<Book> list = new ArrayList<>();
        String query = "select top " + n + " * from Book order by id DESC"; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> getBooksByCategoryId(int x, int n){
        List<Book> list = new ArrayList<>();
        String query = "select top " + n + " * from Book where publisher_id = " + x; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> getBooksByAuthorId(int x, int n){
        List<Book> list = new ArrayList<>();
        String query = "select top " + n + " * from Book where author_id= " + x; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> getBooksByLanguage(int x, int n){
        List<Book> list = new ArrayList<>();
        String query = "select top " + n + " * from Book where language = " + x; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> getBooksByPrice(int x, int n){
        List<Book> list = new ArrayList<>();
        String query = "select top" + n + "* from Book where price <= " + x; //lay tu db ra
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getInt(11)
                                    ));
            }
            
        } catch (Exception e) {}
        return list;
    }
    public List<Book> search(String s, String[] cs, String aid){
        List<Book> list = this.getAllBooksLike(s);
        int[] cids = cs==null? null : this.convertStringArrayToIntArray(cs);
        int auid = aid==null? -1: Integer.parseInt(aid);
        int n = list.size();
        for(int i=n-1;i>=0;i--){
            Book book = list.get(i);
            if(auid>=0){
                if(book.getAuthor_id() != auid){
                    list.remove(book);
                    continue;
                }
            }
            if(cs!=null)
            for(int j=0;j<cids.length;j++)
                if(!book.getCategoryIds().contains(cids[j])){
                    list.remove(book);
                    break;
                }  
        }
        return list;
    }
    public List<Book> getRelateBook(Book book, int n){
        List<Book> list = new ArrayList<>();
        
        return list;
    }
}

