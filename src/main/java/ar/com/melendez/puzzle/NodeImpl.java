package ar.com.melendez.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * This a solution node, very useful to represent logical path to the word
 * inside the puzzle.
 * 
 * @author nfmelendez
 * 
 */
public class NodeImpl {

	private char value;
	private String word = "";
	private String path = "";
	private List<NodeImpl> childs = new ArrayList<NodeImpl>();
	private NodeImpl father = null;
	private int row;
	private int col;

	public NodeImpl(char theValue, int theRow, int theCol) {
		value = theValue;
		word += theValue;
		this.row = theRow;
		this.col = theCol;
		this.path = " -> " + "[" + this.row + "," + this.col + "]";
	}

	public NodeImpl(char theValue, NodeImpl theFather, int row, int col) {
		this(theValue, row, col);
		this.father = theFather;
		this.word = theFather.getWord() + theValue;
		this.path = theFather.getPath() + " -> " + "[" + this.row + ","
				+ this.col + "]";
	}

	public String getWord() {
		return word;
	}

	/**
	 * Add a child. if it is a parent don't add because it is already in the path.
	 * @param c a child. cannot be null.
	 * @return true if could add a child.
	 */
	public boolean addChild(NodeImpl c) {
		if (!isFather(this.father, c)) {
			childs.add(c);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To know if a node is parent, or grampa of a node.
	 * 
	 * @param posibleFather
	 *            posible father, gramdfather and so on.
	 * @param c
	 *            child node.
	 * @return true if aPosibleParent is a parent
	 */
	private boolean isFather(NodeImpl posibleFather, NodeImpl c) {
		if (null == posibleFather) {
			return false;
		}
		if (posibleFather.getRow() == c.getRow()
				&& posibleFather.getCol() == c.getCol()) {
			return true;
		} else {
			return isFather(posibleFather.getFather(), c);
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
		return this.word;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<NodeImpl> getChild() {
		return childs;
	}

}
