package com.problems.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.problems.general.BinaryTreeCloning.Node;

public class BinaryTreeCloning {
	Node root;

	public static void main(String[] args) {
		BinaryTreeCloning bt = new BinaryTreeCloning();
		bt.root = bt.new Node(2);
		bt.root.left = bt.new Node(3);
		bt.root.right = bt.new Node(5);
		bt.root.left.left = bt.new Node(1);
		bt.root.random = bt.root.left.left;
		bt.root.left.random = bt.root.right;
		bt.root.right.random = bt.root;
		System.out.println(bt.createClone());
	}

	public Node createClone() {
		Map<Node, Integer> nodeRandomValue = new HashMap<Node, Integer>();
		Map<Integer, Node> createdNodeMap = new HashMap<Integer, Node>();
		Node root2 = new Node();
		iterate(root, root2, nodeRandomValue, createdNodeMap);
		return root2;
	}

	private void iterate(Node root2, Node root22, Map<Node, Integer> nodeRandomValue,
			Map<Integer, Node> createdNodeMap) {

		root22.data = root2.data;
		createdNodeMap.put(root2.data, root22);
		Iterator<Entry<Node, Integer>> mapIterator = nodeRandomValue.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Entry<Node, Integer> current = mapIterator.next();
			if (root2.data == current.getValue()) {
				current.getKey().random = root22;
				mapIterator.remove();
			}
		}
		/*for (Node parent : nodeRandomValue.keySet()) {
			if (root2.data == nodeRandomValue.get(parent)) {
				parent.random = root22;
				//nodeRandomValue.remove(parent);
			}
		}*/
		if (root2.random != null) {
			Node n = root2.random;
			if (createdNodeMap.containsKey(n.data)) {
				Node n1 = createdNodeMap.get(n.data);
				root22.random = n1;
			} else {
				nodeRandomValue.put(root22, n.data);
			}
		}
		if (root2.left != null) {
			root22.left = new Node();
			iterate(root2.left, root22.left, nodeRandomValue, createdNodeMap);
		}
		if (root2.right != null) {
			root22.right = new Node();
			iterate(root2.right, root22.right, nodeRandomValue, createdNodeMap);
		}
	}
	//double traversal
	public Node createClone1() {
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();
		Node root2 = new Node();
		traverse(root, root2, nodeMap);
		putRandom(root2, nodeMap);
		return root2;
	}

	private void putRandom(Node root2, Map<Node, Node> nodeMap) {
		if(root2 != null) {
			Node parent = nodeMap.get(root2);
			if(parent.random != null) {
				root2.random = parent.random;
			}
			putRandom(root2.left, nodeMap);
			putRandom(root2.right, nodeMap);
		}
		
	}

	private void traverse(Node root2, Node root22, Map<Node, Node> nodeMap) {
		root22.data = root2.data;
		nodeMap.put(root22, root2);
		if(root2.left != null) {
			root22.left = new Node();
			traverse(root2.left, root22.left, nodeMap);
		}
		if(root2.right != null) {
			root22.right = new Node();
			traverse(root2.right, root22.right, nodeMap);
		}
		
	}

	class Node {
		int data;
		Node left;
		Node right;
		Node random;

		Node(int data) {
			this.data = data;
		}

		Node() {

		}
	}

}
