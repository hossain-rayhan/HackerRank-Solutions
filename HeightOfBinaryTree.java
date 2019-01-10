import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	// Write your code here.
        return calculateHeight(root, 0) - 1;
    }

    public static int calculateHeight(Node root, int h){
        if(root == null){
            return h;
        }

        int leftHeight = calculateHeight(root.left, h);
        int rightHeight = calculateHeight(root.right, h);

        return Math.max(leftHeight, rightHeight) + 1;
    }

	public static Node insert(Node root, int data) {
