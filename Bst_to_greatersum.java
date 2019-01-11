import java.util.*;

public class Bst_to_greatersum {
	int sum=0;
	class Node
	{
		int info;
		Node right,left;
		Node(int data)
		{
			info=data;
			left=right=null;
		}
	}
	static Node root=null;
	public void insert(int data)
	{
		root=createbst(root,data);
	}
	public Node createbst(Node root,int data)
	{
		if(root==null)
		{
			root=new Node(data);
			return root;
		}
		else if(root.info>data)
			root.left=createbst(root.left,data);
		else if(root.info<data)
			root.right=createbst(root.right,data);
		return root;
	}
	public void findsum(Node root)
	{
		if(root!=null)
		{
			
			sum+=root.info;
			findsum(root.left);
			findsum(root.right);
			
		}
		
	}
	public void greatersum()
	{
		Stack<Node> stack=new Stack<Node>();
		Node current=root;
		while(current!=null || stack.size()>0)
		{
			while(current!=null)
			{
				stack.push(current);
				current=current.left;
			}
			current=stack.pop();
			sum=sum-current.info;
			System.out.println(sum);
			current=current.right;
		}
		
	}

	public static void main(String args[])
	{
		Bst_to_greatersum obj=new Bst_to_greatersum();
		obj.insert(11);
		obj.insert(2);
		obj.insert(29);
		obj.insert(1);
		obj.insert(7);
		obj.insert(15);
		obj.insert(40);
		obj.insert(35);
		obj.findsum(root);
		obj.greatersum();
		
		
	}
}
