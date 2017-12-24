package solution.action;

import solution.dao.interfaces.DBObject;
import solution.dao.interfaces.GenericDAO;
import solution.dao.jdbc.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Action {

    private static boolean exit = false;
    private static GenericDAO dao = null;
    private static DBObject dbObject = null;
    private static String db;
    private static String model;

    static {
        Greeting.greet();

        db = DBChooser.choose();
        model = modelChooser(db);
    }

    public void act(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char action;

        while(!exit) {

            System.out.println("Choose the action please:\n" +
                    "1 - create " + model + "\n" +
                    "2 - return " + model + "\n" +
                    "3 - update " + model + "\n" +
                    "4 - delete " + model + "\n" +
                    "5 - get all " + model + "\n" +
                    "6 - exit from program\n" +
                    "7 - add parameter to " + model + "\n" +
                    "8 - Change database\n" +
                    "Enter a number of action");
            try {
                action = (char) reader.read();
                if (action == '1'){
                    System.out.println("Enter a name of " + model);
                    BufferedReader r1 = new BufferedReader(new InputStreamReader(System.in));
                    String name = r1.readLine();
                    initDBO(null, name, model);
                    try {
                        dao.create(dbObject);
                        System.out.println(model + " added.\n");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    act();

                }
                else if (action == '2'){
                    System.out.print("Enter ID please: ");
                    BufferedReader r2 = new BufferedReader(new InputStreamReader(System.in));
                    Long id = Long.valueOf(r2.readLine());
                    try {
                        System.out.println(dao.read(id));
                        System.out.println("Done.\n");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    act();

                }
                else if (action == '3'){
                    BufferedReader r3 = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Enter ID please: ");
                    String tmp = r3.readLine();
                    Long id = Long.parseLong(tmp);
                    System.out.print("Enter a name please: ");
                    String name;
                    name = r3.readLine();
                    initDBO(id, name, model);

                    try {
                        dao.update(id, dbObject);
                        System.out.println("Done.\n");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    act();

                }
                else if (action == '4'){
                    BufferedReader r4 = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter ID");
                    Long id = Long.parseLong(r4.readLine());
                    try {
                        dao.delete(id);
                        System.out.println("Done.\n");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    act();

                }
                else if (action == '5'){

                    try {
                        List<DBObject> list = dao.getAll();
                        for (DBObject o : list){
                            System.out.println(o);
                        }
                        System.out.println("Done.\n");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    act();

                }
                else if (action == '6'){
                    exit = true;
                    System.out.println("Have a nice day!!!");
                }
                else if (action == '7'){

                    BufferedReader r7 = new BufferedReader(new InputStreamReader(System.in));
                    switch (db) {
                        case "developers": {
                            System.out.println("You can add skill to " + model + "\n" +
                                    "Choose a developer number to add skill");
                            Long devId = Long.parseLong(r7.readLine());
                            System.out.println("Choose a skill number");
                            Long skillId = Long.parseLong(r7.readLine());

                            DBObject object = null;
                            try {
                                object = (DBObject) dao.read(devId);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            try {
                                new ParamAdderDAOImpl().create(
                                        object,
                                        new SkillDaoImpl().read(skillId));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Done");
                            act();
                            break;
                        }
                        case "projects": {
                            System.out.println("You can add Developer to " + model + "\n" +
                                    "Choose a Project number to add Developer");
                            Long projId = Long.parseLong(r7.readLine());
                            System.out.println("Choose a Developer number");
                            Long devId = Long.parseLong(r7.readLine());

                            DBObject object = null;
                            try {
                                object = (DBObject) dao.read(projId);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            try {
                                new ParamAdderDAOImpl().create(
                                        object,
                                        new DeveloperDaoImpl().read(devId));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Done");
                            act();
                            break;
                        }
                        case "companies": {
                            System.out.println("You can add Project to " + model + "\n" +
                                    "Choose a Company number to add Project");
                            Long companyId = Long.parseLong(r7.readLine());
                            System.out.println("Choose a Project number");
                            Long projId = Long.parseLong(r7.readLine());

                            DBObject object = null;
                            try {
                                object = (DBObject) dao.read(companyId);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            try {
                                new ParamAdderDAOImpl().create(
                                        object,
                                        new ProjectDaoImpl().read(projId));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Done");
                            act();
                            break;
                        }
                        case "customers": {
                            System.out.println("You can add Project to " + model + "\n" +
                                    "Choose a Customer number to add Project");
                            Long customerId = Long.parseLong(r7.readLine());
                            System.out.println("Choose a Project number");
                            Long projId = Long.parseLong(r7.readLine());

                            DBObject object = null;
                            try {
                                object = (DBObject) dao.read(customerId);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            try {
                                new ParamAdderDAOImpl().create(
                                        object,
                                        new ProjectDaoImpl().read(projId));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Done");
                            act();
                            break;
                        }
                        default:
                            System.out.println("Can not add parameter\n");
                            act();
                            break;
                    }
                }
                else if (action == '8'){
                    DBChooser.listDB();
                    db = DBChooser.choose();
                    model = modelChooser(db);

                    act();

                }
                else {
                    System.out.println("Wrong number");
                    act();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String modelChooser(String db){
        String model = "";
        if (db != null) {
            switch (db){
                case "developers":
                    model = "Developer";
                    dao = new DeveloperDaoImpl();
                    break;
                case "skills":
                    model = "Skill";
                    dao = new SkillDaoImpl();
                    break;
                case "companies":
                    model = "Company";
                    dao = new CompanyDaoImpl();
                    break;
                case "customers":
                    model = "Customer";
                    dao = new CustomerDaoImpl();
                    break;
                case "projects":
                    model = "Project";
                    dao = new ProjectDaoImpl();
                    break;
            }
        }
        return model;
    }

    private void initDBO(Long id, String name, String model){
        try {
            Class<?> obj = Class.forName("solution.model." + model);
            try {
                dbObject = (DBObject) obj.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        dbObject.setId(id);
        dbObject.setName(name);
    }
}
