import java.util.*;

public class rotatearray {
	public static int findMin(ArrayList<Integer> rot){
		if (rot.size() == 1){
			return rot.get(0);
		}
		int midVal = rot.get(rot.size()/2);
		int lastVal = rot.get(rot.size()-1);
		if (midVal > lastVal){
			return findMin(new ArrayList<Integer>(rot.subList

(rot.size()/2,rot.size())));
		}
		if (midVal<=rot.get(0)){
			return midVal;
		}else{
			return rot.get(0);
		}	
	}
	public static void main(String[] args){
		ArrayList<Integer> rot = new ArrayList<Integer>();
		for (String s:args){
			rot.add(Integer.parseInt(s));
		}
		System.out.println(findMin(rot));	
	}
}
