import java.util.ArrayList;
import java.util.Random;


public class PathThroughMaze {
	public PathThroughMaze()
	{
		dim1 = random.nextInt(10)+1;
		dim2 = random.nextInt(10)+1;
		maze = new char[dim1][dim2];
		for (int i = 0; i < dim1; i++)
			for (int j = 0; j < dim2; j++)
				maze[i][j] = (char) ('a' + random.nextInt(26));
	}
	
	public void dump()
	{
		for (int i = 0; i < dim1; i++)
		{
			for (int j = 0; j < dim2; j++)
				System.out.printf("%c",  maze[i][j]);
			System.out.println();
		}
	}
	
	public String getPath()
	{
		boolean[][] touched = new boolean[dim1][dim2];
		ArrayList<Cell> path = new ArrayList<>();
		int pathLength = random.nextInt(dim1+dim2-1);
		System.out.println(pathLength);
		int limit = 5;
		int i = 0;
		int j = 0;
		while (path.size() < pathLength)
		{
//			if (limit-- == 0) break;
			boolean found = false;
			if (path.size() == 0)
			{
				i = random.nextInt(dim1);
				j = random.nextInt(dim2);
				found = true;
			}
			else
			{
				int direction = random.nextInt(4);
				for (int k = 0; k < 4; k++)
				{
//					System.out.printf("direction %d\n", direction);
					switch (direction)
					{
					case 0: /* up */
						if (i > 0 && !touched[i-1][j])
						{
							i--;
							found = true;
						}
						break;
					case 1: /* right */
						if (j < dim2-1 && !touched[i][j+1])
						{
							j++;
							found = true;
						}
						break;
					case 2: /* down */
						if (i < dim1-1 && !touched[i+1][j])
						{
							i++;
							found = true;
						}
						break;
					case 3: /* left */
						if (j > 0 && !touched[i][j-1])
						{
							j--;
							found = true;
						}
						break;
					}
					if (found) break;
					direction = (direction + 1) % 4;
				}
			}
			if (!found)
			{
				touched[i][j] = false;
				Cell cell = path.get(path.size()-1);
//				maze[cell.i][cell.j] = (char) ('a' + maze[cell.i][cell.j]-'A');
//				System.out.printf("removed %d %d %c\n", cell.i, cell.j, maze[cell.i][cell.j]);
				path.remove(path.size()-1);
				continue;
			}
			touched[i][j] = true;
			path.add(new Cell(i, j));
//			maze[i][j] = (char) ('A' + maze[i][j]-'a');
//			System.out.printf("added %d %d %c\n", i, j, maze[i][j]);
		}
		StringBuilder result = new StringBuilder();
		for (int l = 0; l < path.size(); l++)
		{
			Cell cell = path.get(l);
			result.append(maze[cell.i][cell.j]);
		}
		return result.toString();
	}
	
	public boolean pathExists(String s)
	{
		char[] path = s.toCharArray();
		for (int i = 0; i < dim1; i++)
			for (int j = 0; j < dim2; j++)
				if (pathExists(path, 0, i, j)) return true;
		return false;
	}
	
	private final Random random = new Random();
	private final char[][] maze;
	private final int dim1;
	private final int dim2;
	
	private class Cell
	{
		public int i;
		public int j;
	
		public Cell(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	private boolean pathExists(char[] path, int start, int i, int j)
	{
		return 
				start == path.length
				|| (maze[i][j] == path[start]
						&& (i > 0 && pathExists(path, start+1, i-1, j)
								|| j < dim2-1 && pathExists(path, start+1, i, j+1)
								|| i < dim1-1 && pathExists(path, start+1, i+1, j)
								|| j > 0 && pathExists(path, start+1, i, j-1)));
	}

	public static void main(String[] args) {
		PathThroughMaze maze = new PathThroughMaze();
		String path = maze.getPath();
		System.out.printf("%s\n", path);
		System.out.println();
		maze.dump();
		System.out.println(maze.pathExists(path + "a"));
	}

}
