package com.nathan;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.nathan.Products.Fruit;

public class Basket 
{
	private ArrayList<Fruit> basket;
	
	//	safest way to store currency
	private BigDecimal totalCost = new BigDecimal(0);
	
	/**
	 * 
	 * @param basketItems comma separated list of apples and oranges.
	 * @return
	 */
	public void populateBasket(String basketItems)
	{
		if (StringUtils.isEmpty(basketItems))
		{
			return ;
		}
		
		String[] items = basketItems.split(",");
		
		if (basket == null || items.length ==0 )
		{
			basket = new ArrayList<Products.Fruit>();
		}
		
		for (String item: items)
		{
			basket.add(Products.getFruitFromString(item.trim()));
			totalCost = totalCost.add(Products.getPrice(item.trim()));
		}
		
		return ;
	}
	
	/**
	 * 
	 * @return json formatted receipt containing order details and total cost. 
	 */
	public String getReceipt()
	{
		
		Gson gson = new Gson();
		String json = gson.toJson(this);
		
		return json +"\n";
	}

	public ArrayList<Fruit> getBasket() {
		return basket;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	
}
