package com.problems.ds;

public class BinaryTreeAscendingPaths extends BinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeAscendingPaths tree = new BinaryTreeAscendingPaths();
        tree.root = new Node(12);
        tree.root.left = new Node(14);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(35);
        tree.root.right.right = new Node(40);
        System.out.println(tree.getAscendingPaths());
	}
	
	public int getAscendingPaths() {
		if(root == null) {
			return 0;
		} else {
			return getAscendingPaths(root);
		}
	}

	private int getAscendingPaths(Node root2) {
		if(root2.left == null && root2.right == null) {
			return 1;
		} else if(root2.left == null) {
			if(root2.right.val >= root2.val) {
				return getAscendingPaths(root2.right);
			} else {
				return 0;
			}
		} else if(root2.right == null) {
			if(root2.left.val >= root2.val) {
				return getAscendingPaths(root2.left);
			} else {
				return 0;
			}
		} else {
			int paths = 0;
			if(root2.left.val >= root2.val) {
				paths += getAscendingPaths(root2.left);
			}
			if(root2.right.val >= root2.val) {
				paths += getAscendingPaths(root2.right);
			}
			return paths;
		}
	}

}
