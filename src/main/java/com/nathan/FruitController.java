package com.nathan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController 
{
	

	@RequestMapping("/*")
	public ResponseEntity<String> getRequest(HttpServletRequest request)
	{
		String basket = request.getParameter("basket");
		Basket myBasket = new Basket();
		String response;
		try
		{
			myBasket.populateBasket(basket);
			response = myBasket.getReceipt();	
		}
		catch (IllegalArgumentException ae)
		{
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);		
				
		return new ResponseEntity<String>(response,headers,HttpStatus.OK);
	}

}
