package crest.commons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import crest.commons.algorithms.Greedy;
import crest.commons.solution.Command;
import crest.commons.util.FileIOUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		Game problem = FileIOUtil.readProblemFile("mother_of_all_warehouses.in");
		//System.out.println(problem);

		ArrayList<Command> results = Greedy.greedy(problem);
		BufferedWriter bw=new BufferedWriter(new FileWriter("moaw.out"));
		bw.write(results.size()+"\n");
		for (Command e : results) {
			bw.write(e.asString()+"\n");
		}
		bw.close();
	}
}
