package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Traitement extends Thread{
	Socket s;
	Boolean test=false;
	Compte compte=new Compte();
	
	public Traitement(Socket s) {
		this.s=s;
	}
 public void run() {
	 try {
		 BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		 
		 while(true) {
			 String msg=in.readLine();
			 if(msg.startsWith("CREATION")) {
				 String nom=msg.substring(9);
				 for(Compte c:ServerTCP.lc) {
					 if(c.getNom().equals(nom)) {
						 out.println("Un compte avec ce nom existe déjà");
						 test=true;
						 break;
					 }
					 
				 }
				 
				 if(test==false) {
					 
					 compte.setNom(nom);
					 compte.setSolde((float) 0);
					 out.println("Le compte est créé avec succès");
					 while(true) {
					 String msg1=in.readLine();
					  if(msg1.startsWith("CREDIT")) {
						 Float montant=Float.parseFloat(msg1.substring(7));
						 compte.crediteSolde(montant);
						 out.println("Le compte est crédité avec succès");}
						 
						 else if(msg1.startsWith("DEBIT")) {
							 Float montant2=Float.parseFloat(msg1.substring(6));							 
							 if(compte.getSolde()>montant2) {
								 compte.debitSolde(montant2);
								 out.println("Operation effectuéé avec succès");
							 }
							 else {out.println("Solde Insuffisant");}
							 }
							 
							 else if(msg1.startsWith("SOLDE")) {	 
							 
								 out.println(compte.getSolde());}
				 }} 
			 }
		 }
	 }catch(Exception e) {e.printStackTrace(); }
	}}
 

