import java.util.*;

public class permutation{

	public static ArrayList<String> permute(String s){
		if (s.length() == 1){
			return new ArrayList<String>(Arrays.asList(new String[]{s}));
		}
		ArrayList<String> mutations = new ArrayList<String>();
		for (int i=0;i<s.length();i++){
			String str = s.substring(i,i+1);
			String str2 = s.substring(0,i).concat(s.substring(i+1,s.length()));
			ArrayList<String> mutations2 = permute(str2);

			for (String s2:mutations2){
				String str3 = str.concat(s2);
				mutations.add(str3);
			}
		}

		return mutations;
	}
	public static void main(String [] args){
		System.out.println(permute("abc"));		
		System.out.println(permute("abcd"));		
	}
}
