
import java.util.*;
public class roman_numerals {
	Hashtable<String,Integer> string_set = new Hashtable<String,Integer>(){{
		put("I",1);
		put("V",5);
		put("X",10);
		put("L",50);
		put("C",100);
		put("D",500);
		put("M",1000);
	}};
	Hashtable<Integer,String> set = new Hashtable<Integer,String>(){{
		put(1,"I");
		put(5,"V");
		put(10,"X");
		put(50,"L");
		put(100,"C");  
		put(500,"D");
		put(1000,"M");
	}};

	public int romanToInt(String s) {
		int val = 0;
		int old_val = 0;
		for (int i=s.length()-1;i>=0;i--){
			String sub = s.substring(i,i+1);
			int cur_val = string_set.get(sub);
			if (cur_val >= old_val){
				val += cur_val;
			}
			if (cur_val < old_val){
				val = val - cur_val;
			}
			old_val = cur_val;
		}
		return val;
	}
	public static String intToRoman(int num) {
		String roman = "";
		int modifier = 1;
		while (num>0){
			int digit = num % 10;
			if (digit != 0){
				String roman_digit = helper(digit*modifier);
				roman = roman_digit + roman;
			}
			num = num /10;
			modifier = modifier * 10;
		}
		return roman;
	}
	public static String helper(int num){
		if (set.containsKey(num)){
			return set.get(num);
		}
		int modifier = 1;
		int tens = 10;
		while (tens < 10000){
			if (num > tens){
				modifier = tens;
			}
			tens = tens * 10;
		}
		int one = 1*modifier;
		int five = 5*modifier;
		int ten = 10*modifier;

		String roman = "";
		if (num == ten - one){
			return set.get(one)+set.get(ten);
		}
		if (num > five && num < ten - one){
			return set.get(five)+helper(num-five);
		}
		if (num < five - one){
			int multiple = num/one;
			while (multiple > 0){
				roman += set.get(one);
				multiple--;
			}
		}else{
			return set.get(one)+set.get(five);
		}

		return roman;

	}

	public static void main(String[] args){
		System.out.println(romanToInt("DCXXI"));
		System.out.println(intToRoman(414));
		return;
	}
	
}
