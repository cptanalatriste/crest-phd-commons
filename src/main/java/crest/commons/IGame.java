package crest.commons;

import java.util.Set;

public interface IGame {
	public void setWidth(int width);
	public void setHeight(int height);
	public void setMaxTurns(int turns);
	
	//All these return the ID, to be used later if needed
	public void addDoneAtLocation(int id, int x, int y);
	public void addWarehoue(int id, int x, int y);
	
	public void addProduct(int id, int weight);
	
	public void addProductAtWarehouse(int warehouseId, int productID);
	
	public void addOrder(int id, int x, int y);
	public void addToOrder(int orderId, int productId);
	
	public Set<WareHouse> getWareHouses();
	
	public Set<ProductType> getProductTypes();
	
	public int getWidth();
	
	public int getHeight();
	
	public int getMaxTurns();
	
	public Set<Order> getOrders();
	
	public Set<Drone> getDrones();
	
}
