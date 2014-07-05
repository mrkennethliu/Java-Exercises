public class Garoosh extends Monster{
	public Garoosh(int legs, int arms, String monsterName){
		super(legs, arms, monsterName);
		isViolent = true;
	}
	public void MonsterCall(){
		System.out.println("I am "+name+"! I will destroy everything you love!");
	}
}
