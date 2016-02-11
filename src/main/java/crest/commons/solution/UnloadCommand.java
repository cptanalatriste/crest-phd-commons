package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;
import crest.commons.ProductType;
import crest.commons.WareHouse;

public class UnloadCommand extends Command {

  private WareHouse warehouse;
  private ProductType productType;
  private int productQuantity;
  private LoadCommand loadC;

  public UnloadCommand(Drone drone, WareHouse warehouse, ProductType productType,
      int productQuantity) {
    super(drone, "U");
    this.warehouse = warehouse;
    this.productQuantity = productQuantity;
    this.productType = productType;
    loadC = new LoadCommand(this.getDrone(), warehouse, productType,
            -1*productQuantity);
  }

  @Override
  public String asString() {
    return super.getDrone().getId() + " " + super.getCommandName() + " " + getWarehouse().getId()
        + " " + getProductType().getId() + " " + getProductQuantity();
  }

  @Override
  public int getTurns() {
	  assert(false); //This should be unreachable.
	  return -1;
   /* LoadCommand loadCommand = new LoadCommand(this.getDrone(), warehouse, productType,
        productQuantity);
    return loadCommand.getTurns();*/
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
  public boolean apply(IGame game) {
    return loadC.apply(game);
  }
}
