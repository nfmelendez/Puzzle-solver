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

}
