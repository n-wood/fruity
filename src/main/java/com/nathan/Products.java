package com.nathan;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Products 
{
	static Map<Fruit, BigDecimal> products;
	
	//TODO these values should be externalised for easy of change
	static {
		products =  new HashMap<Fruit, BigDecimal>();
		products.put(Fruit.APPLE , new BigDecimal("0.60"));
		products.put(Fruit.ORANGE, new BigDecimal("0.25"));
	}
	
	public enum Fruit {
		APPLE, ORANGE;
	
		public String toString(){
			switch (this) {
				case ORANGE: return "Orange";
				case APPLE: return "Apple";
				default: throw new IllegalArgumentException("No matching fruit");
			}
			
		}
	};
	/**
	 * Get a price for a piece of fruit
	 * 		
	 * @param fruit
	 * @return the price
	 */
	public static BigDecimal getPrice(Fruit fruit)
	{
		
			return products.get(fruit);
		
		
	}
	
	/**
	 * Get a price for a piece of fruit
	 * 		
	 * @param fruit
	 * @return the price
	 */
	public static BigDecimal getPrice(String fruit)
	{
			return products.get(getFruitFromString(fruit));
	}
	
	/**
	 * Geta fruit Enum for a supplied string
	 * 		
	 * @param fruit string
	 * @return Fruit enum
	 */
	public static Fruit getFruitFromString(String fruit)
	{
		Fruit fruitObj;
		
		if (fruit.equalsIgnoreCase(Fruit.APPLE.toString()))
		{
			fruitObj = Fruit.APPLE;
		}
		
		else if (fruit.equalsIgnoreCase(Fruit.ORANGE.toString()))
		{
			fruitObj = Fruit.ORANGE;
		}
		else
		{
			throw new IllegalArgumentException("Can't find a fruit Enum that matches " + fruit);
		}
		
		return fruitObj;
	}
	
	

}
