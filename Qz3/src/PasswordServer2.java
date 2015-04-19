/**
Receives the user name and password sent by the Client-side program, 
via object serialization.
**/
import java.io.*;
import java.util.*;
import java.net.*;
public class PasswordServer2
{
//public static void main(String []args) throws IOException
public static void main(String []args) throws Exception
  {
  String line, userName, password;
  StringTokenizer st;
  HashMap <String, String> hm = new HashMap <String, String>();
  try {
      BufferedReader inFile = new BufferedReader(new FileReader("password.csv"));
      while ((line = inFile.readLine()) != null)
	{
	st = new StringTokenizer(line, ",");       
	userName = st.nextToken(",");
	password = st.nextToken(",");
        hm.put(userName, password);
	} // while not EOF
      inFile.close();
      } catch (Exception e) { System.err.println(e); }
 
   System.out.println("Password server is serving at 8870");
   ServerSocket server = new ServerSocket(8870);
   Socket s, s2;
   PrintWriter out; 
   //BufferedReader  in;
   ObjectInputStream objIn;
   while (true) // forever loop
      {  
      s = server.accept();
//    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      objIn = new ObjectInputStream(s.getInputStream());
//    line = in.readLine();
      line = (String) objIn.readObject();
      st = new StringTokenizer(line);       
      userName = st.nextToken();
      password = st.nextToken();
      s2 = new Socket("localhost", 8899); // DateServer is running at 8899
      //in = new BufferedReader(new InputStreamReader(s2.getInputStream()));
      objIn = new ObjectInputStream(s2.getInputStream());
      //System.out.println("Date/time : " + in.readLine());
      System.out.println("Date/time : " + objIn.readObject());
      s2.close();
      System.out.println("Validating " + line + " ....");
      System.out.flush();
      out = new PrintWriter(s.getOutputStream());
      if (hm.containsKey(userName))
         {
         if (hm.get(userName).equals(password))
            out.println("Login is granted.");
         else 
            out.println("Invalid user name or password.");
         }
      else
         out.println("Invalid user name or password.");
      out.flush();
      s.close();
      } // while
  } // main  
} // PasswordServer2
