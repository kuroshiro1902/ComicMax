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
                    rs.getTimestamp(4),
                    rs.getInt(5),
                    rs.getInt(6)
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
        String query = "SELECT * FROM Comment WHERE book_id = " + bookId + " order by posttime desc";
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
            query = "INSERT INTO Comment VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, comment.getUsername().trim());
            ps.setInt(2, comment.getBookId());
            ps.setString(3, comment.getContent().trim());
            ps.setNull(4, java.sql.Types.NULL);
            ps.setInt(5, comment.getRating());
            effectRow = ps.executeUpdate();
        } catch (Exception e) {
        }
        return effectRow > 0 ? commentDao.getAllCommentsByUsernameAndBookId(comment.getUsername(), comment.getBookId()) : null;
    }
    public boolean modifyComment( String content, String username, int id) throws Exception {
        String query;
        int effectRow = 0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
            query = "UPDATE Comment SET content = ? WHERE username = ? and id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, content.trim());
            ps.setString(2,username);
            ps.setInt(3, id);

            effectRow = ps.executeUpdate();
        } catch (Exception e) {
        }
        return effectRow > 0;
    }

public boolean deleteComment(String username, int id) throws Exception {
        String query;
        int effectRow = 0;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps;
            query = "DELETE Comment WHERE username = ? and id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setInt(2, id);

            effectRow = ps.executeUpdate();
        } catch (Exception e) {
        }
        return effectRow > 0;
    }
}
