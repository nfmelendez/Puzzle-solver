package ar.com.melendez.puzzle;

import java.util.List;

import ar.com.melendez.puzzle.impl.PuzzleImpl;
import ar.com.melendez.puzzle.impl.Solver;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		Puzzle p = new PuzzleImpl();
		Solver solver = new Solver();
		List<WordSolutions> solutions = solver.solve(p);

		for (WordSolutions wordSolutions : solutions) {
			String word = wordSolutions.getWord();
			System.out.println("Solutions for: " + word);
			for (NodeImpl node : wordSolutions.getSolutions()) {
				printSolutions(node, word);
			}

		}

	}

	private static void printSolutions(NodeImpl node, String word) {
		List<NodeImpl> child = node.getChild();
		if (child.isEmpty()) {
			if (node.getWord().equals(word)) {
				System.out.println("Solution: " + node.getPath());
			}
		} else {
			for (NodeImpl nodeChild : child) {
				printSolutions(nodeChild, word);
			}
		}

	}
}
