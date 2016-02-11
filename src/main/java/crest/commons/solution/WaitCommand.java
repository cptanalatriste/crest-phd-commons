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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void apply(IGame game) {
    // TODO Auto-generated method stub
    
  }

}
