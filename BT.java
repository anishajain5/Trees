package trees;

import java.util.Scanner;

public class BT {
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data= data;
			this.left= left;
			this.right= right;
		}
		}
	Node root;
	int size=0;
	BT(){
		Scanner s= new Scanner(System.in);
		this.root= this.takeInput(s, null, false);
	}
	
	private Node takeInput(Scanner s, Node parent, boolean lOrR) {
		if(parent==null) {
			System.out.println("Enter data for root node");
		}
		else {
			if(lOrR) {
				System.out.println("Enter data for left child of"+ parent.data);
			}
			else {
				System.out.println("Enter data for right child of"+ parent.data);
			}
		}
			int data= s.nextInt();
			Node node= new Node(data, null, null);
			this.size++;
			
			boolean choice= false;
			
			System.out.println("Do you have left child for"+ node.data);
			choice= s.nextBoolean();
			
			if(choice) {
				node.left= takeInput(s, node, true);
			}
			System.out.println("Do you have right child");
			choice= s.nextBoolean();
			if(choice) {
				node.right= this.takeInput(s, node, false);
			}
		return node;
	}
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		if(node.left!=null) {
			System.out.print(node.left.data+" => ");
		}
		else {
			System.out.print("End => ");
		}
		System.out.print(node.data);
		if(node.right!=null) {
			System.out.print(" <= "+ node.right.data);
		}
		else {
			System.out.print(" <= END");
		}
		System.out.println();
		
		if(node.left!= null) {
			this.display(node.left);
		}
		if(node.right!=null) {
			this.display(node.right);
		}
	}
	

}
