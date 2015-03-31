import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Brandon Braun on 3/30/2015.
 *
 * The customer.accdb file contains the Customer database table
 *      ID: text
 *      CustomerName: text
 *      Address: text
 *      City: text
 *      State: text
 *      Zip: text
 *      Orders: currency
 *
 * The number of records in a database, of course, is unknown.
 *
 * Please develop a database application in Java to:
 *      Read records from the Customer database table into a data structure of your choice
 *      Allow the user to search for customers by a state (2 characters, case-insensitive).
 */
public class Project2 {
    public static void main(String[] args) {
        Map<String, List<Customer>> hashMap = createMap();
        List<Customer> customerList = getCustomers(hashMap);
        if (customerList != null) {
            for (Customer customer : customerList) {
                System.out.println(customer.getCustomerInfo());
            }
        }
        else {
            System.out.println("No customers exist in that state.");
        }
    }

    public static List<Customer> getCustomers(Map<String, List<Customer>> m) {
        String state = getUserInput("To search for customers, enter a state using its two letter abbreviation: ").toUpperCase();
        if (m.containsKey(state)) {
            return m.get(state);
        }
        return null;
    }

    public static Map<String, List<Customer>> createMap() {

        String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:customer";
        Connection con = null;
        Statement stmt = null;
        String sqlStatement = "SELECT ID, CustomerName, Address, City, State, Zip, Orders FROM Customer";
        ResultSet rs = null;

        Map<String, List<Customer>> hashMap = new HashMap<String, List<Customer>>();
        String id;
        String customerName;
        String address;
        String city;
        String state;
        String zip;
        float orders;

        try {
            Class.forName(driverName).newInstance();

            con = DriverManager.getConnection(connectionURL);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                id = rs.getString("ID");
                customerName = rs.getString("CustomerName");
                address = rs.getString("Address");
                city = rs.getString("City");
                state = rs.getString("State").toUpperCase();
                zip = rs.getString("Zip");
                orders = rs.getFloat("Orders");

                if (!hashMap.containsKey(state)) {
                    hashMap.put(state, new ArrayList<Customer>());
                }
                hashMap.get(state).add(new Customer(id,customerName,address,city,state,zip,orders));
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;
    }
    static String getUserInput(String question) {
        String value = null;
        try {
            BufferedReader bufferedRead;
            System.out.print(question + ": ");
            bufferedRead = new BufferedReader(new InputStreamReader(System.in));
            value = bufferedRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
