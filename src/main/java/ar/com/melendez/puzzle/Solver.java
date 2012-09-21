package ar.com.melendez.puzzle;

import java.util.ArrayList;
import java.util.List;


public class Solver {

	private Puzzle puzzle = null;

	public Solver() {
	}

	/**
	 * Solves the puzzle
	 * 
	 * @param p
	 *            a Puzzle. cannot be null.
	 * @return a list of solutions for a word.
	 */
	public List<WordSolutions> solve(Puzzle p) {
		this.puzzle = p;
		ArrayList<WordSolutions> solutions = new ArrayList<WordSolutions>();
		for (int i = 0; i < p.getWords().length; i++) {
			searchSolutionsForWord(solutions, p.getWords()[i]);
		}
		return solutions;
	}

	/**
	 * Search a solution for a word. First find the first letter inside the
	 * matrix for a given word and then create a tree of solutions.
	 * 
	 * @param solutions list to save solutions, cannot be null.
	 * @param word Look solutions for this word. cannot be null.
	 */
	public void searchSolutionsForWord(ArrayList<WordSolutions> solutions,
			String word) {
		WordSolutions wordSolutions = new WordSolutions(word);
		for (int i = 0; i < this.puzzle.getRows(); i++) {
			for (int j = 0; j < this.puzzle.getColumns(); j++) {
				char c = this.puzzle.getLetter(i, j);
				if (c == word.charAt(0)) {
					NodeImpl n = new NodeImpl(c, i, j);
					NodeImpl root = createTree(n, i, j, word.substring(1));
					wordSolutions.addSolution(root);
				}
			}
		}
		solutions.add(wordSolutions);
	}

	/**
	 * Creates a tree for neighbors
	 */
	private NodeImpl createTree(NodeImpl root, int row, int col, String search) {

		createChild(root, row - 1, col - 1, search);
		createChild(root, row, col - 1, search);
		createChild(root, row + 1, col - 1, search);
		createChild(root, row - 1, col, search);
		createChild(root, row + 1, col, search);
		createChild(root, row - 1, col + 1, search);
		createChild(root, row, col + 1, search);
		createChild(root, row + 1, col + 1, search);

		return root;
	}

	private void createChild(NodeImpl root, int row, int col, String search) {
		try {
			char letter = puzzle.getLetter(row, col);
			if (search.length() == 0 || search.charAt(0) != letter) {
				return;
			}
			NodeImpl n = new NodeImpl(letter, root, row, col);
			if (root.addChild(n)) {
				createTree(n, row, col, search.substring(1));
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			// Fail silent, this is not a best practise!
			return;
		}

	}

}
