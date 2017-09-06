package cardPackage;

//Alexander Repin
//033915133
//A3

import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;
import java.io.*;
import java.lang.*;



public class CreditServer  
{
	public static void main(String[] args) {
	ServerSocket server;
	try
	{

		server = new ServerSocket(5133);
		System.out.println("Listening for a connection...");
		
		
		Socket socketConnection = server.accept();
		System.out.println("Connected to: " + socketConnection.getInetAddress()
		+ " at port: " + socketConnection.getLocalPort());
		
		ObjectOutputStream oosToClient = new ObjectOutputStream(
				socketConnection.getOutputStream());

		ObjectInputStream oisFromClient = new ObjectInputStream(
				socketConnection.getInputStream());
		
		//Local
		//CreditCard creditcard = new CreditCard();
		
			try
			{
			while(true)
				{
					//Read
					CreditCard c = (CreditCard) oisFromClient.readObject();
					System.out.println("Receiving object...");
					
					
					//isValid()
					CardValidation cv = new CardValidation();
					boolean test = cv.isValid(c.getCreditCardNumber());
					
					System.out.println("Passed the test: " + test);
					c.getRegistered(cv.isValid(c.getCreditCardNumber()));
					/*
					creditcard.getValid(c.getCreditCardNumber());
					//Register
					creditcard.getRegistered(c.getValid());
					
					*/
					//Send
					oosToClient.writeObject(c);
					oosToClient.flush();
					
				}
			}
			catch(ClassNotFoundException cnf){
				cnf.printStackTrace();
			}
			catch (EOFException eof) {
				System.out.println("Client has terminated connection...");
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
			
		oosToClient.close();
		oisFromClient.close();
		socketConnection.close();	
		
		System.out.println("Server has closed connection...");

	
	}
	catch(Exception e)
	{
		System.out.println("Error: " + e);
		
	}
	
	System.out.println("Server offline...");
	}
}
