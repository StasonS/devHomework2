package solution.dao.jdbc;

import solution.dao.ConnectionUtil;
import solution.dao.interfaces.CustomerDAO;
import solution.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public void create(Customer customer) throws SQLException {

        String sql = "INSERT INTO customers (customer_name) VALUES (?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
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
    public void read(Long id) throws SQLException {

        String sql = "SELECT * FROM customers WHERE id = " + id;
        Statement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            customer = new Customer();

            while (resultSet.next()){
                Long customerId = resultSet.getLong(1);
                String customer_name = resultSet.getString(2);

                customer = new Customer().withId(customerId)
                        .withCustomerName(customer_name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        System.out.println(customer);

    }

    @Override
    public void update(Long id, Customer customer) throws SQLException {

        String sql = "UPDATE customers SET customer_name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setLong(2, id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    @Override
    public void delete(Long id) throws SQLException {

        String sql = "DELETE FROM customers WHERE id = " + id;
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

    @Override
    public List<Customer> getAll() throws SQLException {

        String sql = "SELECT * FROM customers";
        Statement statement = null;
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String customer_name = resultSet.getString("customer_name");
                customers.add(new Customer(id, customer_name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return customers;
    }
}
