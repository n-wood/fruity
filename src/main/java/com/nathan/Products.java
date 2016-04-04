package com.nathan;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Products 
{
	static Map<Fruit, BigDecimal> products;
	
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
			
	public static BigDecimal getPrice(Fruit fruit)
	{
		
			return products.get(fruit);
		
		
	}
	
	public static BigDecimal getPrice(String fruit)
	{
			return products.get(getFruitFromString(fruit));
	}
	
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
