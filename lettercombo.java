import java.util.*;
public class lettercombo { 

	public static Hashtable<Integer,ArrayList<String>> ht = new Hashtable<Integer,ArrayList<String>>(){{
		put(2,new ArrayList(Arrays.asList("a","b","c")));
		put(3,new ArrayList(Arrays.asList("d","e","f")));
		put(4,new ArrayList(Arrays.asList("g","h","i")));
		put(5,new ArrayList(Arrays.asList("j","k","l")));
		put(6,new ArrayList(Arrays.asList("m","n","o")));
		put(7,new ArrayList(Arrays.asList("p","q","r","s")));
		put(8,new ArrayList(Arrays.asList("t","u","v")));
		put(9,new ArrayList(Arrays.asList("w","x","y","z")));
	}};
	public static List<String> letterCombinations(String digits) {
		List<String> lst = new ArrayList<String>();
		if (digits.length() == 0 || digits.contains("1") || digits.contains("0")){
			return lst;
		}
		if (digits.length() == 1){
			return ht.get(Integer.parseInt(digits));
		}
		List<String> left = letterCombinations(digits.substring(0,1));
		List<String> right = letterCombinations(digits.substring(1,digits.length()));
		for (String i :left){
			for (String k :right){
				String answ = i+k;
				lst.add(answ);
			}
		}
		return lst;
	}
	public static void main(String [] args){
	}
}
