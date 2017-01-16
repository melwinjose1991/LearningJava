package melwin.codinginterview.D_TreesAndGraphs_DONE;

/*
 * 
 * Chapter  4 	: Trees And Graphs
 * Question 4.1	: Minimal Tree
 *
 * Algorithm : 	Create empty complete BST for the given number of elements.
 * 				Do in-order traversal, and fill in the values from the 
 * 				original sorted array.
 * 
 */

public class MinimalTree {

	private static int n, current_index;
	private static int[] array = {1, 2, 3, 6, 7, 8};
	
	private static class Node{
		public Node left, right;
		public int value;

		Node(){
			left = right = null;
			value = -1;
		}
	}
	
	private static void createSubTree(Node node){
		if(n>0) node.left = new Node();
		else return;
		n--;
		
		if(n>0) node.right = new Node();
		else return;
		n--;
		
		createSubTree(node.left);
		createSubTree(node.right);
	}
	
	private static void inorderFill(Node node){
		if(node.left!=null) inorderFill(node.left);
		
		node.value = array[current_index++];
		
		if(node.right!=null) inorderFill(node.right);
	}

	private static void inorderTraverse(Node node){
		if(node.left!=null) inorderTraverse(node.left);
		
		System.out.print(" "+node.value+" ");
		
		if(node.right!=null) inorderTraverse(node.right);
	}
	
	public static void main(String[] args) {
		n = array.length;
		
		Node head=new Node();
		n--;
		createSubTree(head);
	
		current_index = 0;
		inorderFill(head);
		
		inorderTraverse(head);
	}

}
