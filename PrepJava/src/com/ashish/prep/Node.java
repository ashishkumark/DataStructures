package com.ashish.prep;

public class Node {

	int key;
	String role;
	int level;
	
	Node leftChild;
	Node rightChild;

	public Node(int key, String role) {
		this.key = key;
		this.role = role;
	}

	public String toString() {
		return role + " has a key of " + key;
	}
}