package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;

import java.nio.file.Path;
import java.util.List;

public class SolutionRepresentation {

  private List<Drone> dronesWithCommands;

  public void run(IGame game) {
	  for(int i=0; i<game.getMaxTurns();i++){
		  for(Drone d : game.getDrones()){
			  d.applyTurn(game);
			  game.setCurrentTurn(game.getCurrentTurn()+1);
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
