/** A server program that returns the current date/time.
This server program runs forever.
The default port used is 8899
   To run:
         Java DateServer PortNumber
**/

import java.io.*;
import java.net.*;
import java.util.*;

public class DateServer
{  
 public static void main(String[] args ) throws IOException
   {  
   int port = 8899;
   if (args.length > 0) port = Integer.parseInt(args[0]);

   System.out.println("Date server is serving at port " + port);
   ServerSocket server = new ServerSocket(port);
   Socket s;
   //PrintWriter out;
   ObjectOutputStream objOut;
   while (true) // forever loop
      {  
      s = server.accept();
      System.out.println("Incoming.... ");
      //out = new PrintWriter(s.getOutputStream());
      objOut = new ObjectOutputStream(s.getOutputStream());
      //out.println(new Date().toString());
      objOut.writeObject(new Date().toString());
      System.out.println(new Date().toString());
      //out.flush();
      objOut.flush();
      System.out.flush();
      s.close();
      } // while
   } // main
} //DateServer
