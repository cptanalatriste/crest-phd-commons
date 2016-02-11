package crest.commons.solution;

import crest.commons.Drone;

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

  public String getCommandName() {
    return commandName;
  }

  public abstract String asString();
}
