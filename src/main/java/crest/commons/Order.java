package crest.commons;

import java.util.Arrays;

public class Order {
	public int destination_x;
	public int destination_y;
	public int numItems;
	public int[] itemIndex;
	
	public Order(int destination_x, int destination_y,int numItems){
		this.destination_x = destination_x;
		this.destination_y = destination_y;
		this.numItems = numItems;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [destination_x=" + destination_x + ", destination_y=" + destination_y + ", numItems=" + numItems
				+ ", itemIndex=" + Arrays.toString(itemIndex) + "]";
	}
	
	
}
