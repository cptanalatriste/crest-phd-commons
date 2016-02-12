package crest.commons;

import crest.commons.algorithms.Greedy;
import crest.commons.solution.SolutionRepresentation;
import crest.commons.util.FileIOUtil;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws IOException {
    Game problem = FileIOUtil.readProblemFile("mother_of_all_warehouses.in");
    SolutionRepresentation result = Greedy.greedy(problem);
    result.generateProgramFile(Paths.get("moaw_plus.out"));
  }
}
