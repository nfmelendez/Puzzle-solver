package ar.com.melendez.puzzle;

public interface Puzzle {

	public int getRows(); // e.g. 5

	public int getColumns(); // e.g. 4

	public char getLetter(int row, int col);

	public String[] getWords();

}
