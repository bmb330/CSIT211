import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brandon Braun on 5/16/2015.
 */
public class Client {
    public static void main(String[] args) {
        String host;
        int port;
        ArrayList<Citizen> results;
        String userInput;

        // set host
        if (args.length > 0) {
            host = args[0];
        }
        else {
            host = "localhost";
        }
        // set port
        if (args.length > 1)
            port = Integer.parseInt(args[0]);
        else {
            port = 8899;
        }

        try {
            userInput = getUserInput("Enter state (2 character abbr)") + " " + getUserInput("Enter gender (M or F)");
            results = getData(userInput, host, port);
            printResults(results);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printResults(ArrayList<Citizen> results) {
        for (int i = 0; i < results.size(); i++) {
            results.get(i).printInformation();
        }
    }

    static ArrayList<Citizen> getData(String userInput, String host, int port) {
        Socket s;
        ObjectInputStream in;
        ObjectOutputStream out;
        ArrayList<Citizen> results;

        results = new ArrayList<Citizen>();

        try {
            s = new Socket(host, port);
            Object obj;
            out = new ObjectOutputStream(s.getOutputStream());

            out.writeObject(new String(userInput));
            out.flush();

            in = new ObjectInputStream(s.getInputStream());

            while (true) {
                obj = in.readObject();
                if (obj instanceof Citizen) {
                    results.add((Citizen) obj);
                }
                if (obj == null)
                    break;
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
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
