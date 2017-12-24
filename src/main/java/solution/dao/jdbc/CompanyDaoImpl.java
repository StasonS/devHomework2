package solution.dao.jdbc;

import solution.dao.utils.ConnectionUtil;
import solution.dao.interfaces.CompanyDAO;
import solution.model.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDAO {

    @Override
    public void create(Company company) throws SQLException {

        String sql = "INSERT INTO companies (company_name) VALUES (?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, company.getName());
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
    public Company read(Long id) throws SQLException {

        String sql = "SELECT * FROM companies WHERE id = " + id;
        Statement statement = null;
        ResultSet resultSet = null;
        Company company = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            company = new Company();

            while (resultSet.next()){
                Long companyId = resultSet.getLong(1);
                String company_name = resultSet.getString(2);

                company = new Company().withId(companyId)
                        .withCompanyName(company_name);
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

        return company;
//        System.out.println(company);

    }

    @Override
    public void update(Long id, Company company) throws SQLException {

        String sql = "UPDATE companies SET company_name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setLong(2, id);
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
    public void delete(Long id) throws SQLException {

        String sql = "DELETE FROM companies WHERE id = " + id;
        Statement statement = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                statement.close();
        }
    }

    @Override
    public List<Company> getAll() throws SQLException {

        String sql = "SELECT * FROM companies";
        Statement statement = null;
        List<Company> companies = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String company_name = resultSet.getString("company_name");
                companies.add(new Company(id, company_name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return companies;
    }

    private void statementExecutor(Company company){

    }
}
