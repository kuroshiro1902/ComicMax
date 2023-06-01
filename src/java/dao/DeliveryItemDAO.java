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
                        rs.getString(10)
                  
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
    public void addDeliveryItem(DeliveryItem deliveryItem) {
        Connection conn;
        PreparedStatement ps;

        try {
        DBContext db = DBContext.getInstance();
        conn = db.getConnection();
        String query = "INSERT INTO delivery_items "
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

        ps.executeUpdate();
    } catch (Exception e) {} ;
    }
}
