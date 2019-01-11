package tree;
import java.util.*;
public class findmaxforkey {
	class Node
	{
		int info;
		Node left;
		Node right;
		Node(int data)
		{
			info=data;
			left=right=null;
		}
	}
	Node root=null;
	public void insert(int data)
	{
		root=create_bst(root,data);
		//return root;
	}
	public Node create_bst(Node root,int data)
	{
		if(root==null)
		{
			root=new Node(data);
		}
		else if(root.info>data)
			root.left=create_bst(root.left,data);
		else if(root.info<data)
			root.right=create_bst(root.right,data);
		return root;
	}
	public void display()
	{
		show(root);
	}
	public void find(int data)
	{
		findmax(root,data);
		//System.out.println(data);
	}
	public void show(Node root)
	{
		if(root!=null)
		{
			show(root.left);
			System.out.println(root.info);
			show(root.right);
		}
	}
	public void findmax(Node root,int data)
	{
		if(root.left!=null && root.right!=null &&root!=null)
		{
			if(root.info>data)
			{
				if( root.right.info>data && root.left.info>data)
					System.out.println(root.info); 
				else
					findmax(root.left,data);
			}
				
				
			if(root.info<data)
			{
				if( root.right.info>data || root.left.info>data)
					System.out.println(root.info); 
				else
				findmax(root.right,data);
			}
			
		}
		else
			System.out.println(root.info);
		
		
	}
public static void main(String args[])
	{
		findmaxforkey obj=new findmaxforkey();
		obj.insert(5);
		obj.insert(2);
		obj.insert(1);
		obj.insert(4);
		obj.insert(12);
		obj.insert(9);
		obj.insert(21);
		obj.insert(19);
		obj.insert(25);
		//obj.find(24);
		obj.find(3);
		//obj.display();
	}
}
