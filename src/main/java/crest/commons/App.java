package crest.commons;

import java.util.ArrayList;

import crest.commons.algorithms.Greedy;
import crest.commons.solution.Command;
import crest.commons.util.FileIOUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Game problem = FileIOUtil.readProblemFile("example.in");
		System.out.println(problem);

//		ArrayList<Command> results = Greedy.greedy(problem);
//		for (Command e : results) {
//			System.out.println(e);
//		}

	}
}
