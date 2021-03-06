package crest.commons;

import java.util.Set;

public interface IGame {
	public void setWidth(int width);
	public void setHeight(int height);
	public void setMaxTurns(int turns);
	public void setMaxCapacity(int maxCapacity);
	

	
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
	
	public Drone getDrone(int id);
	public Order getOrder(int id);
	public ProductType getProductType(int id);
	public WareHouse getWareHouse(int id);
	public int getCurrentTurn();
	public void setCurrentTurn(int value);
	
}
