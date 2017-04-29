class Node
{
	int data;
	Node left;
	Node right;
	Node parent;
	Node(int data, Node left, Node right, Node parent)
	{
		this.data=data;
		this.left=left;
		this.right=right;
		this.parent=parent;
	}
}

class BSTImplementation{

	Node root;

	public BSTImplementation() {
		root=null;
	}
	public void Create(int data) {
		// TODO Auto-generated method stub
		root = CreateNode(root,data,null);
	}
	private Node CreateNode(Node root, int data, Node parent) {
		if(root==null)
		{
			Node newNode=new Node(data, null, null, parent);
			return newNode;
		}
		else
		{
			Node temp=root;
			if(data < temp.data)
			{
				temp.left=CreateNode(temp.left,data, temp);
			}
			else
			{
				temp.right=CreateNode(temp.right,data, temp);
			}
			return temp;
		}

	}
	public void Inorder() {
		InOrderTraversal(root);

	}
	private void InOrderTraversal(Node node) {
		if(node == null) 
			return;
		InOrderTraversal(node.left);
		if(node.parent!=null)
			System.out.print("-> "+node.data + " Parent:"+ node.parent.data);
		else
			System.out.print(node.data);
		InOrderTraversal(node.right);
	}

	public void Preorder() {
		PreorderTraversal(root);

	}
	private void PreorderTraversal(Node node) {
		if(node == null) 
			return;
		if(node.parent!=null)
			System.out.print("-> "+node.data + " Parent:"+ node.parent.data);
		else
			System.out.print(node.data);

		PreorderTraversal(node.left);

		PreorderTraversal(node.right);
	}

	public void Postorder() {
		PostOrderTraversal(root);

	}
	private void PostOrderTraversal(Node node) {
		if(node == null) 
			return;
		PostOrderTraversal(node.left);
		PostOrderTraversal(node.right);
		if(node.parent!=null)
			System.out.print("-> "+node.data + " Parent:"+ node.parent.data);
		else
			System.out.print(node.data);
	}
	public void LevelWiseTraversal() {
		int ht=Height(root);
		System.out.println("Level-wise Traversal");
		for(int i=1;i<=ht;i++)
		{
			LevelWiseTraversal(root,i);
		}
	}
	private void LevelWiseTraversal(Node node,int level) {
		if(level==1)
		{
			System.out.print(" "+node.data);
		}
		else
		{
			if(node.left!=null)
				LevelWiseTraversal(node.left,level-1);
			if(node.right!=null)
				LevelWiseTraversal(node.right,level-1);
		}
	}
	private int Height(Node node) {
		if(node == null)
			return 0;
		return 1+Math.max(Height(node.left), Height(node.right));
	}

	public void InorderSuccessor(int data) {
		inorderSucc(data,root);
	}
	private void inorderSucc(int data, Node node) {
		if(node==null)
			return;
		else if (data < node.data)
			inorderSucc(data,node.left);
		else if(data > node.data)
			inorderSucc(data,node.right);
		else
		{
			if(node.right!=null)
			{
				Node leftChild= computeLeftMostChild(node.right);
				System.out.println("Inorder successor is:"+leftChild.data);
			}
			else
			{
				Node par=null;
				while((par=node.parent)!=null)
				{
					if(node==par.left)
					{
						System.out.println("Inorder successor is:"+par.data);
						break;
					}

				}
			}
		}
	}
	private Node computeLeftMostChild(Node node) {
		while(node.left!=null)
		{
			node=node.left;
		}
		return node;
	}
	public void Balaced() {
		if(maxHeight(root) - minHeight(root) > 1)
		{
			System.out.println("\n The tree is not balanced");
		}
		else
		{
			System.out.println("\n The tree is balanced");
		}

	}
	
	private int minHeight(Node node) {
		if(node == null)
			return 0;
		return 1+Math.min(minHeight(node.left), minHeight(node.right));
	}
	private int maxHeight(Node node) {
		if(node == null)
			return 0;
		return 1+Math.max(maxHeight(node.left), maxHeight(node.right));
	}



}
public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTImplementation obj=new BSTImplementation();

		// insert nodes in BST
		obj.Create(15);
		obj.Create(7);
		obj.Create(22);
		obj.Create(3);
		obj.Create(9);
		obj.Create(18);
		obj.Create(25);
		obj.Create(1);
		//obj.Create(15);

		// inorder traversal
		System.out.println("\n INORDER TRAVERSAL");
		obj.Inorder();

		// preorder traversal
		System.out.println("\n PREORDER TRAVERSAL");
		obj.Preorder();
		
		// postorder traversal
		System.out.println("\n POSTEORDER TRAVERSAL");
		obj.Postorder();

		// levelwise traversal
		obj.LevelWiseTraversal();

		// inorder successor
		obj.InorderSuccessor(22);

		// check whether the tree is balanced
		obj.Balaced();

	}

}
