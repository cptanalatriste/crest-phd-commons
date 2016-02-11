package crest.commons;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
	private final int id;
	private final int xCoord;
	private final int yCoord;

	//<ProductId, quantity>
	Map<Integer, Integer> products = new HashMap<Integer, Integer>();
	
	public WareHouse(int warehouseId, int warehouseX, int warehouseY){
		id = warehouseId;
		xCoord = warehouseX;
		yCoord = warehouseY;
	}

	public int getId() {
		return id;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}
	
	public void addProduct(int productId){
		if(products.containsKey(productId)){
			products.put(productId, 0);
		}
		
		products.put(productId, products.get(productId)+1);
	}
	
	public Map<Integer, Integer> getProducts(){
		return products;
	}

}
