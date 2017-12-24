package solution;

import solution.action.Action;
import solution.dao.utils.ConnectionUtil;
import solution.dao.jdbc.DeveloperDaoImpl;
import solution.dao.jdbc.ParamAdderDAOImpl;
import solution.dao.jdbc.SkillDaoImpl;
import solution.model.Developer;
import solution.model.Skill;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        new Action().act();



//        DeveloperDaoImpl d = new DeveloperDaoImpl();
//        SkillDaoImpl s = new SkillDaoImpl();
//        ParamAdderDAOImpl p = new ParamAdderDAOImpl();
//
//        List<Developer> developers = new DeveloperDaoImpl().getAll();
//        List<Skill> skills = new SkillDaoImpl().getAll();
//
////        System.out.println(developers.get(0));
////        System.out.println(skills.get(3));
//
//
////        p.create(developers.get(0), skills.get(3));
////
//        p.read(new Developer(), new Skill(), 1L);
//        System.out.println();
//
//        for (Long[] pair : p.getAll(new Developer(), new Skill())){
//            System.out.println(pair[0] + " " + pair[1]);
//        }

        //==========================
//        String fName = "Egi";
//        String lName = "Gofman";
//
//        Developer dev = new Developer(7L, fName, lName);
//        DeveloperDaoImpl developerDao = new DeveloperDaoImpl();
        //============================

//        listAll();
//        developerDao.create(dev);
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        developerDao.delete(9L);
//        listAll();

//        for (Developer d : developerDao.getAll()){
//            System.out.println(d);
//        }
    }

//    public static void listAll() throws SQLException {
//        Connection connection = null;
//        Statement statement = null;
//
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
//    }
}
