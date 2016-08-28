package com.problems.graph;

import java.awt.event.AdjustmentListener;
import java.util.LinkedList;

public class Graph {
	
	static LinkedList<Integer>[] adjList;
	
	Graph(int v) {
		adjList = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int dest) {
		adjList[v].add(dest);
		adjList[dest].add(v);
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
       // g.getBFS(2, 4);
        if(isCyclic(4)) {
        	System.out.println("cycle");
        } else {
        	System.out.println("no cycle");
        }
	}

	private static boolean isCyclic(int v) {
		boolean[] visited = new boolean[v];
		for(int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (isCyclic(i, visited, -1)) {
					return true;
				} 
			}
		}
		return false;
	}

	private static boolean isCyclic(int i, boolean[] visited, int parent) {
		visited[i] = true;
		LinkedList<Integer> l = adjList[i];
		for(int x : l) {
			if(!visited[x]) {
				if(isCyclic(x, visited, i)) {
					return true;
				}
			} else if (parent != x) {
				return true;
			}
		}
		return false;
	}

	private void getBFS(int i, int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[v];
		queue.offer(i);
		visited[i] = true;
		System.out.print(i + "\t");
		while(!queue.isEmpty()) {
			int a = queue.poll();
			LinkedList<Integer> m = adjList[a];
			for(int x : m) {
				if (!visited[x]) {
					System.out.print(x + "\t");
					queue.offer(x);
					visited[x] = true;
				}
			}
		}
	}

}
