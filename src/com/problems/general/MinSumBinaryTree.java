package com.problems.general;

public class MinSumBinaryTree {
	
	Node root;
	
	class Node {
		int val;
		Node lTree;
		Node rTree;
		
		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		MinSumBinaryTree mst = new MinSumBinaryTree();
		mst.root = mst.new Node(1);
		mst.root.lTree = mst.new Node(2);
		mst.root.rTree = mst.new Node(3);
		mst.root.lTree.lTree = mst.new Node(4);
		mst.root.lTree.rTree = mst.new Node(5);
		mst.root.rTree.lTree = mst.new Node(6);
		mst.root.rTree.rTree = mst.new Node(7);
		mst.root.lTree.lTree.lTree = mst.new Node(8);
		mst.root.lTree.lTree.rTree = mst.new Node(9);
		mst.root.lTree.rTree.lTree = mst.new Node(12);
		mst.root.rTree.rTree.lTree = mst.new Node(10);
		mst.root.lTree.lTree.rTree.lTree = mst.new Node(13);
		mst.root.lTree.lTree.rTree.rTree = mst.new Node(14);
		mst.root.rTree.rTree.lTree.rTree = mst.new Node(11);
		mst.root.lTree.lTree.rTree.rTree.lTree = mst.new Node(15);
		mst.print(mst.root);
		System.out.println();
		mst.deletePathsLessThanVal(45);
		mst.print(mst.root);
	}
	
	public void print(Node root2) {
		if(root2 != null) {
			System.out.print(root2.val + " ");
			print(root2.lTree);
			print(root2.rTree);
		}
		
	}

	private void deletePathsLessThanVal(int i) {
		if(root == null) {
			return;
		}
		deletePathsLessThanVal(root, root, i, false);
		
	}

	private void deletePathsLessThanVal(Node root2, Node parent, int i, boolean isLeftSided) {
		if(i <= 0) {
			return;
		}
		if(root2.lTree != null) {
			deletePathsLessThanVal(root2.lTree, root2, i - root2.val, true);
		}
		if(root2.rTree != null) {
			deletePathsLessThanVal(root2.rTree, root2,i - root2.val, false);
		} 
		if(root2.lTree == null && root2.rTree == null) {
			i = i - root2.val;
			if (i > 0) {
				if (isLeftSided) {
					parent.lTree = null;
				} else {
					parent.rTree = null;
				} 
			}
		}
	}

}
