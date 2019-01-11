package tree;
import java.util.*;
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
class Index
{
	int index=0;
}
class Bst_from_preorder1
{
	Index index=new Index();
	Node deserialize(int a[],Index preindex,int key,int min,int max,int size)
	{
		Node root=null;
		if(key>min &&key<max )
		{
		root=new Node(key);
		preindex.index+=1;
		if(preindex.index<size)
		{
			root.left=deserialize(a,preindex,a[preindex.index],min,key,size);
			root.right=deserialize(a,preindex,a[preindex.index],key,max,size);
			
		}
		
		}
		return root;
		
			
	}
	public Node createbst(int a[],int size)
	{
		return deserialize(a,index,a[0],Integer.MIN_VALUE,Integer.MAX_VALUE,size);
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
	public static void main(String args[])
	{
		Bst_from_preorder1 obj=new Bst_from_preorder1();
		int a[]=new int[]{10,5,1,7,40,50};
		int size=a.length;
		Node root=obj.createbst(a,size);
		obj.show(root);
	}
}
