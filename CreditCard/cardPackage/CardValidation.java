package cardPackage;

//Alexander Repin
//033915133
//A3

import java.util.Arrays;
import java.util.List;
import java.util.*;


public class CardValidation {
	public static void main(String[] args) 
	{
		long creditCardNumber = 4012888888881881L;
		System.out.println(isValid(creditCardNumber));
	}
	public static Long eval(List<Long> list) 
	{
		return list.stream().reduce(0L, (x, y) -> y + (10 * x));

	}
	public static Long evalRev(List<Long> list) 
	{
		Long y = 0L;
		for (int i = list.size() - 1; i >= 0; i--) {
			y = list.get(i) + 10 * y;
		}
		return y;
	}
	public static List<Long> toDigits(long l) {
		
		/*
		List<Long> list = new List<Long>();
		for(int i = 0;i <= 16;i++)
		{
			list.add(i);
		}
		return list;
		*/
		long temp = l;
		List<Long> list = new ArrayList<Long>();
		
		do{
			
			list.add(temp % 10);
			temp /= 10;
		}while(temp > 0);
		
		//Reverse the list
		Collections.reverse(list);
		
		return list;
		
	}
	public static List<Long> toDigitsReverse(long l) {
	
		long temp = l;
		List<Long> list = new ArrayList<Long>();
		
		do{
			
			list.add(temp % 10);
			temp /= 10;
		}while(temp > 0);
		
		return list;
		/*
		List<Long> list = new List<Long>();
		for(int i = 16;i<= 0;i--)
		{
			list.add(i);
		}
		return list;
		*/
	}
	public static List<Long> doubleSecond(List<Long> list) {

		for(Long l : list)
		{
			for(int i = list.size();i<=0;i-=2)
			{
				
				list.get(i);
				l*=l;
				list.set(i, l);
			}
		}
		return list;
		
	}
	public static long sumDigits(List<Long> list) {
		long total = 0;
		for(Long l : list)
		{
			 total += l;
		}
		total++;
		//System.out.println(total);
		return total;
	}
	public static boolean isValid(long l) {
				
		long total = l;
		List<Long> list = new ArrayList<Long>();
		list = toDigitsReverse(total);
		list = doubleSecond(list);
		total = sumDigits(list);
		
		//System.out.println(total);
		
		if(total % 10 == 0)
		{
			return true;
		}
		return false;
	}
}