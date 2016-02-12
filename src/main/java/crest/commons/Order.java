package crest.commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order implements Trackable {

  // <ProductId, quantity>
  private Map<Integer, Integer> orderDetails = new HashMap<Integer, Integer>();
  private Map<Integer, Integer> delivered = new HashMap<Integer, Integer>();

  private int turnCompleted = -1;

  private final int id;
  private final int xCoord;
  private final int yCoord;
  private int numItems;
  private int[] itemIndex;

  public Order(int orderId, int x, int y) {
    id = orderId;
    xCoord = x;
    yCoord = y;
  }

  public Order(int orderId, int x, int y, int numItems) {
    id = orderId;
    xCoord = x;
    yCoord = y;
    this.numItems = numItems;
  }

  public void addToOrder(int itemId) {
    if (orderDetails.containsKey(itemId)) {
      orderDetails.put(itemId, 0);
    }

    orderDetails.put(itemId, orderDetails.get(itemId) + 1);
  }

  public Map<Integer, Integer> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(Map<Integer, Integer> orderDetails) {
    this.orderDetails = orderDetails;
  }

  public Map<Integer, Integer> getDelivered() {
    return delivered;
  }

  public void setDelivered(Map<Integer, Integer> delivered, int currentTurn) {
    this.delivered = delivered;
    boolean done = true;
    for (Integer key : this.orderDetails.keySet()) {
      if (this.delivered.get(key) != this.orderDetails.get(key)) {
        done = false;
      }
    }

    if (done) {
      this.setTurnCompleted(currentTurn);
    }
  }

  public int getId() {
    return id;
  }

  public int getXCoord() {
    return xCoord;
  }

  public int getYCoord() {
    return yCoord;
  }

  public int[] getItemIndex() {
    return itemIndex;
  }

  public int getNumItems() {
    return numItems;
  }

  public void setNumItems(int numItems) {
    this.numItems = numItems;
  }

  public void setItemIndex(int[] itemIndex) {
    this.itemIndex = itemIndex;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Order [orderDetails=" + orderDetails + ", delivered=" + delivered + ", id=" + id
        + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", numItems=" + numItems + ", itemIndex="
        + Arrays.toString(itemIndex) + "]";
  }

  public int getTurnCompleted() {
    return turnCompleted;
  }

  public void setTurnCompleted(int turnCompleted) {
    this.turnCompleted = turnCompleted;
  }

}
