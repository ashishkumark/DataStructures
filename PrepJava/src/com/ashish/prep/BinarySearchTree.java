package com.ashish.prep;

public class BinarySearchTree {

	Node root;

	public void addNode (int key, String role) {
		Node newNode = new Node(key, role);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node focusNode = root;
		Node parent = null;
		while (true) {
			parent = focusNode;
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
				if (focusNode == null) {
					parent.leftChild = newNode;
					return;
				}
			} else {
				focusNode = focusNode.rightChild;
				if (focusNode == null) {
					parent.rightChild = newNode;
					return;
				}				
			}
		}
	}
	
	public void inOrderTraversal (Node focusNode) {
		
		if (focusNode == null) return;
		
		inOrderTraversal(focusNode.leftChild);
		System.out.println(focusNode);
		inOrderTraversal(focusNode.rightChild);
	}

	public void preOrderTraversal (Node focusNode) {
		
		if (focusNode == null) return;
		
		System.out.println(focusNode);
		preOrderTraversal(focusNode.leftChild);
		preOrderTraversal(focusNode.rightChild);
	}
	
	public void postOrderTraversal (Node focusNode) {
		
		if (focusNode == null) return;
		
		postOrderTraversal(focusNode.leftChild);
		postOrderTraversal(focusNode.rightChild);
		System.out.println(focusNode);
	}
	
	public Node findNode(int key) {
	
		Node focusNode = root;
		
		while (focusNode != null && focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
		}
		
		return focusNode;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(50, "Manager");
		bst.addNode(40, "Associate Manager");
		bst.addNode(30, "Secretary");
		bst.addNode(20, "Support Staff");
		bst.addNode(10, "Jr. Staff");
		bst.addNode(70, "Sr. Manager");
		bst.addNode(80, "Program Manager");
		
		bst.inOrderTraversal(bst.root);
		System.out.println("--------------------");
		bst.preOrderTraversal(bst.root);
		System.out.println("--------------------");
		bst.postOrderTraversal(bst.root);
		System.out.println("--------------------");
		Node foundNode = bst.findNode(50);
		System.out.println(foundNode != null ? foundNode.role : "Could not find node");
	}
	
}

