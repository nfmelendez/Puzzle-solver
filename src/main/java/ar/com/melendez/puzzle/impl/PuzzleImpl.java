package ar.com.melendez.puzzle.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ar.com.melendez.puzzle.NodeImpl;
import ar.com.melendez.puzzle.Puzzle;
import ar.com.melendez.puzzle.WordSolutions;

public class PuzzleImpl implements Puzzle {

	private char[][] matrix = { { 'x', 'b', 'e', 's' }, { 't', 'o', 'r', 'f' },
			{ 't', 'a', 'n', 'x' }, { 'c', 't', 'o', 'm' },
			{ 'b', 's', 'w', 'g' } };

	// private char[][] matrix = {
	// { 'x', 'b', 'e', },
	// { 't', 'o', 'r' },
	// { 't', 'a', 'n'} };

	private String[] words = { "boat", "tan", "won" };

	public PuzzleImpl(char[][] matrix, String[] words) {
		this.matrix = matrix;
		this.words = words;

	}

	public PuzzleImpl() {
	}

	@Override
	public int getRows() {
		return matrix.length;
	}

	@Override
	public int getColumns() {
		return this.matrix[0].length;
	}

	@Override
	public char getLetter(int row, int col) {
		return this.matrix[row][col];
	}

	@Override
	public String[] getWords() {
		return this.words;
	}

	public List<WordSolutions> solve() {
		ArrayList<WordSolutions> solutions = new ArrayList<WordSolutions>();
		for (int i = 0; i < words.length; i++) {
			searchSolutionsForWord(solutions, words[0]);
		}
		return solutions;
	}

	public void searchSolutionsForWord(ArrayList<WordSolutions> solutions,
			String boat) {
		WordSolutions wordSolutions = new WordSolutions(boat);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				char c = matrix[i][j];
				if (c == boat.charAt(0)) {
					NodeImpl n = new NodeImpl(c, i, j);
					NodeImpl root = createTree(n, i, j, boat.substring(1));
					wordSolutions.addSolution(root);
				}
			}
		}
		solutions.add(wordSolutions);
	}

	public static void main(String[] args) {
		new PuzzleImpl().solve();
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
			char letter = matrix[row][col];
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
