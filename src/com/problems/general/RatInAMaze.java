package com.problems.general;

public class RatInAMaze {
	
	public static boolean getPath(int[][] maze) {
		int[][] soln = new int[maze.length][maze[0].length];
		boolean isExist =  getCompletePath(maze, 0, 0, soln);
		for(int i = 0; i < soln.length; i++) {
			for(int j = 0; j < soln[i].length; j++) {
				System.out.print(soln[i][j] + "\t");
			}
			System.out.println();
		}
		return isExist;
	}

	private static boolean getCompletePath(int[][] maze, int i, int j, int[][] soln) {
		if(i == maze.length - 1 && j == maze[0].length - 1) {
			soln[i][j] = 1;
			return true;
		} else if(isSafe(maze, i , j)) {
			soln[i][j] = 1;
			if(getCompletePath(maze, i + 1, j, soln)) {
				return true;
			} else if(getCompletePath(maze, i, j + 1, soln)) {
				return true;
			} else {
				soln[i][j] = 0;
				return false;
			}
			
			
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int i, int j) {
		return (i >=0 && j >= 0 && i < maze.length && j < maze[0].length && maze[i][j] == 1);
	}

	public static void main(String[] args) {
		int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}
	        };
		if(!getPath(maze)) {
			System.out.println("Path doesn't exist");
		}

	}

}
