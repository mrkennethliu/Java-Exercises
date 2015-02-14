import java.util.*;

public class ransom{
	public static Hashtable<String, Integer> getMag(String magazine){
		Hashtable<String, Integer> mag = new Hashtable<String, Integer>();
		magazine = magazine.replaceAll("\\s+","");
		for (char c:magazine.toCharArray()){
			String s = String.valueOf(c);
			Integer val = mag.get(s);		
			if (val != null){
				mag.put(s,val+1);
			}else{
				mag.put(s,1);
			}
		}
		return mag;
	}
	public static boolean verify(Hashtable<String, Integer> mag, String note){
		note = note.replaceAll("\\s+","");
		for (char c:note.toCharArray()){
			String s = String.valueOf(c);	
			Integer val = mag.get(s);
			if (val == null || val < 1){
				return false;
			}
			mag.put(s,val-1);
		}
		return true;
	}
	public static void main(String[] args){
		String magazine = "this is a magazine sample of letters and such might be used for a ransom note";
		String ransomNote = "this is a ransom note of letters and such zebra zebra";
		magazine = magazine.toLowerCase();
		ransomNote = ransomNote.toLowerCase();
		Hashtable<String, Integer> mag = getMag(magazine);
		System.out.println(mag);
		System.out.println(verify(mag,ransomNote));
	}
}
