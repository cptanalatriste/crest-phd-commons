package crest.commons.solution;

import crest.commons.Drone;
import crest.commons.IGame;
import crest.commons.Trackable;

import org.apache.commons.math3.ml.distance.EuclideanDistance;

public abstract class Command {

  private Drone drone;
  private String commandName;
  protected int turnNo = 0;

  public Command(Drone drone, String commandName) {
    this.drone = drone;
    this.commandName = commandName;
  }

  public Drone getDrone() {
    return this.drone;
  }

  public static double getDistance(Trackable firstItem, Trackable secondItem) {
    EuclideanDistance distance = new EuclideanDistance();

    double[] firstPoint = new double[] { firstItem.getXCoord(), firstItem.getYCoord() };
    double[] secondPoint = new double[] { secondItem.getXCoord(), secondItem.getYCoord() };
    return distance.compute(firstPoint, secondPoint);
  }

  public static int getNormalizedDistance(Trackable firstItem, Trackable secondItem) {
    return (int) Math.ceil(getDistance(firstItem, secondItem));
  }

  public abstract int getTurns();

  public String getCommandName() {
    return commandName;
  }

  public abstract String asString();

  public abstract boolean apply(IGame game);
}
