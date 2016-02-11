package crest.commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {

  // <ProductId, quantity>
  private Map<Integer, Integer> orderDetails = new HashMap<Integer, Integer>();
  private Map<Integer, Integer> delivered = new HashMap<Integer, Integer>();

  private final int id;
  private final int xCoord;
  private final int yCoord;
  public int numItems;
  public int[] itemIndex;

  public Order(int orderId, int x, int y) {
    id = orderId;
    xCoord = x;
    yCoord = y;
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

  public void setDelivered(Map<Integer, Integer> delivered) {
    this.delivered = delivered;
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

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Order [orderDetails=" + orderDetails + ", delivered=" + delivered + ", id=" + id + ", xCoord=" + xCoord
			+ ", yCoord=" + yCoord + ", numItems=" + numItems + ", itemIndex=" + Arrays.toString(itemIndex) + "]";
}
  
  
}
