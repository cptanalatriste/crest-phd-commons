package crest.commons;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
	private final int id;
	private final int xCoord;
	private final int yCoord;
	private int[] numItems;
	
	public void syncProduct(){
//		for(int i=0;i<numItems.length;i++){
//			if(products.containsKey(numItems[i])){
//				int tmp = products.get(numItems[i])+1;
//				products.put(numItems[i], tmp);
//			}else{
//				products.put(numItems[i], 1);
//			}
//		}
		
		
	}
	
	public void setProduct(int prodId, int quantity){
		products.put(prodId, quantity);	
	}

	//<ProductId, quantity>
	Map<Integer, Integer> products = new HashMap<Integer, Integer>();
	
	public WareHouse(int warehouseId, int warehouseX, int warehouseY){
		id = warehouseId;
		xCoord = warehouseX;
		yCoord = warehouseY;
	}
	
	public WareHouse(int warehouseId, int warehouseX, int warehouseY, int numTypesProducts){
		id = warehouseId;
		xCoord = warehouseX;
		yCoord = warehouseY;
		numItems = new int[numTypesProducts];
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

	/**
	 * @return the numItems
	 */
	public int[] getNumItems() {
		return numItems;
	}

	/**
	 * @param numItems the numItems to set
	 */
	public void setNumItems(int[] numItems) {
		this.numItems = numItems;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
	}

	
}
