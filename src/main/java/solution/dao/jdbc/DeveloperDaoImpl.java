package solution.dao.jdbc;

import solution.dao.ConnectionUtil;
import solution.dao.interfaces.DeveloperDAO;
import solution.model.Developer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDAO {
    @Override
    public void create(Developer developer) {

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
//            ResultSet resultSet = preparedStatement1.executeQuery(sql1);

            preparedStatement2 = ConnectionUtil.getConnection().prepareStatement(sql2);
            preparedStatement2.setString(1, developer.getLast_name());
            preparedStatement2.setLong(2, id);

//            resultSet = preparedStatement2.executeQuery(sql2);
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
    public void delete(Long aLong, Developer developer) {

    }


    @Override
    public List<Developer> getAll() {
        return null;
    }
}
