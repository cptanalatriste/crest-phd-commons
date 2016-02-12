package crest.commons.solution;

import java.util.HashMap;
import java.util.Map;

import crest.commons.Drone;
import crest.commons.IGame;
import crest.commons.Order;
import crest.commons.ProductType;

public class DeliverCommand extends Command {

  private Order order;
  private ProductType productType;
  private int quantity;

  public DeliverCommand(Drone drone, Order order, ProductType productType, int quantity) {
    super(drone, "D");
    this.order = order;
    this.productType = productType;
    this.quantity = quantity;
  }

  public Order getOrder() {
    return order;
  }

  public ProductType getProductType() {
    return productType;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String asString() {
    return super.getDrone().getId()+" "+super.getCommandName()+" "+getOrder().getId()+" "+getProductType().getId()+" "+getQuantity();
  }

  @Override
  public int getTurns() {
    int firstX = this.getDrone().getXPos();
    int firstY = this.getDrone().getYPos();
    int secondX = 0;
    int secondY = 0;
    double normalizedDistance = Math.ceil(this.getDistance(firstX, firstY, secondX, secondY));
    return (int) (normalizedDistance + 1);

  }

  @Override
  public boolean apply(IGame game) {
	 if(getTurns() == super.turnNo){
		 //Travel
		 this.getDrone().setXPos(this.getOrder().getXCoord());
    	this.getDrone().setYPos(this.getOrder().getYCoord());
    
    	//Update the delivery info in the order
    	Map<Integer, Integer> delivered = this.getOrder().getDelivered();
    	if(!delivered.containsKey(getProductType().getId())){
    		delivered.put(getProductType().getId(), 0);
    	}
    
    	delivered.put(getProductType().getId(), delivered.get(getProductType().getId()) + getQuantity());
    

    	this.getOrder().setDelivered(delivered, game.getCurrentTurn());
    
    	//Remove the products from the Drone
    	this.getDrone().setProducts(new HashMap<Integer, Integer>());
    	return true;
	 } else {
		 super.turnNo++;
		 return false;
	 }
  }

}
