package crest.commons;

import crest.commons.solution.Command;

import java.util.List;

public class Drone {

  private int identifier;
  private List<Command> commands;
  private int currentPositionX;
  private int currentPositionY;

  public int getIdentifier() {
    return identifier;
  }

  public void setIdentifier(int identifier) {
    this.identifier = identifier;
  }

  public List<Command> getCommands() {
    return commands;
  }

  public void setCommands(List<Command> commands) {
    this.commands = commands;
  }

  public int getxCoord() {
    return currentPositionX;
  }

  public void setCurrentPositionX(int currentPositionX) {
    this.currentPositionX = currentPositionX;
  }

  public int getyCoord() {
    return currentPositionY;
  }

  public void setCurrentPositionY(int currentPositionY) {
    this.currentPositionY = currentPositionY;
  }

}
