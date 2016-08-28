package com.problems.general;

import java.util.HashMap;
import java.util.HashSet;

public class BinaryTree {
	
	Node root;
	
	HashSet<Integer> unAdded = new HashSet<Integer>();
	
	HashSet<String> added = new HashSet<String>();
	
	HashMap<String, String> childParent = new HashMap<String, String>();
	
	private class Node {
		String name;
		Node lTree;
		Node rTree;
		
		Node (String name, Node lTree, Node rTree) {
			this.name = name;
			this.lTree = lTree;
			this.rTree = rTree;
		}
	}
	
	public static void main(String[] args) {
		String[][] nodes = { { "2", "4" }, { "1", "2" }, { "3", "6" }, { "1", "3" }, { "2", "5" }, {"7", "5"} };
		BinaryTree bt = new BinaryTree();
		bt.createTree(nodes);
	}

	private void createTree(String[][] nodes) {
		if(root == null) {
			root = new Node(nodes[0][0], null, null);
			root.lTree = new Node(nodes[0][1], null, null);
			added.add(nodes[0][0]);
			added.add(nodes[0][1]);
			childParent.put(nodes[0][1], nodes[0][0]);
		}
		for(int i = 1; i < nodes.length; i++) {
			addElement(nodes, i);
		}
		if(!unAdded.isEmpty()) {
			System.out.println("Multiple roots");
		}
	}

	private void addElement(String[][] nodes, int i) {
		if(childParent.containsKey(nodes[i][1])) {
				System.out.println("Cycle in the tree");
				return;
		}
		if(!added.contains(nodes[i][0])) {
			if(added.contains(nodes[i][1])) {
				if (nodes[i][1].equals(root.name)) {
					Node temp = new Node(nodes[i][0], root, null);
					root = temp;
					added.add(nodes[i][0]);
					childParent.put(nodes[i][1], nodes[i][0]);
					for(int e : unAdded) {
						if(nodes[e][0].equals(nodes[i][1])) {
							unAdded.remove(e);
							addElement(nodes, e);
						}
					}
				} else {
					System.out.println("Cycle in the tree");
					return;
				}
			} else {
				
				unAdded.add(i);
			}
		} else {
			Node n = traverse(nodes[i][0]);
			Node n1 = new Node(nodes[i][1], null, null);
			if(n.lTree == null) {
				n.lTree = n1;
				added.add(nodes[i][1]);
				childParent.put(nodes[i][1], nodes[i][0]);
				for(int e : unAdded) {
					if(nodes[e][0].equals(nodes[i][1])) {
						unAdded.remove(e);
						addElement(nodes, e);
					}
				}
			} else if (n.rTree == null) {
				n.rTree = n1;
				added.add(nodes[i][1]);
				childParent.put(nodes[i][1], nodes[i][0]);
				for(int e : unAdded) {
					if(nodes[e][0].equals(nodes[i][1])) {
						unAdded.remove(e);
						addElement(nodes, e);
					}
				}
			}
			else {
				System.out.println("More than two children");
				return;
			}
		}
	}
	
	private Node traverse(String val) {
		return traverse(root, val);
	}

	private Node traverse(Node root2, String val) {
		Node temp = null;
		if(root2 != null) {
			if(root2.name.equals(val)) {
				return root2;
			} else {
				temp = traverse(root2.lTree, val);
				if (temp == null) {
					temp = traverse(root2.rTree, val);
				}
			}
		}
		return temp;
	}

}
