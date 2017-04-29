import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Traversal{

	Queue queue;
	Stack stack;
	public Traversal()
	{
		queue=new LinkedList<Integer>();
		stack=new Stack();
	}

	public void BFS(int[][] adjMatrix, int source) {
		int[] visited= new int[adjMatrix.length];
		int element,i;

		visited[source]=1;
		queue.add(source);

		int numberOfNodes = adjMatrix.length;

		System.out.println("\n BFS: ");
		while(!queue.isEmpty())
		{
			element=(int) queue.remove();
			i=element;

			System.out.print(element);

			while(i<=numberOfNodes-1)
			{
				if(adjMatrix[element][i]==1 && visited[i]==0)
				{
					queue.add(i);
					visited[i]=1;
				}
				i++;
			}
		}


	}

	//Iterative DFS
	public void DFS(int[][] adjMatrix, int source) {
		int[] visited=new int[adjMatrix.length];

		visited[source]=1;
		stack.push(source);

		System.out.println("DFS: ");
		while(!stack.isEmpty())
		{
			int element=(int) stack.pop();
			System.out.print(element);
			ArrayList<Integer> neighbours =findAdjacent(adjMatrix, element);
			for(int i:neighbours)
			{
				if(visited[i]==0)
				{
					stack.add(i);
					visited[i]=1;
				}


			}
		}

	}

	private ArrayList<Integer> findAdjacent(int[][] adjMatrix, int element) {

		ArrayList<Integer> arrList=new ArrayList<Integer>();

		for (int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[element][i]==1)
			{
				arrList.add(i);
			}

		}
		return arrList;
	}

	public void recursiveDFS(int[][] adjMatrix, int source) {
		int[] visited=new int[adjMatrix.length];

		visited[source]=1;
		System.out.print(source+ "\t");
		ArrayList<Integer> arrList=findAdjacent(adjMatrix,source);
		for(int i: arrList)
		{
			if(visited[i]==0)
			{
				recursiveDFS(adjMatrix,i);
				visited[i]=1;
			}
		}

	}


}

public class GraphTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices");

		// Input the adjacency matrix
		int vertices=sc.nextInt();

		int[][] adjMatrix=new int[vertices][vertices];

		System.out.println("\n Enter the adjacency matrix");
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				adjMatrix[i][j]=sc.nextInt();
			}

		}

		System.out.println("\nThe adjacency matrix is:");
		for (int i = 0; i < adjMatrix.length; i++) {
			System.out.println();
			for (int j = 0; j < adjMatrix.length; j++) {
				System.out.print(" "+adjMatrix[i][j]);
			}
		}
		
		// traverse graph using Breadth First Search
		Traversal traversal=new Traversal();
		traversal.BFS(adjMatrix,0);

		// traverse graph using Depth First Search
		System.out.println("\n Iterative DFS:");
		traversal.DFS(adjMatrix,0);

		// traverse graph using Depth First Search - Recursive
		System.out.println("\n Recursive DFS:");
		traversal.recursiveDFS(adjMatrix,0);
	}

}
