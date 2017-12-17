package solution;

import solution.dao.ConnectionUtil;
import solution.dao.jdbc.DeveloperDaoImpl;
import solution.dao.jdbc.ParamAdderDAOImpl;
import solution.model.Developer;
import solution.model.Skill;

import java.sql.*;

public class Program {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String fName = "Egi";
        String lName = "Gofman";

        Developer dev = new Developer(7L, fName, lName);
        DeveloperDaoImpl developerDao = new DeveloperDaoImpl();


//        listAll();
//        developerDao.create(dev);
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        developerDao.delete(9L);
//        listAll();

        for (Developer d : developerDao.getAll()){
            System.out.println(d);
        }
    }

    public static void listAll() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionUtil.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM developers";


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);

                System.out.println(id + "\t" + first_name + "\t" + last_name + "\n=========");
            }

            resultSet.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
