package solution.dao.jdbc;

import solution.dao.ConnectionUtil;
import solution.dao.interfaces.DeveloperDAO;
import solution.model.Developer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDAO {
    @Override
    public void create(Developer developer) throws SQLException{

        String sql = "INSERT INTO developers (first_name, last_name) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, developer.getFirst_name());
            preparedStatement.setString(2, developer.getLast_name());
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }

    }

    @Override
    public void read(Long id) throws SQLException {

        String sql = "SELECT * FROM developers WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Developer developer = new Developer();

        while (resultSet.next()){
            Long developperId = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);

            developer.withId(developperId)
                    .withFirstName(firstName)
                    .withLastName(lastName);
        }

        System.out.println(developer);
    }

    @Override
    public void update(Long id, Developer developer) throws SQLException{

        String sql1 = "UPDATE developers SET first_name = ? WHERE id = ?";
        String sql2 = "UPDATE developers SET last_name = ? WHERE id = ?";
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        try {
            preparedStatement1 = ConnectionUtil.getConnection().prepareStatement(sql1);
            preparedStatement1.setString(1, developer.getFirst_name());
            preparedStatement1.setLong(2, id);
            preparedStatement1.executeUpdate();

            preparedStatement2 = ConnectionUtil.getConnection().prepareStatement(sql2);
            preparedStatement2.setString(1, developer.getLast_name());
            preparedStatement2.setLong(2, id);
            preparedStatement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement1 != null) {
                preparedStatement1.close();
            }
            if (preparedStatement2 != null) {
                preparedStatement2.close();
            }
        }


    }

    @Override
    public void delete(Long id) throws SQLException {

        String sql = "DELETE FROM developers WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }


    @Override
    public List<Developer> getAll() throws SQLException {

        String sql = "SELECT * FROM developers";
        Statement statement = null;
        List<Developer> devs = new ArrayList<>();
        Developer developer = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                devs.add(new Developer(id, first_name, last_name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return devs;
    }
}
