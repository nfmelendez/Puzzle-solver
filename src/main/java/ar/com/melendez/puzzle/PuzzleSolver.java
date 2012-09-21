package ar.com.melendez.puzzle;

import java.util.List;

import ar.com.melendez.puzzle.impl.PuzzleImpl;

/**
 * Small application that resolves puzzle
 * 
 */
public class PuzzleSolver {

	/** Puzzle sample. */
	private static char[][] matrix = { { 'x', 'b', 'e', 's' }, { 't', 'o', 'r', 'f' },
			{ 't', 'a', 'n', 'x' }, { 'c', 't', 'o', 'm' },
			{ 'b', 's', 'w', 'g' } };

	/** words that are inside the puzzle. */
	private static String[] words = { "boat", "tan", "won" };

	public static void main(String[] args) {
		Puzzle p = new PuzzleImpl(matrix, words);
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

	/**
	 * Print the solution tree.
	 * 
	 * @param node
	 *            The node with the solution, if it has no child it is a leave.
	 *            Cannot be null.
	 * @param word
	 *            The word that we are looking for solutions. Cannot be null.
	 */
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
