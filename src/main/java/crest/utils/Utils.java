/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crest.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author J
 */
public class Utils {
    // read the very raw input file
    public static void readInputFromFile(String filename) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename));
        // read input files
        br.close();
    }
    
    // print solution in the format for submission, adapt arguments later
    public static void printSolution(String filename) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
        // print solution
        bw.close();
    }
}
