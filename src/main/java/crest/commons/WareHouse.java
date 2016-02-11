package crest.commons;

public class WareHouse {
	private final int id;
	private final int xCoord;
	private final int yCoord;
	
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

}
