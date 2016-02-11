package crest.commons.solution;

import crest.commons.Drone;

import java.nio.file.Path;
import java.util.List;

public class SolutionRepresentation {

  private List<Drone> dronesWithCommands;
  
  

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
