package crest.commons;

import crest.commons.solution.Command;

import java.util.List;

public class Drone {

  private final int identifier;
  private int xPos;
  private int yPos;
  
  private List<Command> commands;
  
  public Drone(int id, int x, int y){
	  identifier = id;
	  setYPos(x);
	  setYPos(y);
  }
  
  public List<Command> getCommands(){
	  return commands;
  }

public int getId(){
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
}
