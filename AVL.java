import java.util.Scanner;
class Node
{
    int ele, height;
    Node left, right;
    Node(int data)
    {
        ele = data;
        height = 1;
    }
}
 public class AVL
{
	Node root;
	float count=0,sum=0;
    int height(Node N) 
    {
        if (N == null)
            return 0;
       
        return N.height;
    }
    int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }
 
    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
 
        x.right = y;
        y.left = T2;
 
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        return x;
    }
 
    Node leftRotate(Node x) 
    {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }
    
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, int ele) 
    {
    	if (node == null)
            return (new Node(ele));
 
        if (ele < node.ele)
            node.left = insert(node.left, ele);
        else if (ele > node.ele)
            node.right = insert(node.right, ele);
        else 
            return node;
  
        node.height = 1 + max(height(node.left),height(node.right));
 
        int balance = getBalance(node);
 
        if (balance > 1 && ele < node.left.ele)
            return rightRotate(node);
        
        if (balance < -1 && ele > node.right.ele)
            return leftRotate(node);
 
        
        if (balance > 1 && ele > node.left.ele) 
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        if (balance < -1 && ele < node.right.ele)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
 
    Node minValueNode(Node node)
    {
        Node current = node;
        while (current.left != null)
        current = current.left;
        return current;
    }
    
    Node deleteNode(Node root, int ele)
    {
        if (root == null)
            return root;
 
        if (ele < root.ele)
            root.left = deleteNode(root.left, ele);
 
        else if (ele > root.ele)
            root.right = deleteNode(root.right, ele);
 
        else
        {
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else 
                    root = temp; 
            }
            else
            {
            	Node temp = minValueNode(root.right);
                root.ele = temp.ele;
                root.right = deleteNode(root.right, temp.ele);
            }
        }
        if (root == null)
            return root;
        
        root.height = max(height(root.left), height(root.right)) + 1;
 
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
 
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }
    
    int maximum(Node node)
   	{
       	Node current = node;
       	 while (current.right != null)
       	        current = current.right;
       	 
       	        return current.ele;
   	}
    
    int minimum(Node node)
    {
        Node current = node;
        while (current.left != null)
        	current = current.left;
        
        return current.ele;
    }
    
    void Average(Node node)
    {
        if (node == null) 
        {
          return;
        }
        
        sum = sum + node.ele;
        count = count + 1;

        Average(node.left);
        Average(node.right);
    }
    
    Node searchNode(Node temp,int key)
    {
    	if(temp==null || temp.ele==key)
    	{
    		return temp;
    	}
    	if(temp.ele<key)
    	{
    		return searchNode(temp.right,key);
    	}
    	else
    	{
    		return searchNode(temp.left,key);
    	}
    }
    
    public static void main(String[] args)
    {
    	Scanner in =new Scanner(System.in);
        AVL tree = new AVL();
        float avg;
        int m=in.nextInt();
        in.nextLine();
        for(int i=1;i<=m;i++)
        {
        	String s=in.nextLine();
        	String[] str = s.split("\\s+");
        	int n[]=new int[str.length];
        	
        	if(str[0].startsWith("A") || str[0].startsWith("R"))
        	{
        		for(int j=1;j<str.length;j++)
            	{
            		int num=Integer.parseInt(str[j]);
            		n[j]=num;
            	}
            	
        		if(str[0].equals("A"))
            	{
            		for(int k=1;k<str.length;k++)
                	{
                		tree.root=tree.insert(tree.root,n[k]);
                	}
            	}
            	else
            	if(str[0].equals("R"))
                {
                	for(int k=1;k<str.length;k++)
                    {
                    	tree.root=tree.deleteNode(tree.root,n[k]);
                    }
                }
        	}
        	
        	else
        	{
	        	for(int k=0;k<str.length;k++)
	        	{
	        		int num=Integer.parseInt(str[k]);
            		n[k]=num;
	        		if(tree.searchNode(tree.root,n[k])!=null)
	        		{
	        			Node ser=tree.searchNode(tree.root, n[k]);
            			int ht=tree.height(ser);
            			int min=tree.minimum(ser);
            			int max=tree.maximum(ser);
            			
            			System.out.print(ht+" ");
            			System.out.print(min+" ");
            			System.out.print(max+" ");
            			tree.Average(ser);
            			avg=tree.sum/tree.count;
            			int scale = (int) Math.pow(10, 1);
            			
            			if(avg%1==0)
            				System.out.print((int)avg);
            			else
            				System.out.print((double) Math.round(avg * scale) / scale);
            			tree.sum=0;
            			tree.count=0;
	        		}
	        		else
	        		{
	        			System.out.println("-1");
	        		}
	        		System.out.println();
	        	}
        		
        	}
        	 
        }
        in.close();
     }
}







