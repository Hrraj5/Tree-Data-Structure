package tree;
import java.util.*;
public class bst_with_levelorder {
	class Node
	{
		int info;
		Node left,right;
		Node(int data)
		{
			info=data;
			left=right=null;
		}
	}
	Node root;
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
	public void level_order()
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node tempnode=q.poll();
			System.out.println(tempnode.info);
			if(tempnode.left!=null)
				q.add(tempnode.left);
			if(tempnode.right!=null)
				q.add(tempnode.right);
				
		}
	}
	public static void main(String args[])
	{
		bst_with_levelorder obj=new bst_with_levelorder();
		obj.insert(2);
		obj.insert(1);
		obj.insert(3);
		obj.level_order();
	}
}
