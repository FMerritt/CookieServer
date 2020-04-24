import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class CookieServer{
	public static void main(String[] args){
		int portNum = Integer.parseInt(args[0]);
	
		try {
			ServerSocket cookieServe = new ServerSocket(portNum);
			System.out.println("Listening on port " + portNum + "...");
			Socket cookieSock = cookieServe.accept();
			System.out.println("Connection established");

			OutputStream output = cookieSock.getOutputStream();
			PrintWriter sender = new PrintWriter(output);

			String simple = "OMG THIS WORKED!!!! Bye";
			sender.write(simple);
			System.out.println("Fortune sent");
			
			cookieSock.close();
			cookieServe.close();
			System.out.println("Exiting");
		}
		catch (Exception e){
			System.out.println("Something went wrong.");
		}

	} 
}



