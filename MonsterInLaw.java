import java.util.Random;

public class MonsterInLaw extends Enemy{
	public MonsterInLaw(){
		name = "Tina the Terrible";
		weapon  = "Snide Comments";
		Random rand = new Random();
		health = rand.nextInt(50) + 50;
		armor = "Father in Law";
	}
	@Override
	public int Fight() {
		Random atk = new Random();
		Random wep = new Random();
		int newWep = wep.nextInt(10)+1;
		if (newWep > 7){
			weapon = "Poisonous Dinner";
			return 40 + atk.nextInt(5);
		}
		else
			weapon = "Snide Comments";
		return 20 + atk.nextInt(6);
	}
	@Override
	public String toString(){
		String message = "Mother-In-Law: " + GetName() + "\nHealth: "
					+ Integer.toString(GetHealth()) + "\nWeapon: "
					+ GetWeapon() + "\nArmor: " + GetArmor();
		return message;
	}
}
