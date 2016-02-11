package crest.commons;

import java.util.Map;
import java.util.HashMap;

public class Order {
	
	//<ProductId, quantity>
	Map<Integer, Integer> orderDetails = new HashMap<Integer, Integer>();
	private final int id;
	
	public Order(int orderId){
		id = orderId;
	}
	
	public void addToOrder(int itemId){
		if(orderDetails.containsKey(itemId)){
			orderDetails.put(itemId, 0);
		}
		
		orderDetails.put(itemId, orderDetails.get(itemId)+1);
	}
}
