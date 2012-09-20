package ar.com.melendez.puzzle.impl;

import java.awt.Point;

import ar.com.melendez.puzzle.NodeImpl;
import ar.com.melendez.puzzle.Puzzle;

public class PuzzleImpl implements Puzzle {

	private char[][] matrix = { { 'x', 'b', 'e', 's' }, { 't', 'o', 'r', 'f' },
			{ 't', 'a', 'n', 'x' }, { 'c', 't', 'o', 'm' },
			{ 'b', 's', 'w', 'g' } };
	
//	private char[][] matrix = { 
//			{ 'x', 'b', 'e', }, 
//			{ 't', 'o', 'r' },
//			{ 't', 'a', 'n'} };

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

	public String[][] solve() {
		NodeImpl n = new NodeImpl('x', 0, 0);
		NodeImpl root = createTree(n, 0, 0);
		System.out.println("exit");
		return null;
	}

	public static void main(String[] args) {
		new PuzzleImpl().solve();
	}

	// x. 0,0
	private NodeImpl createTree(NodeImpl root, int row, int col) {

		createChild(root, row - 1, col - 1);
		createChild(root, row, col - 1);
		createChild(root, row + 1, col - 1);
		createChild(root, row - 1, col);
		createChild(root, row + 1, col);
		createChild(root, row - 1, col + 1);
		createChild(root, row, col + 1);
		createChild(root, row + 1, col + 1);

		return root;
	}

	private void createChild(NodeImpl root, int row, int col) {
		//this is not a best practise!
		try {
			char letter = matrix[row][col];
			NodeImpl n = new NodeImpl(letter, root, row, col);
			if (root.addChild(n)) {
				createTree(n, row, col);
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			return;
		}

	}
}
