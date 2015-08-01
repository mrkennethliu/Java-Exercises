import java.util.*;

public class stackqueueexercise{
	public static Stack<Integer> st = new Stack<Integer>();
	public static Stack<Integer> st2 = new Stack<Integer>();
	public static Stack<Integer> st3 = new Stack<Integer>();
	public static void hanoi(int n,Stack<Integer> origin,Stack<Integer> dest,Stack<Integer> buff){
		if (n <= 0){
			return;
		}
		hanoi(n-1,origin,buff,dest);
		
		topMove(origin,dest);
		hanoi(n-1,buff,dest,origin);
	}
	public static void topMove(Stack<Integer> origin, Stack<Integer> dest){
		int val = origin.pop();
		dest.push(val);
	}
	public static Stack<Integer> sortStack(Stack<Integer> st){
		Stack<Integer> st2 = new Stack<Integer>();
		int max = -100;
		while (!st.empty()){
			int val = st.pop();
			if (max < val){
				if (max != -100){
					st2.push(max);
				}
				max = val;
			}else{
				int count =0;
				while (!st2.empty()){
					int test = st2.pop();
					if (test < val) {
						st2.push(test);
						break;
					}
					st.push(test);
					count++;
					
				}
				st2.push(val);
				while (count > 0){
					int test = st.pop();
					st2.push(test);		
					count--;
				}
			}
		}
		st2.push(max);
		return st2;
	}
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		st.push(3);st.push(1);st.push(4);st.push(5);st.push(2);
		Stack<Integer> sorted = sortStack(st);
		while (!sorted.empty()){
			System.out.println(sorted.pop());
		}
	}

}
class myQueue{
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public myQueue(){
	}
	public void queue(Integer i){
		if (!s1.empty()){
			while (!s1.empty()){
				Integer val = s1.pop();
				s2.push(val);
			}
			s1.push(i);
			while (!s2.empty()){
				Integer val = s2.pop();
				s1.push(val);
			}
		}else{
			s1.push(i);
		}
	}
	public Integer dequeue(){
		if (s2.empty()){
			return s1.pop();
		}else{
			return s2.pop();
		}	
	}
	public boolean empty(){
		if (s2.empty() && s1.empty()){
			return true;
		}
		return false;
	}
}
class StackofStacks{
	ArrayList<Stack2> stackstack = new ArrayList<Stack2>();
	int size;
	public StackofStacks(int size){
		this.size = size;
	}
	public void push(int n){
		if (stackstack.size() < 1){
			Stack2 st = new Stack2(n);
			stackstack.add(0,st);
			return;
		}
		Stack2 recent = stackstack.get(0);
		if (recent.size == size){
			Stack2 st = new Stack2(n);
			stackstack.add(0,st);
			return;
		}
		recent.push(n);
	}	
	public int pop(){
		Stack2 recent = stackstack.get(0);
		return recent.pop();		
	}
	public int popAt(int index){
		if (index < 0 || index > stackstack.size()){
			return -1;
		}
		Stack2 recent = stackstack.get(index);
		return recent.pop();
	}
}
class Queue{
	int[] arr = new int[100];
	public Queue(int val){
		arr[0] = val;
	}
	public void add(int val){
		int index=0;
		while (arr[index] != 0 && index < 100){
			index++;
		}
		arr[index] = val;
	}		
	public int dequeue(){
		int first = 0;
		while (arr[first] ==0 && first < 100){
			first++;
		}
		int returnval = arr[first];
		arr[first]=0;
		return returnval;
	}
}
class Stack2{
	int[] arr = new int[100];
	int min = -1;
	int size = 0;
	public Stack2(int val){
		min = val;
		arr[0] = val;
		size++;
	}
	public void push(int val){
		if (min == -1 || val < min){
			min = val;
		}
		int index=0;
		while (arr[index] != 0 && index < 100){
			index++;
		}
		arr[index] = val;
		size++;
	}
	public int pop(){
		int last = 99;
		while (arr[last] ==0 && last > 0){
			last--;
		}
		if (size > 0) size--;
		return arr[last];
	}
}
