package solution;

import solution.dao.ConnectionUtil;
import solution.dao.jdbc.DeveloperDaoImpl;
import solution.model.Developer;

import java.sql.*;

public class Program {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        Developer dev = new Developer(7L, "Jora", "Pupkin");
        DeveloperDaoImpl developerDao = new DeveloperDaoImpl();
        developerDao.read(1L);

        developerDao.update(1L, dev);
        developerDao.read(1L);

//        try {
//            connection = ConnectionUtil.getConnection();
//            statement = connection.createStatement();
//
//            String sql = "SELECT * FROM developers";
//
//
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String first_name = resultSet.getString(2);
//                String last_name = resultSet.getString(3);
//
//                System.out.println(id + "\t" + first_name + "\t" + last_name + "\n=========");
//            }
//
//            resultSet.close();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }

    }
}
