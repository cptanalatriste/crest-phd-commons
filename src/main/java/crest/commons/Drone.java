package crest.commons;

import crest.commons.solution.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone {

  private final int identifier;
  private int xPos;
  private int yPos;
  private int currentTurn;

  private List<Command> commands;
  private int maxCapacity;
  private Map<Integer, Integer> products = new HashMap<Integer, Integer>();

  public Drone(int id, int x, int y) {
    identifier = id;
    setYPos(x);
    setYPos(y);
  }

  public int getId() {
    return getIdentifier();
  }

  public int getIdentifier() {
    return identifier;
  }

  public int getXPos() {
    return xPos;
  }

  public void setXPos(int xPos) {
    this.xPos = xPos;
  }

  public int getYPos() {
    return yPos;
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

  public int getCurrentTurn() {
    return currentTurn;
  }

  public void setCurrentTurn(int currentTurn) {
    this.currentTurn = currentTurn;
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

}
