package com.nathan;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Before;


import com.nathan.Products.Fruit;

public class OffersTest {

	ArrayList<Fruit> input;
	
	private static double SMALL_NUMBER=0.0000001d;
	
	@Before
	public void setup()
	{
		input = new ArrayList<Fruit>();
	}
	
	
	
	
	@Test
	public void testOffersNone() {
		input.add(Fruit.APPLE);
		input.add(Fruit.ORANGE);
		assertEquals(0, Offers.calculateDiscount(input).doubleValue(),SMALL_NUMBER);
	}
	
	
	@Test
	public void testOffersApple() {
		input.add(Fruit.APPLE);
		input.add(Fruit.APPLE);
		assertEquals(0.60, Offers.calculateDiscount(input).doubleValue(),SMALL_NUMBER);
	}
	
	
	@Test
	public void testOffersOrange() {
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		assertEquals(0.25, Offers.calculateDiscount(input).doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testOffersCombo() {
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.ORANGE);
		input.add(Fruit.APPLE);
		input.add(Fruit.APPLE);
		input.add(Fruit.APPLE);
		//6 oranges and 3 apples = 2 free oranges (0.5) and 1 free apple (0.6)
		assertEquals(1.10, Offers.calculateDiscount(input).doubleValue(),SMALL_NUMBER);
	}
	

}
