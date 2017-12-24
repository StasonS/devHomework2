package solution.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBChooser {

    static {
        listDB();
    }

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String db = "";

    public static String choose(){
        try {
            db = reader.readLine();
            return db;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void listDB(){
        System.out.println("Select a database please you want to work with:\n" +
                "- developers\n" +
                "- skills\n" +
                "- companies\n" +
                "- customers\n" +
                "- projects");
    }
}
