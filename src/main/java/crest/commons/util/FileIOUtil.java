/**
 * 
 */
package crest.commons.util;

import crest.commons.Game;
import crest.commons.Order;
import crest.commons.WareHouse;

import java.io.BufferedReader;
import java.io.FileReader;

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
  public static Game readProblemFile(String path) {

    Game problem = new Game();

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(path));

      String line = null;
      int index = 0;

      while ((line = reader.readLine()) != null) {
        if (index == 0) {
          // line 1
          String[] elements = line.split(" ");
          problem.height = Integer.parseInt(elements[0]);
          problem.width = Integer.parseInt(elements[1]);
          problem.num_drones = Integer.parseInt(elements[2]);
          problem.setMaxTurns(Integer.parseInt(elements[3]));
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
            problem.wareHouses[index_warehouse] = new WareHouse(index_warehouse, warehouse_x,
                warehouse_y, problem.numTypesProducts);

            // next line
            line = reader.readLine();
            index++;
            elements = line.split(" ");
            for (int i = 0; i < problem.numTypesProducts; i++) {
              problem.wareHouses[index_warehouse].getNumItems()[i] = Integer.parseInt(elements[i]);
              problem.wareHouses[index_warehouse].setProduct(i, Integer.parseInt(elements[i]));
            }

            // next warehouse
            line = reader.readLine();
            index++;
          }
        }

        if (index == 2 * problem.numWarehouses + 4) {
          problem.numOrders = Integer.parseInt(line);
          problem.orders_array = new Order[problem.numOrders];

          for (int i = 0; i < problem.numOrders; i++) {
            // read order information
            line = reader.readLine();
            String[] elements = line.split(" ");
            System.out.println(line);
            int destination_x = Integer.parseInt(elements[0]);
            int destination_y = Integer.parseInt(elements[1]);

            line = reader.readLine();
            int numItems = Integer.parseInt(line);
            problem.orders_array[i] = new Order(i, destination_x, destination_y, numItems);
            problem.orders_array[i].setItemIndex(new int[problem.orders_array[i].getNumItems()]);

            line = reader.readLine();
            elements = line.split(" ");
            for (int y = 0; y < problem.orders_array[i].getNumItems(); y++) {
              problem.orders_array[i].getItemIndex()[y] = Integer.parseInt(elements[y]);
            }

          }

        }

        index++;
      }
      reader.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    problem.syncVar();
    return problem;

  }
}
