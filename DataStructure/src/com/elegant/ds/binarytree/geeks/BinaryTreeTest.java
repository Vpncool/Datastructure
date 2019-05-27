package com.elegant.ds.binarytree.geeks;

import java.util.Scanner;

class BinaryTree<T> {

	private BinaryTreeNode<T> root = null;

	public BinaryTree() {
		root = null;
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	public BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T data) {
		if (node == null)
			node = new BinaryTreeNode<T>(data);
		else {
			if (node.right == null)
				node.right = insert(node.right, data);
			else
				node.left = insert(node.left, data);
		}
		return node;
	}

	public int countNodes() {
		return countNodes(root);
	}

	public int countNodes(BinaryTreeNode<T> node) {
		if (node == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(node.right);
			l += countNodes(node.left);
			return l;
		}
	}

	public boolean search(T data) {
		return search(root, data);
	}

	public boolean search(BinaryTreeNode<T> root, T data) {
		if (root.data == data)
			return true;
		if (root.left != null) {
			if (search(root.left, data))
				return true;
		}

		if (root.right != null) {
			if (search(root.right, data))
				return true;
		}
		return false;
	}

	public void inorder() {
		inorder(root);
	}

	public void inorder(BinaryTreeNode<T> node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	public void postorder(BinaryTreeNode<T> node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public void preorder() {
		preorder(root);
	}

	public void preorder(BinaryTreeNode<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public boolean empty() {
		return root == null;
	}
}

public class BinaryTreeTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Welcome to Binary Tree :- ");
		boolean yes = true;
		Scanner scanner = new Scanner(System.in);
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		do {
			System.out.println("\n1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Count Nodes");
			System.out.println("4. Check Empty");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter element to Insert : ");
					binaryTree.insert(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println("Enter item to search : ");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Count Nodes : " + binaryTree.countNodes());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println(binaryTree.empty());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				try {

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			default:
				break;
			}

			System.out.println("Inorder View : ");
			binaryTree.inorder();
			System.out.println("\nPostorder View : ");
			binaryTree.postorder();
			System.out.println("\nPreorder View");
			binaryTree.preorder();

		} while (yes);
	}
}
