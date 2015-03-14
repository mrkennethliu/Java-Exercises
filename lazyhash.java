import java.util.*;

public class lazyhash{
	public int[] keys = new int[50];
	public String[] values = new String[50];
	public lazyhash(){	
	}
	public void put(int key, String value){
		int index =0;
		int tempindex = 0;
		while (index<keys.length){
			if (keys[index] == key){
				tempindex = index;
				break;
			}
			if (keys[index] == 0) tempindex=index;
			index++;
		}
		keys[tempindex] = key;
		values[tempindex] = value;

	}
	public String get(int key){
		int index =0;
		while (index<keys.length){
			if (keys[index] == key){
				break;
			}
			index++;
		}	
		return values[key];	
	}
	public String toString(){
		int index = 0;
		String keyvalue = "Keys,Values:\n";

		while (index < keys.length){
			if (keys[index] !=0){
				keyvalue += keys[index] + "," + values

[index]+"\n";
			}
			index++;
		}
		return keyvalue;
	}
	public static void main(String[] args){
		lazyhash lh = new lazyhash();
		lh.put(2,"jabbaer");
		lh.put(3,"libber");
		lh.put(2,"razzie");
		System.out.println(lh);
		Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
		ht.put(1,"jabbathehut");
		ht.put(500,"finthehuman");
		for (Integer key:ht.keySet()){
			System.out.println(key+": "+ht.get(key));
		}

	}
}
