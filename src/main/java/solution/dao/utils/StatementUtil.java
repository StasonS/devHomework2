package solution.dao.utils;

import solution.dao.utils.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Statement;

public class StatementUtil {



    public void executeUpdate(String sql) throws SQLException {

        Statement statement = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
