package crest.commons.solution;

import crest.commons.ProductType;
import crest.commons.WareHouse;

public class LoadCommand extends Command {

  private WareHouse warehouse;
  private ProductType productType;
  private int productQuantity;

  public LoadCommand(Drone drone, WareHouse warehouse, int productQuantity) {
    super(drone, "L");
    this.warehouse = warehouse;
    this.productQuantity = productQuantity;
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
    return "";
  }

}
