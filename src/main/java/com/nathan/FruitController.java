package com.nathan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController 
{
	

	@RequestMapping("/*")
	public String getRequest(HttpServletRequest request)
	{
		String basket = request.getParameter("basket");
		Basket myBasket = new Basket();
		myBasket.populateBasket(basket);
		myBasket.getReceipt();
				
		return myBasket.getReceipt();
	}

}
