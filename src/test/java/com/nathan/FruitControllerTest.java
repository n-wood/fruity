package com.nathan;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import com.google.gson.Gson;

public class FruitControllerTest {

	Gson gson = new Gson();
	
	private static double SMALL_NUMBER=0.0000001d;
	
	@Test
	public void testNoQueryString() 
	{
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest), Basket.class);
		assertEquals(0,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	}
	
	@Test
	public void testEmptyString() 
	{
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "");
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest), Basket.class);
		assertEquals(0,result.getTotalCost().doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testPopulatedQueryString() 
	{
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "orange,apple");
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest), Basket.class);
		assertEquals(0.85,result.getTotalCost().doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testBadInput() 
	{
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "orange,apple,coconut");
		FruitController unit = new FruitController();
		
		try
		{
			unit.getRequest(mockRequest);
		}
		catch (IllegalArgumentException ae)
		{
			assertEquals("Can't find a fruit Enum that matches coconut", ae.getMessage());
			return;
		}
		fail("Shouldn't have got this far!");
	}

}
