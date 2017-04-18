package com.ashish.prep;

public enum Singleton {
	INSTANCE;
	
    // instance vars, constructor
    private final BinarySearchTree bst;

    Singleton()
    {
        // Initialize the connection
        bst = new BinarySearchTree();
    }

    // Static getter
    public static Singleton getInstance()
    {
        return INSTANCE;
    }

    public BinarySearchTree getBST()
    {
        return bst;
    }
}
