package com.nathan;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;

import com.google.gson.Gson;

public class FruitControllerTest {

	
	
	private static double SMALL_NUMBER=0.0000001d;
	
	@Test
	public void testNoQueryString() 
	{
		Gson gson = new Gson();
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest).getBody(), Basket.class);
		assertEquals(0,result.getTotalCost().doubleValue(),SMALL_NUMBER);
		
	}
	
	@Test
	public void testEmptyString() 
	{
		Gson gson = new Gson();
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "");
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest).getBody(), Basket.class);
		assertEquals(0,result.getTotalCost().doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testPopulatedQueryString() 
	{
		Gson gson = new Gson();
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "orange,apple");
		FruitController unit = new FruitController();
		Basket result = gson.fromJson(unit.getRequest(mockRequest).getBody(), Basket.class);
		assertEquals(0.85,result.getTotalCost().doubleValue(),SMALL_NUMBER);
	}
	
	@Test
	public void testBadInput() 
	{
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("basket", "orange,apple,coconut");
		FruitController unit = new FruitController();
		
		
		assertEquals(HttpStatus.BAD_REQUEST,unit.getRequest(mockRequest).getStatusCode());
		
	}

}
