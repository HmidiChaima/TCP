package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTCP {
	
	public static List<Compte> lc=new ArrayList<Compte>();
	
	public static void main (String args[]) {
		try {
			
			ServerSocket sc=new ServerSocket(4000);
			while(true) {
				Socket s=sc.accept();
				Traitement t=new Traitement(s);
				t.start();
			}}
		
		catch(Exception e) {e.printStackTrace(); }
	}

}
