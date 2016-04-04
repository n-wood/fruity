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

	
	
	@Test
	public void testPopulateBasketEmpty() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(0, result.getTotalCost().doubleValue(),0);
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket(null);
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0, result.getTotalCost().doubleValue(),0);
	}
	
	@Test
	public void testPopulateBasketSingleItem() 
	{
		Gson gson = new Gson();
		Basket unit = new Basket();
		unit.populateBasket("apple");
		String output = unit.getReceipt();
		Basket result = gson.fromJson(output, Basket.class);
		assertEquals(0.6,result.getTotalCost().doubleValue(),0);
		assertTrue(result.getBasket().contains(Products.Fruit.APPLE));
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(0.25, result.getTotalCost().doubleValue(),0);
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
		assertEquals(2.05,result.getTotalCost().doubleValue(),0);
		assertEquals(4, result.getBasket().size());
		
		gson = new Gson();
		unit = new Basket();
		unit.populateBasket("orange,ORANGE,OrAnGE,APPLE,APPLE,APPLE");
		output = unit.getReceipt();
		result = gson.fromJson(output, Basket.class);
		assertEquals(2.55, result.getTotalCost().doubleValue(),0);
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
}
