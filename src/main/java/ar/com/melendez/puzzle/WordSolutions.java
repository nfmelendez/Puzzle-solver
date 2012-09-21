package ar.com.melendez.puzzle;

import java.util.ArrayList;
import java.util.List;

public class WordSolutions {

	private List<NodeImpl> solutions = new ArrayList<NodeImpl>();
	private String word;

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
