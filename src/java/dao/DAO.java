package dao;

import context.DBContext;
import java.sql.ResultSet;

public class DAO {

    public ResultSet getResult(String query) {
        ResultSet rs = null;
        try {
            rs = DBContext.getInstance().getConnection().prepareStatement(query).executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
}
