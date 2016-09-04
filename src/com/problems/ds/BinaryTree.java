package com.problems.ds;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
 * binary tree left, right, top, bottom view. 
 * lowest common ancestor
 * */
public class BinaryTree {
	
	Node root;
	static int max_level = 0;
	
	static class Node {
		int val;
		Node left;
		Node right;
		Node(int val) {
			this.val = val;
		}
	}
	
	public void lowestCommonAncestor(int a, int b) {
		System.out.println(lowestCommonAncestor(root, a, b).val);
	}
	
	private Node lowestCommonAncestor(Node root2, int a, int b) {

		if(root2 == null) {
			return null;
		}
		if(root2.val == a || root2.val == b) {
			return root2;
		}
		Node lca = lowestCommonAncestor(root2.left, a, b);
		Node rca = lowestCommonAncestor(root2.right, a, b);
		if(lca != null && rca != null) {
			return root2;
		}
		return lca != null ? lca : rca;
	}

	public void bottomView() {
		int height = height();
		if(height == 0) {
			return;
		}
		Map<Integer, Integer> hd = new TreeMap<Integer, Integer>();
		for(int i = 0; i < height; i++) {
			levelOrderTraversalBottomView(root, i, hd, 0);
		}
		for(int key : hd.keySet()) {
			System.out.print(hd.get(key) + " ");
		}
	}
	
	private void levelOrderTraversalBottomView(Node root2, int level, Map<Integer, Integer> hd, int distance) {
		if(level == 0) {
			hd.put(distance, root2.val);
		} else {
			if(root2.left != null) {
				levelOrderTraversalBottomView(root2.left, level - 1, hd, distance - 1);
			}
			if(root2.left != null) {
				levelOrderTraversalBottomView(root2.right, level - 1, hd, distance + 1);
			}
			
		}
		
	}

	public void topView() {
		int height = height();
		if(height == 0) {
			return;
		}
		Set<Integer> hd = new HashSet<Integer>();
		for(int i = 0; i < height; i++) {
			levelOrderTraversalTopView(root, i, hd, 0);
		}
	}

	private void levelOrderTraversalTopView(Node root2, int level, Set<Integer> hd, int distance) {
		if(level == 0 && hd.add(distance)) {
			System.out.print(root2.val + " ");
		} else {
			if(root2.left != null) {
				levelOrderTraversalTopView(root2.left, level - 1, hd, distance - 1);
			}
			if(root2.left != null) {
				levelOrderTraversalTopView(root2.right, level - 1, hd, distance + 1);
			}
			
		}
		
	}

	public void leftView() {
		leftView(root, 1);
		max_level = 0;
	}

	private void leftView(Node root2, int currLevel) {
		if(root2 == null) {
			return;
		}
		if(max_level < currLevel) {
			System.out.print(root2.val + " ");
			max_level = currLevel;
		}
		leftView(root2.left, currLevel + 1);
		leftView(root2.right, currLevel + 1);
	}
	
	public void rightView() {
		rightView(root, 1);
		max_level = 0;
	}

	private void rightView(Node root2, int currLevel) {
		if(root2 == null) {
			return;
		}
		if(max_level < currLevel) {
			System.out.print(root2.val + " ");
			max_level = currLevel;
		}
		rightView(root2.right, currLevel + 1);
		rightView(root2.left, currLevel + 1);
	}

	public int height() {
		return height(root);
	}
	
	private int height(Node root2) {
		if(root2 == null) {
			return 0;
		} else {
			return 1 + Math.max(height(root2.left), height(root2.right));
		}
	}
	
	public boolean isSumProperty(Node root2) {
		if(root2 == null || root2.left == null || root2.right == null) {
			return true;
		}
		if(root2.val == (root2.left.val + root2.right.val) && isSumProperty(root2.left) && isSumProperty(root2.right)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.leftView();
        System.out.println();
        tree.rightView();
        System.out.println();
        tree.topView();
        System.out.println();
        tree.bottomView();
        System.out.println();
        tree.lowestCommonAncestor(25, 40);
	}

}
