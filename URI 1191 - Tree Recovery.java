// Problem 1191

import java.util.*;

class BinaryTree {
	
	class TreeNode	{
	char data;
	TreeNode left;
	TreeNode right;	
	
	public TreeNode(char data)
	{
		
		this.data = data;
		left = null;
		right = null;
	}
}

private TreeNode root=null;

 
public TreeNode construct(char[] preorder, int preStart, int preEnd, char[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
        return null;
    }
 
    char val = preorder[preStart];
	         
	TreeNode p = new TreeNode(val);
        if (root == null)
			 {
				 root = p;
			 }
			 
    //find parent element index from inorder
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(val == inorder[i]){
            k=i;
            break;
        }
    }
 
    p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
    p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
    return p;
}
public void worktogether(char[] preorder, char[] inorder)
{
	 int preStart = 0;
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;
 
	construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	postorder(root);
	
}
public void postorder(TreeNode t)
{  if(t != null)
	{
		postorder(t.left);
    postorder(t.right);
    System.out.print(t.data);

	}
}
}
public class Main
{
	public static void main(String[] arg)
	{  Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
		String s=sc.next();
  	  String s1=sc.next();
	  char r[]=s.toCharArray();
	   char r1[]=s1.toCharArray();
		BinaryTree o=new BinaryTree();
		o.worktogether(r,r1);
		System.out.println();
	    }
	}
	
}