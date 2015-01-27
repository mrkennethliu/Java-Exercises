import java.util.*;

public class linkedlistexample{
	public static void main(String[] args){
		Node n = new Node<Integer>(2);
		System.out.println(n);
		Node n2 = new Node<String>("rasta");
		Node n3 = new Node<Integer>(3);
		Node n5 = new Node<Integer>(5);
		Node n6 = new Node<Integer>(6);
		Node n4 = new Node<Integer>(4);
		System.out.println(n2);
		aLinkedLister ll = new aLinkedLister();
		ll.add(n);
		ll.add(n2);
		ll.add(n2);
		ll.add(n3);
		ll.add(n5);
		ll.add(n6);
		ll.insert(2,n4);
		System.out.println(ll);
	}
}

class aLinkedLister{
	Node head;
	Node end;
	int size =0;
	public aLinkedLister(){
	}
	public void add(Node n){
		if (head == null){
			head = n;
			size++;
		}
		else {
			Node current = head;
			for (int i=1;i<size;i++){
				current =  current.getNext();
			}
			current.link(n.getData());
			size++;
		}
	}
	public String toString(){
		if (head == null) return "";
		Node current = head;
		String vals = "";
		System.out.println("Size: "+size);
		for (int i=0;i<size;i++){ 
			vals += current.toString() + " - ";
			current =  current.getNext();
		}

		vals += "end";
		return vals;
	}
	public void insert(int index, Node n){
		Node current = head;
		int count = 1;
		while (current.getNext() !=null && count < index ){
			current =  current.getNext();
			count++;
		}
		Node nextNode = current.getNext();
		current.link(n.getData());
		for (int i=0;i<(size-index);i++){
			current.getNext().link(nextNode.getData());
			current = current.getNext();
			nextNode = nextNode.getNext();
		}
		size++;
	}
}
class Node<T>{

	T data;
	Node next;	
	public Node(T value){
		data = value;
	}
	public T getData(){
		return data;

	}
	public void link(T val){
		Node n = new Node<T>(val);
		next = n;
	}
	public Node getNext(){
		return next;
	}
	public String toString(){
		return data.toString();
	}
}
