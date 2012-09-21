package ar.com.melendez.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of solutions for a given word.
 * 
 * @author nfmelendez
 * 
 */
public class WordSolutions {

	/** collection of solutions */
	private List<NodeImpl> solutions = new ArrayList<NodeImpl>();
	/** The word that the solutions are for. */
	private String word;

	/**
	 * Constructor.
	 * 
	 * @param theWord
	 *            The word that the solutions are for. cannot be null.
	 */
	public WordSolutions(String theWord) {
		setWord(theWord);
	}

	public List<NodeImpl> getSolutions() {
		return solutions;
	}

	public void addSolution(NodeImpl solution) {
		this.solutions.add(solution);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
