package solution.dao.jdbc;

import solution.dao.utils.ConnectionUtil;
import solution.dao.utils.StatementUtil;
import solution.dao.interfaces.SkillDAO;
import solution.model.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl implements SkillDAO {

    @Override
    public void create(Skill skill) throws SQLException {

        String sql = "INSERT INTO skills (skill_name) VALUES (?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, skill.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    @Override
    public Skill read(Long id) throws SQLException {

        String sql = "SELECT * FROM skills WHERE id = " + id;
        Statement statement = null;
        ResultSet resultSet = null;
        Skill skill = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            skill = new Skill();

            while (resultSet.next()){
                Long skillId = resultSet.getLong(1);
                String skill_name = resultSet.getString(2);

                skill = new Skill()
                        .withId(skillId)
                        .withSkillName(skill_name);
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

        return skill;
//        System.out.println(skill);

    }

    @Override
    public void update(Long id, Skill skill) throws SQLException {

        String sql = "UPDATE skills SET skill_name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, skill.getName());
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

        String sql = "DELETE FROM skills WHERE id = " + id;
        Statement statement = null;

        new StatementUtil().executeUpdate(sql);
    }

    @Override
    public List<Skill> getAll() throws SQLException {

        String sql = "SELECT * FROM skills";
        Statement statement = null;
        List<Skill> skills = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            statement = ConnectionUtil.getConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String skill_name = resultSet.getString("skill_name");
                skills.add(new Skill(id, skill_name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return skills;
    }
}
