import java.util.*;

public class stackqueueexercise{

	public static void main(String[] args){
		Stack test = new Stack(7);
		System.out.println(test.get());
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(1);
		test.add(8);
		System.out.println(test.get());
		System.out.println("min val: "+test.min);
		
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
class Stack{
	int[] arr = new int[100];
	int min = -1;
	public Stack(int val){
		min = val;
		arr[0] = val;
	}
	public void add(int val){
		if (min == -1 || val < min){
			min = val;
		}
		int index=0;
		while (arr[index] != 0 && index < 100){
			index++;
		}
		arr[index] = val;
	}
	public int get(){
		int last = 99;
		while (arr[last] ==0 && last > 0){
			last--;
		}
		return arr[last];
	}
}
