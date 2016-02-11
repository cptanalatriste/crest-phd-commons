package crest.commons.solution;

import crest.commons.Drone;
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
    // TODO Auto-generated method stub
    return null;
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

}
