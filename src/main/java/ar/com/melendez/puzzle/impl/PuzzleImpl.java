package ar.com.melendez.puzzle.impl;

import ar.com.melendez.puzzle.Puzzle;

public class PuzzleImpl implements Puzzle {

	private char[][] matrix;

	private String[] words;

	public PuzzleImpl(char[][] matrix, String[] words) {
		this.matrix = matrix;
		this.words = words;

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

}
