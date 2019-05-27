package com.elegant.ds.binarytree.geeks;

import java.util.NoSuchElementException;
import java.util.Scanner;

class BSTNode {

	BSTNode left = null;
	BSTNode right = null;
	int data = 0;

	public BSTNode() {

	}

	public BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "BSTNode [left=" + left + ", right=" + right + ", data=" + data + "]";
	}

}

class BinarySearchTree {

	BSTNode root = null;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		BSTNode node = new BSTNode(data);
		if (root == null) {
			root = node;
			return;
		} else {

			BSTNode current = root;
			BSTNode parent = null;

			while (true) {
				parent = current;
				if (data == current.data)
					throw new NoSuchElementException(data + " already present in the tree!");
				else if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = node;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}

	public boolean delete(int data) {

		BSTNode parent = root;
		BSTNode current = root;
		boolean isLeftChild = false;

		while (current.data != data) {
			parent = current;
			if (current.data > data) {
				isLeftChild = true;
				current = current.left;
			} else if (current.data < data) {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null)
				return false;
		}

		// Case 1: if node to be deleted has no child
		if (current.left == null && current.right == null) {
			if (current == root)
				root = null;
			if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}

		// Case 2: if node to be deleted has only one child
		else if (current.right == null) {
			if (current == root)
				root = current.left;
			if (isLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;
		} else if (current.left == null) {
			if (current == root)
				root = current.right;
			if (isLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;
		}

		// Case 3: if node to be deleted has two child
		else if (current.left != null && current.right != null) {

			// now we have to found minimum element in right sub tree
			BSTNode successor = getSuccessor(current);
			if (current == root)
				root = successor;
			if (isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;

			successor.left = current.left;
		}

		return true;
	}

	private BSTNode getSuccessor(BSTNode deleteNode) {

		BSTNode successor = null;
		BSTNode successorParent = null;
		BSTNode current = deleteNode.right;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}

		if (successor != deleteNode.right) {
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;

	}

	public int nodeWithMinimumValue(BSTNode node) {
		if (node.left != null)
			return nodeWithMinimumValue(node.left);

		return node.data;
	}

	public boolean findNode(BSTNode node, int data) {
		if (node != null) {
			if (data == node.data)
				return true;
			else if (data < node.data)
				return findNode(node.left, data);
			else if (data > node.data)
				return findNode(node.right, data);
		}
		return false;
	}

	public void findPredecessorSuccessor(BSTNode node, int key) {

		if (root == null)
			throw new NoSuchElementException("Tree is Empty");

		if (node.data == key) {

			// the maximum value in left sub tree is predecessor
			if (node.left != null) {
				BSTNode temp = node.left;
				while (temp.right != null)
					temp = temp.right;
				System.out.println("Predecessor of " + key + " is " + temp.data);
			} else
				System.out.println("No Predecessor for this node");

			// the minimum value in right subtree is successor
			if (node.right != null) {
				BSTNode temp = node.right;
				while (temp.left != null)
					temp = temp.left;
				System.out.println("Successor of " + key + " is " + temp.data);
			} else
				System.out.println("No Successor for this node");

			return;
		}

		// if key is smaller then the node's key the go to left sub tree
		if (node.data > key)
			findPredecessorSuccessor(node.left, key);
		else
			findPredecessorSuccessor(node.right, key);

	}

	public int countNode(BSTNode node) {
		if (node == null)
			return 0;
		else {
			int count = 1;
			count += countNode(node.left);
			count += countNode(node.right);
			return count;
		}
	}

	public void inorder(BSTNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public void preorder(BSTNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder(BSTNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public int findLCA(BSTNode node, int firstNode, int secondNode) {
		if (node == null)
			return 0;

		// if both nodes are smaller then node then lca in the left
		if (node.data > firstNode && node.data > secondNode)
			return findLCA(node.left, firstNode, secondNode);
		// if both node are greater then node then lca in the right
		if (node.data < firstNode && node.data < secondNode)
			return findLCA(node.right, firstNode, secondNode);
		return node.data;
	}
}

public class BinarySearchTreeTest {
	public static void main(String[] l) {
		boolean yes = true;
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Welcome to binary Search Tree");
		do {
			System.out.println("\n1. Insert");
			System.out.println("2. Find Node");
			System.out.println("3. Delete Node");
			System.out.println("4. Node with minimum Value");
			System.out.println("5. Predecessor and Successor for Given Key");
			System.out.println("6. Count Nodes");
			System.out.println("7. Find Lowest Common Ancestor for the Nodes");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					tree.insert(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println("Enter the node");
					System.out.println(tree.findNode(tree.root, scanner.nextInt()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Enter node to delete");
					System.out.println(tree.delete(scanner.nextInt()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println(tree.nodeWithMinimumValue(tree.root));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Enter the key to find it's predecessor and successor");
					tree.findPredecessorSuccessor(tree.root, scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println(tree.countNode(tree.root));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {
					System.out.println("Enter First Node ");
					int firstNode = scanner.nextInt();
					System.out.println("Enter Second Node ");
					int secondNode = scanner.nextInt();
					System.out.println(tree.findLCA(tree.root, firstNode, secondNode));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}

			System.out.println("\nInorder");
			tree.inorder(tree.root);
			System.out.println("\nPreorder");
			tree.preorder(tree.root);
			System.out.println("\nPostorder");
			tree.postorder(tree.root);
		} while (yes);
		scanner.close();
	}
}

/**
 * References 5
 * http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
 * 
 * 
 * 
 */