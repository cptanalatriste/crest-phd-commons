package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;

import java.nio.file.Path;
import java.util.List;

public class SolutionRepresentation {

  private static final int FIRST_TURN = 0;
  private List<Drone> dronesWithCommands;

  public void run(IGame game) {
    for (Drone drone : dronesWithCommands) {
      drone.setCurrentTurn(FIRST_TURN);
    }
    
    for (Drone drone: dronesWithCommands) {
      for(Command commandInDrone: drone.getCommands()) {
        commandInDrone.apply(game);
      }
    }
  }

  public String getSolutionAsString() {
    String toReturn = "";
    for (Drone d : dronesWithCommands) {
      for (int i = 0; i < d.getCommands().size(); i++) {
        toReturn += d.getCommands().get(i).asString() + "\n";
      }
    }
    return toReturn;
  }

  public void generateProgramFile(Path filePath) {

  }
}
