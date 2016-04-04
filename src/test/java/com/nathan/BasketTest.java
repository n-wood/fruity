/**
 * 
 */
package com.nathan;

import org.junit.Test;

import com.google.gson.Gson;

import static org.junit.Assert.*;

/**
 * @author nathan
 *
 */
public class BasketTest {

	//used in comparison of double numbers
	private static double SMALL_NUMBER=0.0000001d;
	
	@Test
	public void testPopulateBasketEmpty() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(0, result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket(null);
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0, result.getTotalCost().doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testPopulateBasketSingleItem() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("apple");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(0.6,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		assertTrue(result.getBasket().contains(Products.Fruit.APPLE));
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.25, result.getTotalCost().doubleValue(),SMALL_NUMBER);
		assertTrue(result.getBasket().contains(Products.Fruit.ORANGE));
	}
	

	@Test
	public void testPopulateBasketMultipleItems() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("apple,Apple,Orange,APPLE");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(2.05-0.60,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		assertEquals(4, result.getBasket().size());
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,ORANGE,OrAnGE,APPLE,APPLE,APPLE");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(2.55-0.60-0.25, result.getTotalCost().doubleValue(),SMALL_NUMBER);
		assertEquals(6, result.getBasket().size());
	}
	
	@Test
	public void testPopulateBasketWithCoconut() 
	{
	
		Basket unit = new Basket();
		try
		{
			unit.populateBasket("coconut");
		}
		catch (IllegalArgumentException ae)
		{
			assertEquals("Can't find a fruit Enum that matches coconut", ae.getMessage());
			return;
		}
		fail("Shouldn't have got this far!");
	}
	
	@Test
	public void testPopulateBasketBOGOFF() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("apple,Apple,APPLE,apple");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(2.40-1.20, result.getTotalCost().doubleValue(),SMALL_NUMBER);
				

		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("apple,Apple,apple");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(1.8-0.6,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		

		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("apple,Apple");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(1.2-0.6,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		

		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("apple");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.6,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	}
	
	@Test
	public void testPopulateBasketThreeForTwo() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("orange,orange,orange,orange,orange,orange,orange");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(1.75-0.5,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,orange,orange");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.75-0.25,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,orange");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.5,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.25,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	}
}
