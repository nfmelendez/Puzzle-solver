package ar.com.melendez.puzzle;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl {

	char value;
	String word = "";
	private String path = "";
	List<NodeImpl> childs = new ArrayList<NodeImpl>();
	NodeImpl father = null;
	private int row;
	private int col;

	public NodeImpl(char theValue, int theRow, int theCol) {
		value = theValue;
		word += theValue;
		this.row = theRow;
		this.col = theCol;
		this.path = " -> " + "[" + this.col +"," + this.row+ "]";
	}

	public NodeImpl(char theValue, NodeImpl theFather, int row, int col) {
		this(theValue, row, col);
		this.father = theFather;
		this.word = theFather.getWord() + theValue;
		this.path = theFather.getPath() + " -> " + "[" + this.col +"," + this.row+ "]";
	}

	public String getWord() {
		return word;
	}


	public boolean addChild(NodeImpl c) {
		if (!isFather(this.father, c)) {
			childs.add(c);
			return true;
		} else {
			return false;
		}
	}

	private boolean isFather(NodeImpl aFather, NodeImpl c) {
		if (null == aFather) {
			return false;
		}
		if (aFather.getRow() == c.getRow() && aFather.getCol() == c.getCol()) {
			return true;
		} else {
			return isFather(aFather.getFather(), c);
		}

	}

	public NodeImpl getFather() {
		return this.father;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	@Override
	public String toString() {
		return this.word ;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
