package com.nathan;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nathan.Products.Fruit;

public class ProductsTest {

	@Test
	public void testGetPriceEnum() 
	{
		assertEquals(0.6,Products.getPrice(Fruit.APPLE).doubleValue(),0);
		assertEquals(0.25,Products.getPrice(Fruit.ORANGE).doubleValue(),0);
		
	}
	@Test
	public void testGetPriceString() 
	{
		assertEquals(0.6,Products.getPrice("apple").doubleValue(),0);
		assertEquals(0.6,Products.getPrice("Apple").doubleValue(),0);
		assertEquals(0.25,Products.getPrice("orange").doubleValue(),0);
		assertEquals(0.25,Products.getPrice("ORANGE").doubleValue(),0);
		
	}
	
	@Test
	public void testGetPriceStringNegative() 
	{
		try
		{
			Products.getPrice("Coconut");	
		}
		catch (IllegalArgumentException ae)
		{
			assertEquals("Can't find a fruit Enum that matches Coconut", ae.getMessage());
			return;
		}
		fail("Shouldn't have got this far!");
		
	}
	
	@Test
	public void testGetFruitFromString() 
	{
		assertEquals(Fruit.APPLE,Products.getFruitFromString("apple"));
		assertEquals(Fruit.APPLE,Products.getFruitFromString("Apple"));
		assertEquals(Fruit.ORANGE,Products.getFruitFromString("orange"));
		assertEquals(Fruit.ORANGE,Products.getFruitFromString("ORANGE"));
		
	}
	
	@Test
	public void testGetFruitFromStringNegative() 
	{
		try 
		{
			assertEquals(Fruit.ORANGE,Products.getFruitFromString("COCONUT"));
		}
		catch (IllegalArgumentException ae)
		{
			assertEquals("Can't find a fruit Enum that matches COCONUT", ae.getMessage());
			return;
		}
		fail("Shouldn't have got this far!");
	}
}
