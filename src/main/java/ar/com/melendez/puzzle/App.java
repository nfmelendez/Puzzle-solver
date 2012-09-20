package ar.com.melendez.puzzle;

import ar.com.melendez.puzzle.impl.PuzzleImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Puzzle p = new PuzzleImpl();
    	System.out.println("row" + p.getRows());
    	System.out.println("column" + p.getColumns());

    }
}
