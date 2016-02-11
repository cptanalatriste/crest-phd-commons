package crest.commons;

import java.util.HashSet;
import java.util.Set;

public class Game implements IGame {

	/*
	 * Variables
	 * 
	 * @author: Lingbo
	 */
	public int width;
	public int height;
	public int maxPlayload;
	public int numTypesProducts;
	public int[] productTypes;
	public int numWarehouses;
	public WareHouse[] wareHouses;
	public int numOrders;
	public Order[] orders_array;
	public Drone[] drones_array;
	public int num_drones;

	public void syncVar() {
		this.gameWidth = this.width;
		this.gameHeight = this.height;

		for (WareHouse e : wareHouses) {
			warehouses.add(e);
		}

		for (Order e : orders_array) {
			orders.add(e);
		}

//		for (Drone e : drones_array) {
//			drones.add(e);
//		}

		for (int i = 0; i < productTypes.length; i++) {
			products.add(new ProductType(i, productTypes[i]));
		}
	}

	private int gameWidth = -1;
	private int gameHeight = -1;
	private int maxTurns = 0;

	private Set<WareHouse> warehouses = new HashSet<WareHouse>();
	private Set<ProductType> products = new HashSet<ProductType>();
	private Set<Order> orders = new HashSet<Order>();
	private Set<Drone> drones = new HashSet<Drone>();

	public void setWidth(int width) {
		if (width <= 0) {
			System.out.println("ERROR: Width cannot be <= 0");
			assert (false);
		}

		if (gameWidth != -1) {
			System.out.println("ERROR: Width already set!");
			assert (false);
		}

		gameWidth = width;
	}

	public void setHeight(int height) {
		if (height <= 0) {
			System.out.println("ERROR: Height cannot be <= 0");
			assert (false);
		}

		if (gameHeight != -1) {
			System.out.println("ERROR: Height already set!");
			assert (false);
		}
		gameHeight = height;
	}

	private void checkInitialised() {
		if (gameHeight == -1 || gameWidth == -1) {
			System.out.println("ERROR: Height and Width must be set before calling this function!");
			assert (false);
		}
	}

	public void setMaxTurns(int turns) {
		checkInitialised();
		maxTurns = turns;
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
		boolean found = true;
		for (WareHouse w : warehouses) {
			if (w.getId() == warehouseId) {

				w.addProduct(productID);
			}
		}
	}

	public void addToOrder(int orderId, int productId) {
		checkInitialised();
		Order order = getOrder(orderId);
		assert (order != null);
		assert (getProductType(productId) != null);
		order.addToOrder(productId);

	}

	public Set<WareHouse> getWareHouses() {
		return warehouses;
	}

	public WareHouse getWareHouse(int id) {
		for (WareHouse w : warehouses) {
			if (w.getId() == id) {
				return w;
			}
		}

		return null;
	}

	public ProductType getProductType(int id) {
		for (ProductType p : products) {
			if (p.getId() == id) {
				return p;
			}
		}

		return null;
	}

	public int getWidth() {
		return gameWidth;
	}

	public int getHeight() {
		return gameHeight;
	}

	public int getMaxTurns() {
		return maxTurns;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public Set<Drone> getDrones() {
		return drones;
	}

	public void addOrder(int id, int x, int y) {
		orders.add(new Order(id, x, y));
	}

	public Order getOrder(int id) {
		for (Order p : orders) {
			if (p.getId() == id) {
				return p;
			}
		}

		return null;
	}

	public Set<ProductType> getProductTypes() {
		return products;
	}

	public Drone getDrone(int id) {
		for (Drone p : drones) {
			if (p.getId() == id) {
				return p;
			}
		}

		return null;
	}

}
