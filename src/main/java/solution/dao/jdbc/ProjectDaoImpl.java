package solution.dao.jdbc;

import solution.dao.utils.ConnectionUtil;
import solution.dao.interfaces.ProjectDAO;
import solution.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDAO {
    @Override
    public void create(Project project) throws SQLException {

        String sql = "INSERT INTO projects (project_name) VALUES (?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, project.getName());
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
    public Project read(Long id) throws SQLException {

        String sql = "SELECT * FROM projects WHERE id = " + id;
        Statement statement = null;
        ResultSet resultSet = null;
        Project project = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            project = new Project();

            while (resultSet.next()){
                Long projectId = resultSet.getLong(1);
                String project_name = resultSet.getString(2);

                project = new Project().withId(projectId)
                        .withProjectName(project_name);
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

        return project;
    }

    @Override
    public void update(Long id, Project project) throws SQLException {

        String sql = "UPDATE projects SET project_name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, project.getName());
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

        String sql = "DELETE FROM projects WHERE id = " + id;
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
    public List<Project> getAll() throws SQLException {

        String sql = "SELECT * FROM projects";
        Statement statement = null;
        List<Project> projects = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String project_name = resultSet.getString("project_name");
                projects.add(new Project(id, project_name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return projects;
    }
}
