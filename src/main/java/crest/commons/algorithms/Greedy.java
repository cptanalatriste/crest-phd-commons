/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crest.commons.algorithms;

import crest.commons.*;
import crest.commons.solution.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author J
 */
public class Greedy {
    
    public static int numOfBins(Game game, Order order, int capacity){
        int numBins=0;
        int currLoad=0;
        boolean[] flags=new boolean[order.numItems];
        for(int i=0; i<order.numItems; i++){
            flags[i]=true;
        }
        int leftProducts=order.numItems;
        while(leftProducts>0){
            numBins++;
            currLoad=0;
            for(int i=0; i<order.numItems; i++){
                int weight=game.getProductType(order.itemIndex[i]).getWeight();
                if(flags[i] && currLoad+weight<=capacity){
                    flags[i]=false;
                    currLoad+=weight;
                    leftProducts--;
                }
            }
        }
        return numBins;
    }
    
    public static ArrayList<Command> delivery(Game game, Drone drone, WareHouse wareHouse, Order order, int capacity){
        int numBins=0;
        int currLoad=0;
        boolean[] flags=new boolean[order.numItems];
        for(int i=0; i<order.numItems; i++){
            flags[i]=true;
        }
        ArrayList<Command> commands=new ArrayList<Command>();
        int leftProducts=order.numItems;
        int[] productID=new int[order.numItems];
        int[] productNum=new int[order.numItems];
        while(leftProducts>0){
            numBins++;
            for(int i=0; i<order.numItems; i++){
                productID[i]=-1;
                productNum[i]=0;
            }
            for(int i=0; i<order.numItems; i++){
                int weight=game.getProductType(order.itemIndex[i]).getWeight();
                if(flags[i] && currLoad+weight<=capacity){
                    flags[i]=false;
                    currLoad+=weight;
                    leftProducts--;
                    int productIndex=0;
                    while(productID[productIndex]>=0 && productID[productIndex]!=order.itemIndex[i]){
                        productIndex++;
                    }
                    if(productID[productIndex]<0){
                        productID[productIndex]=order.itemIndex[i];
                    }
                    productNum[productIndex]++;
                }
            }
            // load bins and send
            int productIndex=0;
            while(productID[productIndex]>=0){
                Command c=new LoadCommand(drone, wareHouse, game.getProductType(productID[productIndex]), productNum[productIndex]);
                commands.add(c);
                productIndex++;
            }
            productIndex=0;
            while(productID[productIndex]>=0){
                Command c=new DeliverCommand(drone, order, game.getProductType(productID[productIndex]), productNum[productIndex]);
                commands.add(c);
                productIndex++;
            }
        }
        return commands;
    }
    
    public static int distance(WareHouse wh, Order order){
        int x1=wh.getxCoord();
        int y1=wh.getyCoord();
        int x2=order.getXCoord();
        int y2=order.getYCoord();
        x1-=x2;
        y1-=y2;
        double d=Math.sqrt(x1*x1+y1*y1);
        return (int)Math.ceil(d);
    }
    
    public static ArrayList<Command> greedy(Game game){
        // sort orders
        int numOfOrders=game.getOrders().size();
        Order[] orders=new Order[numOfOrders];
        int[] droneTurns=new int[numOfOrders];
        int[] dronex=new int[game.num_drones];
        int[] droney=new int[game.num_drones];
        int[] droneAvailable=new int[game.num_drones];
        ArrayList<Command> commands=new ArrayList<Command>();
        int i=0;
        for(i=0; i<game.orders_array.length; i++){
        	orders[i]=game.orders_array[i];
            droneTurns[i]=(distance(game.getWareHouse(0), orders[i])*2+1)*numOfBins(game, orders[i], game.maxPlayload);
            i++;
        }
        boolean[] flags=new boolean[numOfOrders];
        for(i=0; i<numOfOrders; i++){
            flags[i]=true;
        }
        int orderLeft=numOfOrders;
        for(i=0; i<game.num_drones; i++){
            dronex[i]=game.getWareHouse(0).getxCoord();
            droney[i]=game.getWareHouse(0).getyCoord();
            droneAvailable[i]=0;
        }
        while(orderLeft>0){
            int leastIndex=-1;
            for(i=0; i<numOfOrders; i++){
                if(flags[i] && (leastIndex==-1 || droneTurns[leastIndex]>droneTurns[i])){
                    leastIndex=i;
                }
            }
            int droneID=0;
            for(i=0; i<game.num_drones; i++){
                if(droneAvailable[i]<droneAvailable[droneID]){
                    droneID=i;
                }
            }
            commands.addAll(delivery(game, game.getDrone(droneID), game.getWareHouse(0), orders[leastIndex], game.maxPlayload));
            flags[i]=false;
            orderLeft--;
        }
        return commands;
    }
}