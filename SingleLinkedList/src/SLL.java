import java.util.Collections;
import java.util.Stack;

class Node implements Comparable<Node>{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data=data;
	}

	@Override
	public int compareTo(Node o) {
		return this.compareTo(o);
	}
}

class LinkedList{
	Node head;
	int count;
	LinkedList(){
		head=null;
		count=0;
	}
	public void addNodeAtTheEnd(int data) {
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			count++;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newNode;
			temp=head;
			count++;
		}
	}
	public void display() {
		// TODO Auto-generated method stub
		Node temp=head;
		if(temp==null)
			System.out.println("The list is empty");
		else
		{
			while(temp.next!=null)
			{
				System.out.print(temp.data + "->");
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
	}
	public void insertAtTheBeginning(int data) {
		Node newNode= new Node(data);
		if(head==null)
		{
			head=newNode;
			count++;
		}
		else
		{
			newNode.next=head;
			head=newNode;
			count++;
		}
		
	}
	public void insertAtPos(int data, int pos) {
		Node newNode = new Node(data);
		if(head==null){
			head=newNode;
		}
		else
		{
			if(pos==1)
			{
				insertAtTheBeginning(data);
			}
			else if(pos==count-1)
			{
				addNodeAtTheEnd(data);
			}
			else if(pos > count+1)
			{
				System.out.println("Please enter a valid position");
			}
			else
			{
				Node temp=head;
				int c=1;
				while(temp.next!=null && c<pos-1)
				{
					temp=temp.next;
					c++;
				}			
				newNode.next=temp.next;
				temp.next=newNode;
				temp=head;
				count++;
			}
		}
		
	}
	public void deleteAtTheBeginning() {
		if(head==null)
		{
			System.out.println("The list is empty");
		}
		else
		{
			head=head.next;
			count--;
		}
	}
	public void deleteAtTheEnd() {// TODO Auto-generated method stub
		if(head==null)
		{
			System.out.println("The list is empty");
		}
		else
		{
			//int c=1;
			Node temp=head;
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			temp.next=null;
			temp=head;
			count--;
		}
	}
	public void deleteAtAPos(int pos) {
		if(head==null)
			System.out.println("The list is empty");
		else
		{
			if(pos==1)
				deleteAtTheBeginning();
			else if(pos==count-1)
				deleteAtTheEnd();
			else if (pos > count)
				System.out.println("Invalid position");
			else
			{
				int c=1;
				Node temp=head;
				while(temp.next.next!=null && c<pos-1)
				{
					temp=temp.next;
				}
				temp.next=temp.next.next;
				temp=head;
				count--;
			}
		}
	}
	public void sort() {
		//Collections.sort(head);
		if(head==null)
			System.out.println("The list is empty");
		else
		{
//			Node tempSwap=null;
//			Node temp1=head;
//			while(temp1!=null)
//			{
//				Node temp2=head;
//				while(temp2!=null)
//				{
//					if(temp1.data>temp2.data)
//					{
//						tempSwap=temp1;
//						temp1=temp2;
//						temp2=tempSwap;
//					}
//					temp2=temp2.next;
//				}
//				//temp1=head;
//				temp1=temp1.next;
//			}
			if (count > 1) {
		        for (int i = 0; i < count; i++ ) {
		            Node currentNode = head;
		            Node next = head.next;
		            for (int j = 0; j < count - 1; j++) {
		                if (currentNode.data > next.data) {
		                    int temp = currentNode.data;
		                    currentNode.data = next.data;
		                    next.data = temp;
		                } 
		                currentNode = next;
		                next = next.next;                   
		            } 
		        }
		    }
		}
	}
	public void removeDuplicates() {
		Node current=head;
		Node runner=current.next;
		
		while(current.next!=null)
		{
			runner=current.next;
			
			while(runner.next!=null)
			{
				if(current.data==runner.next.data)
				{
					runner.next=runner.next.next;
					//head=runner;
				}
				runner=runner.next;
				
			}
			current=current.next;
		}
		
	}
	public void printReverse() {
		reversePrint(head);
		System.out.println();
	}
	private void reversePrint(Node node) {
		if(node==null)
			return;
		reversePrint(node.next);
		System.out.print(node.data + " ->");
	}
	public void actualReverse() {
		actReverse(head);
		
	}
	private void actReverse(Node n) {
		if(n==null)
			System.out.println("The list is empty");
		else
		{
			Node previous=null;
			Node temp=n;
			while(temp!=null)
			{
				Node node=temp.next;
				temp.next=previous;
				previous=temp;
				temp=node;
			}

			head=previous;
		}
	}
	public int Length() {
		return count;
	}


}

public class SLL {

	public static void main(String[] args)
	{
		LinkedList obj=new LinkedList();
		
		obj.addNodeAtTheEnd(5);
		obj.addNodeAtTheEnd(4);
		obj.addNodeAtTheEnd(1);
		obj.addNodeAtTheEnd(5);
		obj.addNodeAtTheEnd(3);	
		obj.addNodeAtTheEnd(1);
		obj.addNodeAtTheEnd(5);
		obj.addNodeAtTheEnd(3);	
		obj.addNodeAtTheEnd(7);
		obj.addNodeAtTheEnd(4);
		obj.addNodeAtTheEnd(8);	
		
		System.out.println("Display linked list");
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Insert at the beginning");
		obj.insertAtTheBeginning(15);		
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		
		System.out.println("Insert at a position");
		obj.insertAtPos(20,3);
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Delete at the beginning");
		obj.deleteAtTheBeginning();
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Insert at the beginning");
		obj.insertAtTheBeginning(28);		
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Delete at the end");
		obj.deleteAtTheEnd();
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Delete at the position");
		obj.deleteAtAPos(6);
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Sorted Linked List");
		obj.sort();
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Remove duplicates");
		obj.removeDuplicates();
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Print reverse");
		obj.printReverse();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		System.out.println("Actual reverse");
		obj.actualReverse();
		obj.display();
		System.out.println("The current length of the linked list is: "+obj.Length());
		System.out.println();
		
		
	}
	
}
