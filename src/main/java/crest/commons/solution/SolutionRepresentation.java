package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;

import java.nio.file.Path;
import java.util.List;

public class SolutionRepresentation {

  private List<Drone> dronesWithCommands;

  public void run(IGame game) {
    int numberOfTurns = game.getMaxTurns();

    for (int turnNumber = 0; turnNumber < numberOfTurns; turnNumber += 1) {
      for (Drone drone : dronesWithCommands) {

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
