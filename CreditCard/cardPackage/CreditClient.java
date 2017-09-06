package cardPackage;

//Alexander Repin
//033915133
//A3

import java.io.Serializable;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.net.*;
import java.rmi.*;
import java.lang.*;


public class CreditClient 
{
	public static void main(String[] args) 
	{
		Socket clientSocket;

		try
		{
			clientSocket = new Socket(InetAddress.getByName("localhost"),5133);
			System.out.println("Connected to host...");
			
			ObjectInputStream oisFromServer = new ObjectInputStream(clientSocket.getInputStream());

			ObjectOutputStream oosToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			
			
			//TEST 
			CreditCard creditcard = new CreditCard( 4012888888881881L, false);
			
			try {
				// send an object to the server
				oosToServer.writeObject(creditcard);
				oosToServer.flush();
				System.out.println("Sending Credit Card...");

				// receive an object from the server
				creditcard = (CreditCard) oisFromServer.readObject(); 
				System.out.println("Receiving Credit Card...");
				
				System.out.println(creditcard.toString());
													
				} catch (ClassNotFoundException cnf) {
					cnf.printStackTrace();
				} catch (EOFException eof) {
					System.out.println("Server has terminated connection...");
				} catch (IOException e) {
					e.printStackTrace();
				}
		oosToServer.close();
		oisFromServer.close();
		clientSocket.close();
		}

		
		catch(IOException e)
		{
			e.printStackTrace();
		}

		
		System.out.println("Client Offline...");

	}
}
