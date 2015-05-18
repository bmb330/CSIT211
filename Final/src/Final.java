import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

/**
 * Created by Brandon Braun on 5/16/2015.
 */
public class Final {
    public static void main(String[] args) {
        int port;
        ServerSocket server;
        Socket s;
        StringTokenizer parsedInfo;
        String state;
        String gender;
        Object obj;
        ObjectInputStream in;
        ObjectOutputStream out;
        Map<String, ArrayList<Citizen>> hmap;

        // set port
        if (args.length > 0)
            port = Integer.parseInt(args[0]);
        else {
            port = 8899;
        }

        // setup state information
        hmap = new HashMap<String, ArrayList<Citizen>>();
        importDB(hmap);

        // start listening for connections
        try {
            server = new ServerSocket(port);
            while (true) {
                // incoming connection
                s = server.accept();

                in = new ObjectInputStream(s.getInputStream());
                obj = in.readObject();

                parsedInfo = new StringTokenizer((String) obj);
                state = parsedInfo.nextToken().toUpperCase();
                gender = parsedInfo.nextToken().toUpperCase();

                out = new ObjectOutputStream(s.getOutputStream());
                sendData(state, gender, hmap, out);

                s.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendData(String state, String gender, Map<String, ArrayList<Citizen>> hmap, ObjectOutputStream out) {
        ArrayList<Citizen> arrList = hmap.get(state);
        try {
            for (int i = 0; i < arrList.size(); i++) {
                if (arrList.get(i).getGender().equals(gender)) {
                    out.writeObject(arrList.get(i));
                }
            }

            out.writeObject(null);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void importDB(Map<String, ArrayList<Citizen>> dbmap) {
        long id;
        int age;
        String state;
        String gender;
        int status;

        System.out.println("Importing DB, please wait...");

        // setup db connection
        String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:TermPJDatabase";
        Connection con = null;
        Statement stmt = null;
        String sqlStatement = "SELECT ID, Age, State, Gender, Status FROM Citizens";
        ResultSet rs = null;

        // connect to db and fill data structure with state information
        try {
            Class.forName(driverName).newInstance();

            con = DriverManager.getConnection(connectionURL);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                id = rs.getLong("ID");
                age = rs.getInt("Age");
                state = rs.getString("State").trim();
                gender = rs.getString("Gender").trim();
                status = rs.getInt("Status");

                if (!dbmap.containsKey(state)) {
                    dbmap.put(state, new ArrayList<Citizen>());
                }
                dbmap.get(state).add(new Citizen(id, age, state, gender, status));
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Importing DB completed. Waiting for connections....");
    }
}
