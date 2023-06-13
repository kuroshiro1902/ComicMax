package dao;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.DeliveryItem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Book;
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
    private int getNumberByQuery(String query){
        ResultSet rs = this.getResult(query);
        try {
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }
    public List<DeliveryItem> getAllOrderDeliveryItemsByTime(String startTime, String endTime){
        startTime = this.setValue(startTime, "");
        endTime = this.setValue(endTime, "");
        String query = "select * from deliveryitem where donetime is null";
        if(!startTime.equals("")) query+=" and ordertime >= '"+startTime+"'";
        if(!endTime.equals("")) query+=" and ordertime <= '"+endTime+"'";
        query+=" order by ordertime desc";
        return this.getListByQuery(query);
    }
    public List<DeliveryItem> getAllDoneDeliveryItemsByTime(String startTime, String endTime){
        String query = "select * from deliveryitem where donetime is not null";
        if(!startTime.equals("")) query+=" and donetime >= '"+startTime+"'";
        if(!endTime.equals("")) query+=" and donetime <= '"+endTime+"'";
        query+=" order by donetime desc";
        return this.getListByQuery(query);
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
    public List<DeliveryItem> getDoneDeliveryItemsByUserNameAndMonth(String username, int month){
        String query = "select * from deliveryitem where username = '"+username+"' and month(ordertime) = "+month;
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
        String query = "SELECT sum(amount) FROM DeliveryItem WHERE MONTH(donetime) =" + month;
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
        return this.getNumberByQuery(query);
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
    public int getAmountByBookAndMonth(Book book, int month){
        String query = "select sum(amount) from DeliveryItem where month(donetime) = "+month+" and book_id = "+book.getId();
        return this.getNumberByQuery(query);
    }
    public int getAmountByMonth(int month){
        String query = "select sum(amount) from DeliveryItem where month(donetime) = "+month;
        return this.getNumberByQuery(query);
    }
    public float getRevenueByMonth(int month){
        String query = "SELECT SUM(Book.price * DeliveryItem.amount)\n" +
                        "FROM Book\n" +
                        "INNER JOIN DeliveryItem ON Book.id = DeliveryItem.book_id\n" +
                        "WHERE MONTH(DeliveryItem.donetime) = "+month;
         try {
            DBContext db = DBContext.getInstance();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            return 0f;
        }
        return 0f; 
    }
    public boolean didUserBuyProduct(Account account, Book book){
        if(account!=null){
            String query = "select * from DeliveryItem where username = '"+account.getUsername()
                    + "' and book_id = "+book.getId()
                    + " and donetime is not null";
            List<DeliveryItem> list = this.getListByQuery(query);
            return !list.isEmpty();
            }
        else return false;
    }
}
