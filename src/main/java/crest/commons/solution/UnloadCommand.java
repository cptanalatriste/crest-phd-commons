package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.ProductType;
import crest.commons.WareHouse;

public class UnloadCommand extends Command {

  private WareHouse warehouse;
  private ProductType productType;
  private int productQuantity;

  public UnloadCommand(Drone drone) {
    super(drone, "U");
  }

  @Override
  public String asString() {
    return null;
  }

  @Override
  public int getTurns() {
    LoadCommand loadCommand = new LoadCommand(this.getDrone(), warehouse, productQuantity);
    return loadCommand.getTurns();
  }

  public WareHouse getWarehouse() {
    return this.warehouse;
  }

  public ProductType getProductType() {
    return productType;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  @Override
  public void apply() {
    // TODO Auto-generated method stub
    
  }
}
