import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class CookieClient{
	public static void main(String[] args){
		String hostName = args[0];
		int portNum = Integer.parseInt(args[1]);
		System.out.println("Connecting to " + hostName + ":" + portNum + "...");

		try{
			Socket cookieClin = new Socket(hostName, portNum);
			System.out.println("Connection established");

			System.out.print("Your fortune: ");
			InputStream streamer = cookieClin.getInputStream();
			Scanner sc = new Scanner(streamer);

			while(sc.hasNext()){
				System.out.println(sc.next());
			}

			cookieClin.close();
			System.out.println("Exiting");
		}
		catch (Exception e){
			System.out.println("Something went wrong.");
		}
	}
}