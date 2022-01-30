package com.greatlearning.main;

import java.util.ArrayList;

class Node {
	int data;
	Node left, right;
	
	Node(int data) {
		this.data = data;
	}
}

public class LongestPathInTree {
	ArrayList<Integer> findLongestPath(Node root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> leftPath = findLongestPath(root.left);
		ArrayList<Integer> rightPath = findLongestPath(root.right);
		
		if (leftPath.size() >= rightPath.size()) {
			leftPath.add(root.data);
		} else {
			rightPath.add(root.data);
		}
		
		return leftPath.size() >= rightPath.size() ? leftPath : rightPath;
	}
	
	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(20);
		root.right = new Node(130);
		root.left.left = new Node(10);
		root.left.right = new Node(50);
		root.right.left = new Node(110);
		root.right.right = new Node(140);
		root.left.left.left = new Node(5);
		
		LongestPathInTree longestPath = new LongestPathInTree();
		ArrayList<Integer> result = longestPath.findLongestPath(root);
		
		System.out.print("Longest path in tree => ");
		
		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(result.get(i) + "\t");
		}
	}
}