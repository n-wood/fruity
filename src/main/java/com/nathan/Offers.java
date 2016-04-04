package com.nathan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import com.nathan.Products.Fruit;

public class Offers 
{
	/**
	 * Calculates the amount of discount for apple and orange multibuy.
	 * @param basket Fruit list
	 * @return discount to be applied.
	 */
	public static BigDecimal calculateDiscount(ArrayList<Fruit> basket)
	{
		int apples = count(Fruit.APPLE, basket);
		int oranges = count(Fruit.ORANGE, basket);
		
		BigDecimal discountApples = Products.getPrice(Fruit.APPLE).multiply(BigDecimal.valueOf(Math.floor(apples/2)));
		BigDecimal discountOranges = Products.getPrice(Fruit.ORANGE).multiply(BigDecimal.valueOf(Math.floor(oranges/3)));
		
			
		return discountApples.add(discountOranges).setScale(2, RoundingMode.HALF_UP);
	}
	
	private static int count(Fruit fruitType, ArrayList<Fruit> basket)
	{
		if (basket == null)
		{
			return 0;
		}
		
		int count = 0;
		for (Fruit item: basket)
		{
			if (fruitType.equals(item))
			{
				count++;
			}
		}
		
		return count;
	}
	
}
