package cardPackage;

//Alexander Repin
//033915133
//A3

import java.io.Serializable;

public class CreditCard implements Serializable{

	CreditCard creditcard;
	private long creditCardNumber;
	private boolean isValid;

	public CreditCard()
	{
		this.creditCardNumber = 0L;
		this.isValid = false;
	}
	
	public CreditCard(long c, boolean b)
	{
		this.creditCardNumber = c;
		this.isValid = b;
	}
	public void getRegistered(boolean valid)
	{
		this.isValid = valid;
	}
	public String toString()
	{
		return "CreditCard{ Credit Card Number= " +creditCardNumber+ " Valid= " + isValid+ "}"; 
	}
	
	public boolean getValid()
	{
		return this.isValid;
	}
	public long getCreditCardNumber()
	{
		return this.creditCardNumber;
	}
	
	
}