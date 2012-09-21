package ar.com.melendez.puzzle.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.melendez.puzzle.NodeImpl;
import ar.com.melendez.puzzle.Puzzle;
import ar.com.melendez.puzzle.WordSolutions;

public class Solver {

	private Puzzle puzzle = null;

	public Solver() {
	}

	public List<WordSolutions> solve(Puzzle p) {
		this.puzzle = p;
		ArrayList<WordSolutions> solutions = new ArrayList<WordSolutions>();
		for (int i = 0; i < p.getWords().length; i++) {
			searchSolutionsForWord(solutions, p.getWords()[i]);
		}
		return solutions;
	}

	public void searchSolutionsForWord(ArrayList<WordSolutions> solutions,
			String boat) {
		WordSolutions wordSolutions = new WordSolutions(boat);
		for (int i = 0; i < this.puzzle.getRows(); i++) {
			for (int j = 0; j < this.puzzle.getColumns(); j++) {
				char c = this.puzzle.getLetter(i, j);
				if (c == boat.charAt(0)) {
					NodeImpl n = new NodeImpl(c, i, j);
					NodeImpl root = createTree(n, i, j, boat.substring(1));
					wordSolutions.addSolution(root);
				}
			}
		}
		solutions.add(wordSolutions);
	}

	// x. 0,0
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
		// this is not a best practise!
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
			return;
		}

	}

}
