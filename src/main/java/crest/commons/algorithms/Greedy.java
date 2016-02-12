/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crest.commons.algorithms;

import crest.commons.Drone;
import crest.commons.Game;
import crest.commons.Order;
import crest.commons.WareHouse;
import crest.commons.solution.Command;
import crest.commons.solution.DeliverCommand;
import crest.commons.solution.LoadCommand;
import crest.commons.solution.SolutionRepresentation;

import java.util.ArrayList;

/**
 *
 * @author J
 */
public class Greedy {

  public static int numOfBins(Game game, Order order, int capacity) {
    int numBins = 0;
    int currLoad = 0;
    int numItems = order.getNumItems();
    boolean[] flags = new boolean[numItems];
    for (int i = 0; i < numItems; i++) {
      flags[i] = true;
    }
    int leftProducts = numItems;
    while (leftProducts > 0) {
      numBins++;
      currLoad = 0;
      for (int i = 0; i < numItems; i++) {
        int weight = game.getProductType(order.getItemIndex()[i]).getWeight();
        if (flags[i] && currLoad + weight <= capacity) {
          flags[i] = false;
          currLoad += weight;
          leftProducts--;
        }
      }
    }
    return numBins;
  }

  public static void delivery(Game game, Drone drone, WareHouse wareHouse, Order order,
      int capacity) {
    int currLoad = 0;
    int numItems = order.getNumItems();
    boolean[] flags = new boolean[numItems];
    for (int i = 0; i < numItems; i++) {
      flags[i] = true;
    }
    ArrayList<Command> commands = new ArrayList<Command>();
    int leftProducts = numItems;
    int[] productID = new int[numItems];
    int[] productNum = new int[numItems];
    while (leftProducts > 0) {
      currLoad = 0;
      for (int i = 0; i < numItems; i++) {
        productID[i] = -1;
        productNum[i] = 0;
      }
      for (int i = 0; i < numItems; i++) {
        int[] itemIndex = order.getItemIndex();

        int weight = game.getProductType(itemIndex[i]).getWeight();
        if (flags[i] && currLoad + weight <= capacity) {
          flags[i] = false;
          currLoad += weight;
          leftProducts--;
          int productIndex = 0;
          while (productID[productIndex] >= 0 && productID[productIndex] != itemIndex[i]) {
            productIndex++;
          }
          if (productID[productIndex] < 0) {
            productID[productIndex] = itemIndex[i];
          }
          productNum[productIndex]++;
        }
      }
      // load bins and send
      int productIndex = 0;
      while (productIndex < productID.length && productID[productIndex] >= 0) {
        Command c = new LoadCommand(drone, wareHouse, game.getProductType(productID[productIndex]),
            productNum[productIndex]);
        commands.add(c);
        productIndex++;
      }
      productIndex = 0;
      while (productIndex < productID.length && productID[productIndex] >= 0) {
        Command c = new DeliverCommand(drone, order, game.getProductType(productID[productIndex]),
            productNum[productIndex]);
        commands.add(c);
        productIndex++;
      }
    }

    drone.getCommands().addAll(commands);
  }

  public static SolutionRepresentation greedy(Game game) {
    // sort orders
    int numOfOrders = game.getOrders().size();
    int[] droneTurns = new int[numOfOrders];
    int numberOfDrones = game.getDrones().size();

    int[] dronex = new int[numberOfDrones];
    int[] droney = new int[numberOfDrones];
    int[] droneAvailable = new int[numberOfDrones];
    int i = 0;
    for (i = 0; i < game.getOrders().size(); i++) {
      Order order = game.getOrder(i);
      droneTurns[i] = Command.getNormalizedDistance(game.getWareHouse(0), order)
          * (numOfBins(game, order, game.getMaxCapacity()) * 2) + order.getNumItems() * 2;
    }
    boolean[] flags = new boolean[numOfOrders];
    for (i = 0; i < numOfOrders; i++) {
      flags[i] = true;
    }
    int orderLeft = numOfOrders;
    for (i = 0; i < numberOfDrones; i++) {
      dronex[i] = game.getWareHouse(0).getXCoord();
      droney[i] = game.getWareHouse(0).getYCoord();
      droneAvailable[i] = 0;
    }
    while (orderLeft > 0) {
      int leastIndex = -1;
      for (i = 0; i < numOfOrders; i++) {
        if (flags[i] && (leastIndex == -1 || droneTurns[leastIndex] > droneTurns[i])) {
          leastIndex = i;
        }
      }
      int droneID = 0;
      for (i = 0; i < numberOfDrones; i++) {
        if (droneAvailable[i] < droneAvailable[droneID]) {
          droneID = i;
        }
      }
      if (droneTurns[leastIndex] + droneAvailable[droneID] >= game.getMaxTurns()) {
        break;
      }
      delivery(game, game.getDrone(droneID), game.getWareHouse(0), game.getOrder(leastIndex),
          game.getMaxCapacity());
      droneAvailable[droneID] += droneTurns[leastIndex];
      flags[leastIndex] = false;
      orderLeft--;
    }
    return new SolutionRepresentation(game.getDrones());
  }
}