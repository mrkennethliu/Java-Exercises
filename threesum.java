import java.util.*;
public class threesum {
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> lol = new ArrayList<List<Integer>>();
		Set set = new HashSet<List<Integer>>();
		List<Integer> lst = new ArrayList<Integer>();
		for (int i:nums){
			lst.add(i);
		}
		Collections.sort(lst);
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		for (int i=0;i<lst.size();i++){
			if (ht.containsKey(lst.get(i))){
				continue;
			}
			ht.put(lst.get(i),1);
			int j = i+1;
			int k = lst.size()-1;
			while (j < k){
				int two_sum = lst.get(i) + lst.get(j);
				if (two_sum + lst.get(k) < 0){
					j++;
				}
				else if (two_sum + lst.get(k) > 0){
					k--;
				}
				else {
					List<Integer> sup_brah = new ArrayList<Integer>();
					sup_brah.add(lst.get(i)); sup_brah.add(lst.get(j)); sup_brah.add(lst.get(k));
					set.add(sup_brah);
					j++;
					k--;
				}
			}
		}
		lol = new ArrayList<List<Integer>>(set);
		return lol;
	}
	public int threeSumClosest(int[] nums, int target) {
		List<Integer> lst = new ArrayList<Integer>();
		for (int i:nums){
			lst.add(i);
		}
		Collections.sort(lst);
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		int closest = Integer.MAX_VALUE;
		int sum = 0;
		System.out.println(lst);
		for (int i=0;i<nums.length;i++){
			if (ht.containsKey(lst.get(i))){
				continue;
			}
			ht.put(lst.get(i),1);
			int j = i+1;
			int k = nums.length-1;
			// System.out.println(i+":"+j+":"+k);
			while (j < k){
				int two_num = lst.get(i) + lst.get(j);
				//   System.out.println(two_num+lst.get(k));
				if (Math.abs(two_num+lst.get(k)-target) < closest) {
					closest = Math.abs(two_num+lst.get(k)-target);
					sum = two_num+lst.get(k);
				}
				if (two_num + lst.get(k) < target){
					j++;
				}
				else if (two_num + lst.get(k) > target) {
					k--;
				}
				else {
					return target;
				}
			}
		}
		return sum;
	}
	public static void main(String[] args){

	}
}
