package tree;
import java.util.*;
public class binary_tree {
	 static class Node
	{
		int info;
		Node left;
		Node right;
		Node(int data)
		{
			info=data;
			left=null;
			right=null;
		}
	}
	static Node root;
	 static Node temp=root;
	static void inorder(Node root)
	{
		Node ptr=root;
		if(ptr!=null)
		{
			inorder(ptr.left);
			System.out.println(ptr.info);
			inorder(ptr.right);
		}
	}
	static void insert(Node temp ,int data)
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(temp);
		
		while(!q.isEmpty())
		{
			 temp=q.poll();
			
			
			if(temp.left==null)
			{
				temp.left=new Node(data);
				break;
			}
			else
				q.add(temp.left);
			if(temp.right==null)
			{
				temp.right=new Node(data);
				break;
			}
			else
			{
				q.add(temp.right);
			}
			
		}
	}
	public static void main(String args [])
	{
		
	    root=new Node(10);
		root.left = new Node(11); 
	        root.left.left = new Node(7); 
	        root.right = new Node(9); 
	        root.right.left = new Node(15); 
	        root.right.right = new Node(8); 
	    inorder(root);
	    int key=12;
	    insert(root,key);
	    System.out.println("After Insertion");
	    inorder(root);
		
		
	}
}
