package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.Socket;

public class Client {
	
	
	public static void main (String args[]) {
		try {
		Socket s= new Socket ("127.0.0.1",4000);
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		
		BufferedReader in_clavier=new BufferedReader (new  InputStreamReader(System.in));
		
		
		while(true) {
			String msg=in_clavier.readLine();
			out.println(msg);
			
			System.out.println(in.readLine());
		}
	}
		catch(Exception e) {e.printStackTrace(); }
		}

}