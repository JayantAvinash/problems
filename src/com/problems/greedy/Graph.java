package com.problems.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
	Edge[] edge;
	int V, E;
	static List<Edge> mstEdge;
	
	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[e];
		for(int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}
	
	private class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
		
	}
	
	class SubSet {
		int parent, rank;
	}
	
	public void mst() {
		Arrays.sort(edge);
		SubSet[] s = new SubSet[V];
		for(int i = 0; i < V; i++) {
			s[i] = new SubSet();
			s[i].parent = i;
		}
		mstEdge = new ArrayList<Edge>();
		int i = 0;
		int j = 0;
		while (j < V - 1) {
			Edge e = edge[i++];
			int src = e.src;
			int dest = e.dest;
			if (src != dest) {
				int srcRoot = findRoot(s, src);
				int destRoot = findRoot(s, dest);
				if (srcRoot != destRoot) {
					mstEdge.add(e);
					j++;
					modifyParent(srcRoot, destRoot, s);
				}

			} 
		}
	}

	private void modifyParent(int srcRoot, int destRoot, SubSet[] s) {
		/*srcRoot = findRoot(s, srcRoot);
        destRoot = findRoot(s, destRoot);*/
        
		if(s[srcRoot].rank < s[destRoot].rank) {
			s[srcRoot].parent = destRoot;
		} else if(s[srcRoot].rank > s[destRoot].rank) {
			s[destRoot].parent = srcRoot;
		} else {
			s[destRoot].parent = srcRoot;
			s[srcRoot].rank++;
		}
	}

	private int findRoot(SubSet[] s, int i) {
		if(s[i].parent != i) {
			s[i].parent = findRoot(s, s[i].parent);
		}
		return s[i].parent;
	}

	public static void main(String[] args) {

		int V = 9;  // Number of vertices in graph
        int E = 14;  // Number of edges in graph
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 4;
        
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 7;
        graph.edge[1].weight = 8;
 
        // add edge 0-3
        graph.edge[2].src = 1;
        graph.edge[2].dest = 7;
        graph.edge[2].weight = 11;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 2;
        graph.edge[3].weight = 8;
 
        // add edge 2-3
        graph.edge[4].src = 7;
        graph.edge[4].dest = 8;
        graph.edge[4].weight = 7;
        
        graph.edge[5].src = 7;
        graph.edge[5].dest = 6;
        graph.edge[5].weight = 1;
        
        graph.edge[6].src = 2;
        graph.edge[6].dest = 8;
        graph.edge[6].weight = 2;
        
        graph.edge[7].src = 2;
        graph.edge[7].dest = 5;
        graph.edge[7].weight = 4;
        
        graph.edge[8].src = 2;
        graph.edge[8].dest = 3;
        graph.edge[8].weight = 7;
        
        graph.edge[9].src = 8;
        graph.edge[9].dest = 6;
        graph.edge[9].weight = 6;
        
        graph.edge[10].src = 6;
        graph.edge[10].dest = 5;
        graph.edge[10].weight = 2;
        
        graph.edge[11].src = 3;
        graph.edge[11].dest = 5;
        graph.edge[11].weight = 14;
        
        graph.edge[12].src = 3;
        graph.edge[12].dest = 4;
        graph.edge[12].weight = 9;
        
        graph.edge[13].src = 5;
        graph.edge[13].dest = 4;
        graph.edge[13].weight = 10;
        
        
        
        graph.mst();
        for(Edge e : mstEdge) {
        	System.out.println(e.src + " " + e.dest + "-------" + e.weight);
        }
	}
	
}
