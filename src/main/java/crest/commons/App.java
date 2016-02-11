package crest.commons;

import crest.commons.util.FileIOUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Game problem = FileIOUtil.readProblemFile("example.in");
		System.out.println(problem);
	}
}
