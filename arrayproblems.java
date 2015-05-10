import java.util.*;

public class arrayproblems{
	
	public static boolean isUniqueString(String s){
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		for (char c:s.toCharArray()){
			if (ht.get(c) != null){
				return false;
			}
			ht.put(c,1);
		}
		return true;
	}
	public static void IsUniqueString_test(){
		System.out.println("--Testing isUniqueString--");
		String s = "applesauce";
		System.out.println("1. "+s+": " + isUniqueString(s));
		s = "abcdefghijklm";
		System.out.println("2. "+s+": " + isUniqueString(s));
		s = "space n o";
		System.out.println("3. "+s+": " + isUniqueString(s));
		s = "spaceno";
		System.out.println("3. "+s+": " + isUniqueString(s));
	}
	public static String reversestring(char[] carray){
		char[] reversestring = new char[carray.length];
		int lastindex = carray.length-1;
		for (int i=0;i<reversestring.length;i++){
			reversestring[i] = carray[lastindex];
			lastindex--;			
		}
		return new String(reversestring);
	}
	public static void reversestring_test(){
		System.out.println("--Testing reveresestring--");
		String s = "applesauce ";
		System.out.println("1. "+s+": "+reversestring(s.toCharArray()));

	}
	public static boolean isPermutation(String s, String s2){
		HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
		if (s2.length() < s.length()){
			String temp = s;
			s = s2;
			s2 = temp;
		}
		for (Character c:s.toCharArray()){
			if (hm.get(c) != null){
				Integer oldval =hm.get(c);
				hm.put(c,oldval+1);
			}else{
				hm.put(c,1);
			}
		}
		for (Character c:s2.toCharArray()){
			if (hm.get(c) == null || hm.get(c) == 0){
				return false;
			}
			Integer val = hm.get(c);
			hm.put(c,val-1);
		}			
		return true;
		
	}
	public static void isPermutation_test(){
		System.out.println("--Testing isPermutation--");
		String s= "abbc";
		String s2 ="abc";
		System.out.println("1. "+s+", "+s2+": "+isPermutation(s,s2));
		s= "permutation";
		s2 ="mutateionpr";
		System.out.println("1. "+s+", "+s2+": "+isPermutation(s,s2));
	}
	public static char[] replacespaces(char[] carray, int truelength){
		char[] newcarray = new char[carray.length];
		int index =0;
		int index2 =0;
		while (index < truelength){
			char c = carray[index];
			if (c == ' '){
				newcarray[index2++] = '%';
				newcarray[index2++] = '2';
				newcarray[index2++] = '0';
			}
			else {
				newcarray[index2] = c;
				index2++;
			}
			index++;
		}
		return newcarray;
	}
	public static void replacespaces_test(){
		System.out.println("--Testing replacespaces--");
		String str = "Test string for carray";
		System.out.println("String: "+str);
		int truelength = str.length();
		str +="         ";
		System.out.println(replacespaces(str.toCharArray(),truelength));
	}
	public static String charcount(char[] carray){
		String countstring = "";
		int index = 0;
		while (index < carray.length){
			char c = carray[index];
			int count = 0;
			while (index < carray.length && carray[index] == c){
				index++;
				count++;
			}
			countstring += c+Integer.toString(count);
		}
		if (countstring.length() > carray.length){
			return new String(carray);
		}
		return countstring;
	}
	public static void charcount_test(){
		System.out.println("--Testing charcount--");
		String str = "aabbbccaaa";
		System.out.println("String: "+str);		
		System.out.println(charcount(str.toCharArray()));
		str = "abc";
		System.out.println("String: "+str);
		System.out.println(charcount(str.toCharArray()));
	}
	public static void matrixprinter(ArrayList<ArrayList<Integer>> matrix){
		for (ArrayList<Integer> arr : matrix){
			for (Integer i : arr){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer>> matrixZero(ArrayList<ArrayList<Integer>> matrix){
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int row = 0;
		for (List<Integer> l1 : matrix){
			int col =0;
			for (Integer i:l1){
				if (i==0){
					lst.add(row);
					lst.add(col);
				}
				col++;
			}
			row++;
		}
		int index = 0;
		while (index < lst.size()){
			int r = lst.get(index++);
			int c = lst.get(index++);
			int index2 = 0;
			for (int i=0;i<matrix.get(0).size();i++){
				matrix.get(r).set(i,0);
			}
			for (int i=0;i<matrix.size();i++){
				matrix.get(i).set(c,0);
			}
		}
		System.out.println(lst);	
		return matrix;
	}
	public static void matrixZero_test(){
		ArrayList<ArrayList<Integer>> mtest = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(0,2,3));
		ArrayList<Integer> test1 = new ArrayList<Integer>(Arrays.asList(1,5,3));		
		ArrayList<Integer> test2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		mtest.add(test);
		mtest.add(test1);
		mtest.add(test2);
		matrixprinter(mtest);
		mtest = matrixZero(mtest);
		matrixprinter(mtest);
	}
	public static boolean isSubstring(String s, String s2){
		for (int i=0;i<s.length();i++){
			int index = 0;
			int i2 = i;
			while (i2<s.length() && index < s2.length()){
				String str = s.substring(i2,i2+1);
				String str2= s2.substring(index,index+1);
				if (str2.equals(str)){
					i2++;
					index++;
				}else{
					break;
				}
			}
			if (index >=s2.length()){
				return true;
			}
		}
		return false;
	}
	public static boolean isRotate(String s, String s2){
		//abc
		//bca
		//cab
		if (s.length() != s2.length()){
			return false;
		}
		String substr ="";
		int missed = 0;
		for (int i=0;i<s.length();i++){
			if (missed == 0){
				substr += s.substring(i,i+1);
			}
			if (!isSubstring(s2,substr)){
				if (missed > 0){
					return false;
				}
				substr = s.substring(i,s.length());
				missed++;
			}
		}
		return true;
	}
	public static void main(String[] args){
		//IsUniqueString_test();
		//reversestring_test();
		//isPermutation_test();
		//replacespaces_test();
		//charcount_test();
		System.out.println(isRotate("abc","cab"));	
		System.out.println(isRotate("waterbottle","erbottlewat"));	
		System.out.println(isRotate("abcd","bcdda"));	
	}
}
