package crest.commons;

import java.util.HashSet;
import java.util.Set;

public class Game implements IGame {
	
	private int gameWidth=-1;
	private int gameHeight=-1;
	private int maxTurns=0;
	
	private Set<WareHouse> warehouses = new HashSet<WareHouse>();
	private Set<ProductType> products = new HashSet<ProductType>();
	private Set<ProductType> orders = new HashSet<ProductType>();
	private Set<Drone> drones = new HashSet<Drone>();

	public void setWidth(int width) {
		if(width <= 0){
			System.out.println("ERROR: Width cannot be <= 0");
			assert(false);
		}
		
		if(gameWidth != -1){
			System.out.println("ERROR: Width already set!");
			assert(false);
		}
	}

	public void setHeight(int height) {
		if(height <= 0){
			System.out.println("ERROR: Height cannot be <= 0");
			assert(false);
		}
		
		if(gameHeight != -1){
			System.out.println("ERROR: Height already set!");
			assert(false);
		}

	}
	
	private void checkInitialised(){
		if(gameHeight == -1 || gameWidth == -1){
			System.out.println("ERROR: Height and Width must be set before calling this function!");
			assert(false);
		}
	}

	public void setMaxTurns(int turns) {
		checkInitialised();
		maxTurns=turns;
	}

	public void addDoneAtLocation(int id, int x, int y) {
		checkInitialised();
		drones.add(new Drone(id, x, y));
	}

	public void addWarehoue(int id, int x, int y) {
		checkInitialised();
		warehouses.add(new WareHouse(id, x, y));
	}

	public void addProduct(int id, int weight) {
		checkInitialised();
		products.add(new ProductType(id, weight));
	}

	public void addProductAtWarehouse(int warehouseId, int productID) {
		checkInitialised();
		boolean found=true;
		for(WareHouse w : warehouses){
			if(w.getId() == warehouseId){
				
				w.addProduct(productID);
			}
		}
	}

	public void addOrder(int id) {
		checkInitialised();

	}

	public void addToOrder(int orderId, int productId) {
		checkInitialised();

	}

	public Set<WareHouse> getWareHouses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public WareHouse getWareHouse(int id){
		for(WareHouse w : warehouses){
			if(w.getId() == id){
				return w;
			}
		}
		
		return null;
	}

	public Set<ProductType> getProductTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProductType getProductType(int id){
		for(ProductType p: )
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMaxTurns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Drone> getDrones() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addOrder(int id, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
