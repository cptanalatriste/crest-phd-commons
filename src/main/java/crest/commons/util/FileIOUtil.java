/**
 * 
 */
package crest.commons.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import crest.commons.Order;
import crest.commons.Problem;
import crest.commons.WareHouse;

/**
 * the file I/O operation
 * 
 * @author Bingo
 * @since 2013-12-28
 * @version 1.0
 */
public class FileIOUtil {

	static int rows;
	static int columns;
	static int num_drones;
	static int num_turns;
	static int num_orders;
	static int max_playload;
	static int types_products;
	static int[] product_weight;
	static int num_warehouses;
	static int[][] warehouses_information;

	/**
	 * read the CSV file File
	 * 
	 * @param path
	 * @return
	 */
	public static Problem readProblemFile(String path) {

		Problem problem = new Problem();
		
		ArrayList<String> data = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			int index = 0;

			while ((line = reader.readLine()) != null) {
				if (index == 0) {
					// line 1
					String[] elements = line.split(" ");
					problem.height=  Integer.parseInt(elements[0]);
					problem.width =Integer.parseInt(elements[1]);
					problem.num_drones = Integer.parseInt(elements[2]);
					problem.maxTurns = Integer.parseInt(elements[3]);
					problem.maxPlayload = Integer.parseInt(elements[4]);
				}

				if (index == 1) {
					// line 2
					problem.numTypesProducts = Integer.parseInt(line);
					problem.productTypes = new int[problem.numTypesProducts];
				}

				if (index == 2) {
					// line 3
					String[] elements = line.split(" ");
					for (int i = 0; i < elements.length; i++) {
						problem.productTypes[i] = Integer.parseInt(elements[i]);
					}
				}

				if (index == 3) {
					// line 4
					problem.numWarehouses = Integer.parseInt(line);
					problem.wareHouses = new WareHouse[problem.numWarehouses];
				}
				

				if (index == 4) {
					// line 5: start read warehouse information
					for (int index_warehouse = 0; index_warehouse < problem.numWarehouses; index_warehouse++) {
						String[] elements = line.split(" ");
						int warehouse_x = Integer.parseInt(elements[0]);
						int warehouse_y = Integer.parseInt(elements[1]);
						problem.wareHouses[index_warehouse] = new WareHouse(index_warehouse,warehouse_x,warehouse_y,problem.numTypesProducts);
						
						// next line
						line = reader.readLine();
						index++;
						elements = line.split(" ");
						for (int i = 0; i < types_products; i++) {
							problem.wareHouses[index_warehouse].getNumItems()[i] =Integer.parseInt(elements[i]);
						}

						// next warehouse
						line = reader.readLine();
						index++;
					}
				}
				
				if (index == 2 * problem.numWarehouses + 4) {
					problem.numOrders = Integer.parseInt(line);
					problem.orders = new Order[problem.numOrders];

					for (int i = 0; i < problem.numOrders; i++) {
						//read order information
						line = reader.readLine();
						String[] elements = line.split(" ");
						System.out.println(line);
						int destination_x  = Integer.parseInt(elements[0]);
						int destination_y = Integer.parseInt(elements[1]);
						
						line = reader.readLine();
						int numItems = Integer.parseInt(line);
						problem.orders[i] = new Order(destination_x,destination_y,numItems);
						problem.orders[i].itemIndex = new int[problem.orders[i].numItems];
						
						line = reader.readLine();
						elements = line.split(" ");
						for(int y =0;y<problem.orders[i].numItems;y++){
							problem.orders[i].itemIndex[y] = Integer.parseInt(elements[y]);
						}
						
					}

				}
				
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return problem;

	}

	public static void main(String[] args) {
		Problem problem = readProblemFile("busy_day.in");
		System.out.println(problem);
	}
}
