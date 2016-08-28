package com.problems.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SimpleRatInAMaze {
	
	private class Node {
		int x;
		int y;
		int distance;
		Node previous;
		
		Node(int x, int y, int distance, Node previous) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.previous = previous;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + distance;
			result = prime * result + ((previous == null) ? 0 : previous.hashCode());
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Node)) {
				return false;
			}
			Node n = (Node)obj;
			return (this.x == n.x && this.y == n.y);
		}

		private SimpleRatInAMaze getOuterType() {
			return SimpleRatInAMaze.this;
		}
		
	} 
	
	public Node findPath(int[][] maze, int m, int n, Node start, Node end) {
		Queue<Node> inProcessQueue = new LinkedList<Node>();
		//Map<Node, Node> visited = new HashMap<Node, Node>();
		Set<Node> inProcess = new HashSet<Node>();
		inProcess.add(start);
		inProcessQueue.add(start);
		Node current = null;
		while(!inProcessQueue.isEmpty()) {
			current = inProcessQueue.poll();
			if(current.equals(end)) {
				return current;
			} else {
				Set<Node> neighbors = getNeighbors(current, m, n, maze);
				for(Node node : neighbors) {
					if(!inProcess.contains(node)) {
						inProcess.add(node);
						inProcessQueue.add(node);
					}
				}
			}
		}
		return null;
	}

	private Set<Node> getNeighbors(Node current, int m, int n, int[][] maze) {
		Set<Node> validNeighbors = new HashSet<Node>();
		int currentX = current.x;
		int currentY = current.y;
		int currentDistance = current.distance;
		Node lNeighbor = new Node(currentX - 1, currentY, currentDistance + 1, current);
		Node rNeighbor = new Node(currentX + 1, currentY, currentDistance + 1, current);
		Node upNeighbor = new Node(currentX, currentY - 1, currentDistance + 1, current);
		Node downNeighbor = new Node(currentX, currentY + 1, currentDistance + 1, current);
		if(isValid(maze, m, n, lNeighbor)) {
			validNeighbors.add(lNeighbor);
		}
		if(isValid(maze, m, n, rNeighbor)) {
			validNeighbors.add(rNeighbor);
		}
		if(isValid(maze, m, n, upNeighbor)) {
			validNeighbors.add(upNeighbor);
		}
		if(isValid(maze, m, n, downNeighbor)) {
			validNeighbors.add(downNeighbor);
		}
		return validNeighbors;
	}

	private boolean isValid(int[][] maze, int m, int n, Node node) {
		if(node.x >= 0 && node.x < m && node.y >= 0 && node.y < n && maze[node.x][node.y] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
		int n = 4;
		int[][] maze = new int[m][n];
		maze[0][1] = 1;
		maze[1][1] = 1;
		maze[1][3] = 1;
		maze[2][3] = 1;
		SimpleRatInAMaze rat = new SimpleRatInAMaze();
		SimpleRatInAMaze.Node start = rat.new Node(1, 0, 0, null);
		SimpleRatInAMaze.Node end = rat.new Node(0, 3, 0, null);
		SimpleRatInAMaze.Node path = rat.findPath(maze, m, n, start, end);
		/*int count = 0;
		while(path.previous != null) {
			count++;
		}*/
		System.out.println(path.distance);
	}

}
