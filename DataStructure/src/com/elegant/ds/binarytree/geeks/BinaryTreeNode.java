package com.elegant.ds.binarytree.geeks;

class BinaryTreeNode<T> {
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	T data;

	public BinaryTreeNode() {
		super();
	}

	public BinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}
}