package dao;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.DeliveryItem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class DeliveryItemDAO extends DAO{
    private String setValue(String param, String defaultValue){
       defaultValue = defaultValue == null || defaultValue.equals("null")? "null" : defaultValue;
       return param == null || param.equals("null")? defaultValue : param;
   }
    private DeliveryItem newDeliveryItem(ResultSet rs){
        DeliveryItem deliveryItem = null;
        try {
            deliveryItem = new DeliveryItem(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)
                  
                                    );
        } catch (Exception e) {}
        return deliveryItem;
    }
    private DeliveryItem getDeliveryItemByQuery(String query){
        ResultSet rs = this.getResult(query);
        try {
            while(rs.next()){
                return this.newDeliveryItem(rs);
            }
        } catch (Exception e) {}
        return null;
    }
    private List<DeliveryItem> getListByQuery(String query){
        List<DeliveryItem> list = new ArrayList<>();
        ResultSet rs = this.getResult(query);
        try {
            while(rs.next()){
                list.add(this.newDeliveryItem(rs));
            }
        } catch (Exception e) {}
        return list;
    }
    public DeliveryItem getDeliveryItemByIdAndUsername(int id, String username){
        String query = "select * from deliveryitem where id = "+id+" and username = '"+username+"'";
        return this.getDeliveryItemByQuery(query);
    }
    public List<DeliveryItem> getOrderDeliveryItemsByUserName(String username){
        String query = "select * from deliveryitem where username = '" + username + "' and donetime is null order by ordertime desc";
        return this.getListByQuery(query);
    }
    public List<DeliveryItem> getDoneDeliveryItemsByUserName(String username){
        String query = "select * from deliveryitem where username = '" + username + "' and donetime is not null order by donetime desc";
        return this.getListByQuery(query);
    }
    public String addDeliveryItem(DeliveryItem deliveryItem) {
        Connection conn;
        PreparedStatement ps;
        String query="";
        int effectRow = 0;
        try {
            DBContext db = DBContext.getInstance();
            conn = db.getConnection();
            query = "INSERT INTO DeliveryItem "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, deliveryItem.getUsername());
            ps.setInt(2, deliveryItem.getBookId());
            ps.setInt(3, deliveryItem.getAmount());
            ps.setString(4, deliveryItem.getPayment());
            ps.setString(5, deliveryItem.getAddress());
            ps.setString(6, deliveryItem.getPhone());
            ps.setString(7, deliveryItem.getEmail());
            ps.setString(8, deliveryItem.getNote());
            ps.setNull(9, java.sql.Types.NULL);
            ps.setNull(10, java.sql.Types.NULL);

            effectRow = ps.executeUpdate();
        } catch (Exception e) {} ;
        return query;
    }
    public int getDoneDeliveryItemByMonth (int month) {
        String query = "SELECT sum(amount) FROM DeliveryItem WHERE MONTH(ordertime) =" + month;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    public int getCountCustomerByAmount(int amount){
        String query = "SELECT count(distinct username) FROM DeliveryItem GROUP BY username HAVING SUM(amount) > " + amount;
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    public boolean setDoneByIdAndUsername(int id, String username){
        int effectRow;
        String query = "update DeliveryItem set donetime = GETDATE() where id = "+id+" and username = '"+username+"'";
        try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            effectRow = ps.executeUpdate();
        } catch (Exception e) {
            effectRow = 0;
        }
        return effectRow>0; 
    }
}
