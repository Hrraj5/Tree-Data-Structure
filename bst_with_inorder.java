package tree;
import java.util.*;
public class bst_with_inorder {
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
		
	}
	public Node create_bst(Node root,int data)
	{
		if(root==null)
		{
			root=new Node(data);
			return root;
		}
		else if(root.info>data)
			root.left=create_bst(root.left,data);
		else if(root.info<data)
			root.right=create_bst(root.right,data);
		return root;
	}
	public void inorder_iterative()
	{
		Stack<Node> stack=new Stack<Node>();
		Node current=root;
		//stack.push(current);
		while(current!=null || stack.size()>0)
		{
			while(current!=null)
			{
				stack.push(current);
				current=current.left;
			}
			current=stack.pop();
			System.out.println(current.info);
			current=current.right;
		}
	}
public static void main(String args[])
{
	bst_with_inorder obj=new bst_with_inorder();
	obj.insert(2);
	obj.insert(1);
	obj.insert(3);
	obj.inorder_iterative();
}
}
