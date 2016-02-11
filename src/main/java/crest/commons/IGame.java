package crest.commons;

public interface IGame {
	public void setWidth(int width);
	public void setHeight(int height);
	public void setMaxTurns(int turns);
	
	//All these return the ID, to be used later if needed
	public void addDoneAtLocation(int id, int x, int y);
	public void addWarehoue(int id, int x, int y);
	
	public void addProduct(int id, int weight);
	
	public void addProductAtWarehouse(int warehouseId, int productID);
	
	public void addOrder(int id);
	public void addToOrder(int orderId, int productId);
	
}
