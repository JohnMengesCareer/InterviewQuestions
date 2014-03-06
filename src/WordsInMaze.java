import java.util.ArrayList;
import java.util.Random;


public class WordsInMaze {
	public WordsInMaze(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		maze = new char[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
			{
				maze[i][j] = (char) ('a' + random.nextInt(26));
			}
	}
	
	public void checkWords()
	{
		boolean[][] touched = new boolean[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				checkWords("", i, j, touched);
	}
	
	public void dump()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
				System.out.printf("%c ", maze[i][j]);
			System.out.println();
		}
	}
	
	private final int rows;
	private final int cols;
	private final char[][] maze;
	private final Random random = new Random();
	private int limit = 20;
	
	private class Cell
	{
		int i;
		int j;
		
		public Cell(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	private void checkWords(String prefix, int i, int j, boolean[][] touched)
	{
		String word = prefix + maze[i][j];
		checkWord(word);
		touched[i][j] = true;
		for (Cell cell : adjacentCells(i, j))
		{
			if (cell.i < 0 || cell.j < 0 || cell.i >= rows || cell.j >= cols
					|| touched[cell.i][cell.j])
				continue;
			checkWords(word, cell.i, cell.j, touched);
		}
		touched[i][j] = false;
	}
	
	private void checkWord(String s)
	{
		if (limit-- > 0)
			System.out.println(s);
	}
	
	private ArrayList<Cell> adjacentCells(int i, int j)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		result.add(new Cell(i-1, j-1));
		result.add(new Cell(i-1, j));
		result.add(new Cell(i-1,j+1));
		result.add(new Cell(i, j-1));
		result.add(new Cell(i, j+1));
		result.add(new Cell(i+1,j-1));
		result.add(new Cell(i+1,j));
		result.add(new Cell(i+1,j+1));
		return result;
	}

	public static void main(String[] args) {
		WordsInMaze maze = new WordsInMaze(4, 4);
		maze.dump();
		maze.checkWords();
	}

}
