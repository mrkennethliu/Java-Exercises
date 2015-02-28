import java.util.*;

public class median{
	public static void main(String[] args){
		int size = Integer.parseInt(args[0]);
		int seed = Integer.parseInt(args[1]);
		int max = Integer.parseInt(args[2]);
		Random rand = new Random(seed);
		medianTracker mt = new medianTracker();
		while (size > 0){
			int val = rand.nextInt(max+1);
			System.out.println(val);
			mt.add(val);	
			size--;
		}
		System.out.println(mt.arr);
		System.out.println(mt.getMedian());
		
	}
	
}
class medianTracker {
		
	public ArrayList<Integer> arr = new ArrayList<Integer>();
	public medianTracker(){
	}
	public void add(int val){
		if (arr.size() == 0){
			arr.add(val);
		}else{
			int index=0;
			for (Integer i:arr){
				if (i > val){
					break;
				}
				index++;
			}
			if (index > arr.size()){
				arr.add(val);
			}else{
				arr.add(index,val);
			}
		}				
				
	}
	public int getMedian(){
		if (arr.size()%2 ==0){
			int med1 = arr.get(arr.size()/2);
			int med2 = arr.get((arr.size()/2)-1);							return (med1+med2)/2;		
		}else{
			return arr.get(arr.size()/2);
		}
	}
			
}
