package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;
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
    return super.getDrone().getId()+" "+super.getCommandName()+" "+getWarehouse().getId()+" "+getProductType().getId()+" "+getProductQuantity();
  }

  @Override
  public void apply(IGame game) {
    this.getDrone().setXPos(warehouse.getxCoord());
    this.getDrone().setYPos(warehouse.getyCoord());

    int currentCapacity = getDrone().getCurrentCapacity(game);

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
