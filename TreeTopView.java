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

	public static void topView(Node root) {
        HashMap<Integer, int[]> map = new HashMap<>();
        printTopView(root, 0, 0, map);

        TreeMap<Integer, int[]> sorted = new TreeMap<>(); 
        // Copy all data from hashMap into TreeMap 
        sorted.putAll(map); 

        for (int[] data : sorted.values()) {
            System.out.print(data[0] + " ");
        }
    }

    public static void printTopView(Node root, int height, int horizontalDistance, HashMap<Integer, int[]> map){
        if(root == null)
            return;

        printTopView(root.left, height + 1, horizontalDistance - 1, map);

        if(map.containsKey(horizontalDistance)){
            int currentHeight = map.get(horizontalDistance)[1];
            if(height < currentHeight){
                map.put(horizontalDistance, new int[]{root.data, height});
            }
        }else{
            map.put(horizontalDistance, new int[]{root.data, height});
        }

        
        printTopView(root.right, height + 1, horizontalDistance + 1, map);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
