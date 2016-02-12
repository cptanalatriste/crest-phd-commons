package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class SolutionRepresentation {

  private List<Drone> dronesWithCommands;
  private int numberOfCommands;

  public SolutionRepresentation(Set<Drone> dronesWithCommands) {
    this.dronesWithCommands = new ArrayList<Drone>(dronesWithCommands);
    numberOfCommands = 0;

    Collections.sort(this.dronesWithCommands, new Comparator<Drone>() {

      public int compare(Drone o1, Drone o2) {
        Integer firstDroneId = o1.getId();
        Integer secondDroneId = o2.getId();

        return firstDroneId.compareTo(secondDroneId);
      }
    });

    for (Drone drone : dronesWithCommands) {
      numberOfCommands += drone.getCommands().size();
    }
  }

  public void run(IGame game) {
    for (int i = 0; i < game.getMaxTurns(); i++) {
      for (Drone d : game.getDrones()) {
        d.applyTurn(game);
        game.setCurrentTurn(game.getCurrentTurn() + 1);
      }
    }
  }

  public String getSolutionAsString() {
    String toReturn = numberOfCommands + "\n";
    for (Drone d : dronesWithCommands) {
      for (int i = 0; i < d.getCommands().size(); i++) {
        toReturn += d.getCommands().get(i).asString() + "\n";
      }
    }
    return toReturn;
  }

  public void generateProgramFile(Path filePath) throws IOException {
    String solutionAsString = this.getSolutionAsString();
    Files.write(filePath, solutionAsString.getBytes());
  }
}
