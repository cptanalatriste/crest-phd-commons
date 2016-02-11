/**
 * 
 */
package crest.commons;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Bingo
 *
 */
public class Problem {

	public int width;
	public int height;
	public int maxTurns;
	public int maxPlayload;
	public int numTypesProducts;
	public int[] productTypes;
	public int numWarehouses;
	public WareHouse[] wareHouses;
	public int numOrders;
	public Order[] orders;

	public Drone[] drones;
	public int num_drones;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Problem [width=" + width + ", height=" + height + ", maxTurns=" + maxTurns + ", maxPlayload="
				+ maxPlayload + ", numTypesProducts=" + numTypesProducts + ",\n productTypes="
				+ Arrays.toString(productTypes) + ",\n numWarehouses=" + numWarehouses + ",\n wareHouses="
				+ Arrays.toString(wareHouses) + ", numOrders=" + numOrders + ",\n orders=" + Arrays.toString(orders)
				+ ", drones=" + Arrays.toString(drones) + ",\n num_drones=" + num_drones + "]";
	}
	
	
}
