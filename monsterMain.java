import java.util.*;

public class monsterMain {
	public static void launchArena(Monster a1, Monster a2){
		while (a1.hp >0 && a2.hp>0){
			int attack1 = a1.getAtk();
			System.out.println(a1.name + " attacks with " + 

attack1);	
			a2.hp -= attack1;
			attack1 = a2.getAtk();
			System.out.println(a2.name + " attacks with " + 

attack1);
			a1.hp -= attack1;
			System.out.println("STATUS: "+a1.hp+" and "+a2.hp);
		}
		Monster loser;
		Monster winner;
		if (a1.hp == 0){
			loser = a1;
			winner = a2;
		}else{
			loser = a2;
			winner = a1;
		}
		System.out.println(loser.name + " has fallen!");
		System.out.println(winner.name + " is victorious!");
	}



	public static void main(String[] args){
		Monster sam = new Monster(2,2,"Samuel");
		Monster jack = new Garoosh(2,4,"Jack");
		sam.MonsterCall();
		jack.MonsterCall();
		launchArena(sam, jack);		
	}
}
