package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;

public class WaitCommand extends Command {

  private int turns;

  public WaitCommand(Drone drone, int turns) {
    super(drone, "W");
    this.turns = turns;
  }

  public int getTurns() {
    return turns;
  }

  @Override
  public String asString() {
    return super.getDrone().getId()+" "+super.getCommandName()+" "+getTurns();
  }

  @Override
  public boolean apply(IGame game) {
    if(getTurns() == super.turnNo){
    	return true;
    } else {
    	super.turnNo++;
    	return false;
    }
    
  }

}
