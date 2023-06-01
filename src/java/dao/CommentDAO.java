/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Comment;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class CommentDAO extends DAO {

    private Comment newComment(ResultSet rs) {
        try {
            return new Comment(
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getInt(5)
            );
        } catch (Exception e) {
        }
        return null;
    }

    private Comment getCommentByQuery(String query) {
        ResultSet rs = this.getResult(query);
        try {
            while (rs.next()) {
                return this.newComment(rs);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private List<Comment> getCommentListByQuery(String query) {
        List<Comment> commentList = new ArrayList<>();
        ResultSet rs = this.getResult(query);
        try {
            while (rs.next()) {
                commentList.add(this.newComment(rs));
            }
        } catch (Exception e) {
        }
        return commentList;
    }
    
    public List<Comment> getAllCommentsByBookId(int bookId) {
        String query = "SELECT * FROM Comment WHERE book_id = " + bookId;
        return this.getCommentListByQuery(query);
    }
    public List<Comment> getAllCommentsByUsernameAndBookId(String username, int bookId) {
        String query = "SELECT * FROM Comment WHERE username = ? AND book_id = ?";
        return this.getCommentListByQuery(query);
    }
    public List<Comment> addComment(Comment comment) throws Exception {
    CommentDAO commentDao = new CommentDAO();
    String query;
    int effectRow = 0;
    try {
        DBContext db = DBContext.getInstance();
        Connection conn = db.getConnection();
        PreparedStatement ps;
        query = "INSERT INTO Comment VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, comment.getUsername().trim());
        ps.setInt(2, comment.getBookId());
        ps.setString(3, comment.getContent().trim());
        ps.setDate(4, new java.sql.Date(comment.getPostTime().getTime()));
        effectRow = ps.executeUpdate();
    } catch (Exception e) {}
    return effectRow > 0 ? commentDao.getAllCommentsByUsernameAndBookId(comment.getUsername(), comment.getBookId()) : null;
}


}
