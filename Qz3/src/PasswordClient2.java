/**
Client-side program to 
  Take a user name and a password as its input.
  Pass the user name and password to the Server-side program for validation,
  via object serialization.
  Display a message returned by the Server-side program.

DateServer is running at 8899
PasswordServer is running at 8870
**/
import java.io.*;
import java.net.*;
import java.util.*;
public class PasswordClient2
{
public static void main(String []args) throws Exception {
  String host = "localhost";    
//  PrintWriter out; 
  ObjectOutputStream  out;
  ObjectInputStream objIn;
  BufferedReader in;
  Socket s = new Socket(host, 8899); // DateServer is running at 8899
// get the date/time
  //in = new BufferedReader
  //    (new InputStreamReader(s.getInputStream()));
  objIn = new ObjectInputStream(s.getInputStream());
  System.out.println("Current Date/time is: " + objIn.readObject());
  s.close();

  Scanner input = new Scanner(System.in);
  String userName, password;
  System.out.print("Enter user name: ");
  userName = input.nextLine();
  System.out.print("Enter password: ");
  password = input.nextLine();   

  s = new Socket(host, 8870);
// out = new PrintWriter(s.getOutputStream());
  out = new ObjectOutputStream(s.getOutputStream());
//  out.println(userName + "  " + password);
  out.writeObject(new String(userName + "  " + password));
  out.flush();
  in = new BufferedReader
      (new InputStreamReader(s.getInputStream()));
  System.out.println(in.readLine());
  s.close();
  } // main  
} // PasswordClient2