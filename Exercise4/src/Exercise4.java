import java.sql.*;

/**
 * Created by Brandon Braun on 3/23/2015.
 *
 * The Employee table consists of the following six (6) fields:
 * ID Title LastName Firstname Salary Email
 * Develop a program to read records from the Employee table (ex4.accdb) and display the first
 * name, title, salary, and email for each employee.
 */


public class Exercise4 {
    public static void main(String[] args) {
        try {
            runQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runQuery() {
        String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:ex4";
        //String connectionURL = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\ex4.accdb";

        Connection con = null;
        Statement stmt = null;

        String sqlStatement = "SELECT FirstName, Title, Salary, Email FROM Employee";
        ResultSet rs = null;

        String firstName;
        String title;
        String email;
        float salary;

        try {
            Class.forName(driverName).newInstance();

            con = DriverManager.getConnection(connectionURL);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                /*System.out.print("");
                for (int k = 1; k <= 4; ++k)
                    System.out.print(rs.getString(k)+ " ");
                System.out.println();*/
                firstName = rs.getString("FirstName");
                title = rs.getString("Title");
                salary = rs.getFloat("Salary");
                email = rs.getString("Email");

                if (firstName != null)
                    System.out.println("First Name: " + firstName + ", Title: " + title + ", Salary: " + salary + ", Email: " + email);

            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
