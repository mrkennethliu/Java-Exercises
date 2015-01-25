import java.util.*;

public class sorts{
	public static ArrayList<Integer> qslst = new ArrayList<Integer>();
	public static ArrayList<Integer> quicksort(int lo, int hi){
		if (lo < hi){
			int index = partition( lo, hi);
			quicksort(lo, index-1);
			quicksort(index+1, hi);
		}
		return qslst;
	}
	public static int partition( int lo, int hi){
		int pivotIndex = getPivot(lo,hi);
		int pivotVal = qslst.get(pivotIndex);
		int startval = lo;
		swap(pivotIndex,hi);
		for (int i=lo;i<hi;i++){
			if (qslst.get(i) < pivotVal){
				swap(i,startval);
				startval++;
			}
		}
		swap(startval,hi);
		return startval;
	}
	public static int getPivot(int lo, int hi){
		ArrayList<Integer> templst =new ArrayList<Integer>(qslst.subList(lo,hi+1));
		int pivotIndex = templst.size()/2;
		return pivotIndex+lo;
	}
	public static void swap(int lo, int hi){
		int temp = qslst.get(hi);
		qslst.set(hi,qslst.get(lo));
		qslst.set(lo,temp);
	}
	public static ArrayList<Integer> mergesort(ArrayList<Integer> lst){
		if (lst.size() == 1){
			return lst;
		}
		
		ArrayList<Integer> left = new ArrayList<Integer>(lst.subList(0,lst.size()/2));
		ArrayList<Integer> right = new ArrayList<Integer>(lst.subList(lst.size()/2,lst.size()));
		left = mergesort(left);
		right = mergesort(right);
		lst = merge(left,right);
		return lst;
	}
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
		int index1=0;
		int index2=0;
		ArrayList<Integer> merged = new ArrayList<Integer>();
		while (index1 < left.size() && index2 < right.size()){
			if (left.get(index1) < right.get(index2)){
				merged.add(left.get(index1));
				index1++;
			}else{
				merged.add(right.get(index2));
				index2++;
			}
		}
		while (index2< right.size()){
			merged.add(right.get(index2));
			index2++;
		}
		while (index1< left.size()){
			merged.add(left.get(index1));
			index1++;
		}
		return merged;
	}
	public static void main(String[] args){
		ArrayList<Integer> lst= new ArrayList<Integer>();
		for (String s: args){
			lst.add(Integer.parseInt(s));
		}
		qslst = lst;
		System.out.println(lst);
		//System.out.println(mergesort(lst));
		System.out.println(quicksort(0,qslst.size()-1));
	}
}
