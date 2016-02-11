package crest.commons.solution;

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

}
