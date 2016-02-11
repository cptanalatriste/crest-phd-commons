package crest.commons.solution;

import crest.commons.Drone;

import org.apache.commons.math3.ml.distance.EuclideanDistance;

public abstract class Command {

  private Drone drone;
  private String commandName;

  public Command(Drone drone, String commandName) {
    this.drone = drone;
    this.commandName = commandName;
  }

  public Drone getDrone() {
    return this.drone;
  }

  public double getDistance(int firstX, int firstY, int secondX, int secondY) {
    EuclideanDistance distance = new EuclideanDistance();

    double[] firstPoint = new double[] { firstX, firstY };
    double[] secondPoint = new double[] { secondX, secondY };
    return distance.compute(firstPoint, secondPoint);
  }

  public abstract int getTurns();

  public String getCommandName() {
    return commandName;
  }

  public abstract String asString();
}
