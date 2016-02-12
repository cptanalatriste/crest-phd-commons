package crest.commons;

import crest.commons.solution.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone implements Trackable {

  private final int identifier;
  private int xPos;
  private int yPos;

  private List<Command> commands;
  private int currentListPosition = 0;
  private int maxCapacity;
  private Map<Integer, Integer> products = new HashMap<Integer, Integer>();

  public Drone(int id, int x, int y) {
    identifier = id;
    this.commands = new ArrayList<Command>();
    setYPos(x);
    setYPos(y);
  }

  public int getId() {
    return getIdentifier();
  }

  public int getIdentifier() {
    return identifier;
  }

  public int getXCoord() {
    return xPos;
  }

  public int getYCoord() {
    return yPos;
  }

  public void setXPos(int xPos) {
    this.xPos = xPos;
  }

  public void setYPos(int yPos) {
    this.yPos = yPos;
  }

  public List<Command> getCommands() {
    return commands;
  }

  public void setCommands(List<Command> commands) {
    this.commands = commands;
  }

  public Map<Integer, Integer> getProducts() {
    return products;
  }

  public void setProducts(Map<Integer, Integer> products) {
    this.products = products;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public void setMaxCapacity(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public int getCurrentCapacity(IGame game) {
    int currentWeight = 0;

    for (Map.Entry<Integer, Integer> entry : products.entrySet()) {
      Integer productType = entry.getKey();
      Integer items = entry.getValue();

      currentWeight += items * game.getProductType(productType).getWeight();
    }

    return this.maxCapacity - currentWeight;
  }

  public void applyTurn(IGame game) {
    try {
      Command com = getCommands().get(currentListPosition);
      if (com.apply(game)) {
        currentListPosition++;
      }
    } catch (IndexOutOfBoundsException ex) {
    } // Soz, There are no more commands to execute bro.
  }

}
