package com.problems.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	
	Node root;
	private static int currentIndex = 0;
	private static int tempVal = 0;
	
	public void insert(int a) {
		if(root == null) {
			root = new Node(a, null, null);
		} else {
			Node newNode = new Node(a, null, null);
			insert(newNode, root);
		}
	}
	
	private void insert(Node newNode, Node parent) {
		if(newNode.value < parent.value) {
			if(parent.lTree != null) {
				insert(newNode, parent.lTree);
			} else {
				parent.lTree = newNode;
			}
		} else {
			if(parent.rTree != null) {
				insert(newNode, parent.rTree);
			} else {
				parent.rTree = newNode;
			}
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void inorder() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
		} else {
			inorder(root);
		}
	}

	private void inorder(Node root2) {
		if(root2 != null) {
			inorder(root2.lTree);
			System.out.print(root2.value + "\t");
			inorder(root2.rTree);
		}
	}
	
	public void inorderWithoutRecursive() {
		Node temp = root;
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty() || temp != null) {
			if (temp != null) {
				s.push(temp);
				temp = temp.lTree;
			} else {
				Node t = s.pop();
				System.out.print(t.value + "\t");
				temp = t.rTree;
			}
		}
	}
	
	public void preorder() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
		} else {
			preorder(root);
		}
	}

	private void preorder(Node root2) {
		if(root2 != null) {
			System.out.print(root2.value + "\t");
			preorder(root2.lTree);
			preorder(root2.rTree);
		}
	}
	
	public void preorderWithoutRecursive() {
		Node temp = root;
		Stack<Node> s = new Stack<Node>();
		while(temp != null || !s.isEmpty()) {
			if(temp != null) {
				System.out.print(temp.value + "\t");
				s.push(temp);
				temp = temp.lTree;
			} else {
				Node t = s.pop();
				temp = t.rTree;
			}
		}
	}
	
	public void postorder() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
		} else {
			postorder(root);
		}
	}

	private void postorder(Node root2) {
		if(root2 != null) {
			postorder(root2.lTree);
			postorder(root2.rTree);
			System.out.print(root2.value + "\t");
		}
	}
	
	public void levelOrderTraversal() {
		Queue<Node> queue = new LinkedList<Node>();
		if(root != null) {
			queue.add(root);
		}
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.value + "\t");
			if(n.lTree != null) {
				queue.offer(n.lTree);
			}
			if(n.rTree != null) {
				queue.offer(n.rTree);
			}
		}
	}
	
	public void postorderWithoutRecursive() {
		if(root == null) {
			return;
		}
		Node prev = null;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			Node current = s.peek();
			if(prev == null || prev.lTree == current || prev.rTree == current) {
				if(current.lTree != null) {
					s.push(current.lTree);
				} else if(current.rTree != null) {
					s.push(current.rTree);
				} else {
					Node t = s.pop();
					System.out.print(t.value + "\t");
				}
			} else if(current.lTree == prev) {
				if(current.rTree != null) {
					s.push(current.rTree);
				} else {
					Node t = s.pop();
					System.out.print(t.value + "\t");
				}
			} else if(current.rTree == prev) {
				Node t = s.pop();
				System.out.print(t.value + "\t");
			}
			prev = current;
		}
	}
	
	public void postOrderTwoStack() {
		if(root == null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node t = s1.pop();
			s2.push(t);
			if(t.lTree != null) {
				s1.push(t.lTree);
			}
			if(t.rTree != null) {
				s1.push(t.rTree);
			}
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().value + "\t");
		}
	}
	
	public boolean search(int a) {
		if(isEmpty()) {
			System.out.println("Empty tree");
			return false;
		} else {
			return search(a, root);
		}
	}

	private boolean search(int a, Node root2) {
		boolean found = false;
		if (root2 != null) {
			if (a == root2.value) {
				found = true;
				return found;
			} else if (a < root2.value) {
				return search(a, root2.lTree);
			} else {
				return search(a, root2.rTree);
			} 
		}
		return found;
	}
	
	public boolean delete(int a) {
		if(root == null) {
			System.out.println("Empty tree");
			return false;
		} else {
			Node current = root;
			Node currentParent = root;
			boolean isLeftChild = false;
			if(!search(a)) {
				return false;
			}
			while(current.value != a) {
				currentParent = current;
				if(a < current.value) {
					isLeftChild = true;
					current = current.lTree;
				} else {
					isLeftChild = false;
					current = current.rTree;
				}
			}
			if(current.lTree == null && current.rTree == null) {
				if(current == root) {
					root = null;
				} else if(isLeftChild) {
					currentParent.lTree = null;
				} else {
					currentParent.rTree = null;
				}
			} else if(current.lTree == null) {
				if(current == root) {
					root = current.rTree;
				} else if(isLeftChild) {
					currentParent.lTree = current.rTree;
				} else {
					currentParent.rTree = current.rTree;
				}
			} else if(current.rTree == null) {
				if(current == root) {
					root = current.lTree;
				} else if(isLeftChild) {
					currentParent.lTree = current.lTree;
				} else {
					currentParent.rTree = current.lTree;
				}
			} else if(current.lTree != null && current.rTree != null) {
				Node successor = getSuccessorNode(current);
				if(current == root) {
					root = successor;
				} else if(isLeftChild) {
					currentParent.lTree = successor;
				} else {
					currentParent.rTree = successor;
				}
				successor.lTree = current.lTree;
			}
			return true;
		}
	}

	private Node getSuccessorNode(Node deleteNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.rTree;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.lTree;
		}
		if(successor !=deleteNode.rTree) {
			successorParent.lTree = successor.rTree;
			successor.rTree = deleteNode.rTree;
		}
		return successor;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return size(root);
		}
	}

	private int size(Node root2) {
		if(root2 == null) {
			return 0;
		} else {
			return 1 + size(root2.lTree) + size(root2.rTree);
		}
		
	}
	
	public int getNthLargestElement(int n) {
		int val = 0;
		if (n > 0 && n <= size()) {
			val = getNthLargestElement(root, n);
			currentIndex = 0;
			tempVal = 0;
		}
		return val;
	}
	
	private int getNthLargestElement(Node root2, int n) {
		if(root2 != null && currentIndex < n) {
			getNthLargestElement(root2.rTree, n);
			if(++currentIndex == n) {
				System.out.println("value is:" + root2.value);
				tempVal = root2.value;
				//return;
			}
			getNthLargestElement(root2.lTree, n);
		} 
		return tempVal;
	}
	
	public int getNthSmallestElement(int n) {
		int val = 0;
		if(n > 0 && n <= size()) {
			val = getNthSmallestElement(root, n);
			currentIndex = 0;
			tempVal = 0;
		}
		return val;
	}

	private int getNthSmallestElement(Node root2, int n) {
		if(root2 != null && currentIndex < n) {
			getNthSmallestElement(root2.lTree, n);
			if(++currentIndex == n) {
				tempVal = root2.value;
			}
			getNthSmallestElement(root2.rTree, n);
		}
		return tempVal;
	}
	
	private int getNthSmallestElementByAugmentedTree(int n) {
		int val = 0;
		if(n > 0 && n <= size()) {
			val = getNthSmallestElementByAugmentedTree(root, n);
			currentIndex = 0;
			tempVal = 0;
		}
		return val;
	}

	private int getNthSmallestElementByAugmentedTree(Node root2, int n) {
		int lTreeSize = 0;
		if (root2 != null) {
			lTreeSize = size(root2.lTree);
		}
		if(lTreeSize + 1 == n) {
			return root2.value;
		} else if(lTreeSize >= n) {
			return getNthSmallestElementByAugmentedTree(root2.lTree, n);
		} else {
			return getNthSmallestElementByAugmentedTree(root2.rTree, n - lTreeSize - 1);
		}
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	public int getHeight(Node root2) {
		if(root2 == null) {
			return 0;
		} else {
			int lTreeHeight = getHeight(root2.lTree);
			int rTreeHeight = getHeight(root2.rTree);
			if(lTreeHeight > rTreeHeight) {
				return (1 + lTreeHeight);
			} else {
				return (1 + rTreeHeight);
			}
		}
	}
	
	public void printElementsByLevel() {
		int height = getHeight();
		if (height > 0) {
			for (int i = 1; i <= height; i++) {
				printElementByLevel(root, i);
			} 
		}
	}

	private void printElementByLevel(Node root2, int level) {
		if(root2 == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root2.value + "\t");
		} else {
			printElementByLevel(root2.lTree, level - 1);
			printElementByLevel(root2.rTree, level - 1);
		}
		
	}

	private class Node {
		int value;
		Node lTree;
		Node rTree;
		public Node(int value, Node lTree, Node rTree) {
			super();
			this.value = value;
			this.lTree = lTree;
			this.rTree = rTree;
		}
		
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(4);
		bst.insert(5);
		bst.insert(2);
		bst.insert(9);
		bst.insert(6);
		bst.insert(3);
		bst.insert(1);
		bst.inorder();
		System.out.println();
		System.out.println("Size is: " + bst.size());
		//bst.postorder();
		System.out.println(bst.search(2));
		/*bst.delete(2);
		bst.inorderWithoutRecursive();
		System.out.println();
		System.out.println("Size is: " + bst.size());
		
		System.out.println(bst.getNthLargestElement(6));
		System.out.println(bst.getNthSmallestElement(5));*/
		//bst.postorder();
		System.out.println(bst.getNthSmallestElementByAugmentedTree(8));
		bst.printElementsByLevel();
		System.out.println();
		bst.levelOrderTraversal();
		//bst.postOrderTwoStack();
	}

}
