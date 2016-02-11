package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;
import crest.commons.ProductType;
import crest.commons.WareHouse;

import java.util.Map;

public class LoadCommand extends Command {

  private WareHouse warehouse;
  private ProductType productType;
  private int productQuantity;

  public LoadCommand(Drone drone, WareHouse warehouse, ProductType productType,
      int productQuantity) {
    super(drone, "L");
    this.warehouse = warehouse;
    this.productQuantity = productQuantity;
    this.productType = productType;
  }

  public ProductType getProductType() {
    return productType;
  }

  public WareHouse getWarehouse() {
    return warehouse;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  @Override
  public String asString() {
    return super.getDrone().getId() + " " + super.getCommandName() + " " + getWarehouse().getId()
        + " " + getProductType().getId() + " " + getProductQuantity();
  }

  @Override
  public boolean apply(IGame game) {
	  
    Drone drone = this.getDrone();

  /*  int pendingTurns = game.getMaxTurns() - drone.getCurrentTurn();
    if (getTurns() > pendingTurns) {
      throw new RuntimeException("Not enough turns to perform the command");
    }*/
    
    if(super.turnNo == getTurns()){
    	

    	drone.setXPos(warehouse.getxCoord());
    	drone.setYPos(warehouse.getyCoord());
    	int currentCapacity = drone.getCurrentCapacity(game);
    	if (currentCapacity < productType.getWeight()) {
    		throw new RuntimeException("The Drone doesn't have enough capacity");
    	} else {
    	int productTypeId = productType.getId();
      	drone.getProducts().put(productTypeId, productQuantity);
      	Map<Integer, Integer> productsInWarehouse = this.warehouse.getProducts();
      	productsInWarehouse.put(productTypeId,
    		  productsInWarehouse.get(productTypeId) - productQuantity);
    	}
    	super.turnNo++;
    	return false;
    } else {
    	return true;
    }

  }

  @Override
  public int getTurns() {
    int firstX = this.getDrone().getXPos();
    int firstY = this.getDrone().getYPos();
    int secondX = this.getWarehouse().getxCoord();
    int secondY = this.getWarehouse().getyCoord();
    double normalizedDistance = Math.ceil(this.getDistance(firstX, firstY, secondX, secondY));
    return (int) (normalizedDistance + 1);
  }

}
