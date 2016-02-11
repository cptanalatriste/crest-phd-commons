package crest.commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {
	
	//<ProductId, quantity>
	Map<Integer, Integer> orderDetails = new HashMap<Integer, Integer>();
	private final int id;
	private final int xCoord;
	private final int yCoord;
	public int numItems;
	public int[] itemIndex;
	
	public Order(int orderId, int x, int y){
		id = orderId;
		xCoord=x;
		yCoord=y;
	}
	
	public void addToOrder(int itemId){
		if(orderDetails.containsKey(itemId)){
			orderDetails.put(itemId, 0);
		}
		
		orderDetails.put(itemId, orderDetails.get(itemId)+1);
	}
	
	public int getId(){
		return id;
	}

	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}
}
