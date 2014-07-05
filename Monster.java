import java.util.*;
import java.io.*;
import java.math.*;
public class Monster {
    
	public int numLegs;
	public boolean isViolent = false;
	public int numArms;
	public String name;
	public int hp = 10;
	public int maxAtk = 5;
	public int attack = 1;
	public Monster (int legs, int arms, String monsterName){
        	numLegs = legs;
	        numArms = arms;
		name = monsterName;
    	}
	public void MonsterCall(){
		System.out.println("I am "+name+"! The pleasure is mine!");
	}
	public int getAtk(){
		Random rand = new Random();
		attack = rand.nextInt(maxAtk) + 1;
		return attack;
	}

}
	   
    
