import java.util.*;

public class binarysearch{
	public static int search(ArrayList<Integer> arr, int val){
		int midVal = arr.get(arr.size()/2);
		ArrayList<Integer> arr2 = arr;
		while (midVal != val){
			if (midVal < val){
				arr2 = new ArrayList<Integer>(arr2.subList

(arr2.size()/2,arr2.size()));
			}else {
				arr2 = new ArrayList<Integer>(arr2.subList

(0,arr2.size()/2));
			}
			
			midVal = arr2.get(arr2.size()/2);
			if (arr2.size()==1){
				if (midVal != val){
					return -1;
				}
			}
		}
		return midVal;

	}
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (String s:args){
			arr.add(Integer.parseInt(s));
		}
		Collections.sort(arr);
		Random ran = new Random();
		int testindex = ran.nextInt(arr.size());
		System.out.println("Index : " + testindex);
		int found = search(arr, arr.get(testindex));
		System.out.println(arr.get(testindex));
		System.out.println(found);
		System.out.println("Search for 10");
		System.out.println(search(arr,10));
	}
}
