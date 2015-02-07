import java.util.*;

public class clockangle {
//minute 6 degrees
//5 min 30 degrees
// 1 hour 30 degrees
//hour moves 1/2 degree a minute
	public static void main(String[] args){
		int hour = Integer.parseInt(args[0]);
		int min = Integer.parseInt(args[1]);
		double answer = check(hour,min);
		hour = hour % 12;
		double minangle = min * 6;
		double hourangle = (hour*30)+(0.5*min);
		double angle = Math.abs(hourangle - minangle);
		System.out.println(angle);
		System.out.println(answer);
	}
	public static double check(int hour, int min){
		double angle = ((30*hour) - (5.5* min)) % 360;
		return angle;
	}	
}
