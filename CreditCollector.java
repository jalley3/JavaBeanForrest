import java.util.Random;

public class CreditCollector extends Enemy {
	
	public CreditCollector() {
		name = "Silas Money Sucker";
		Random rand = new Random();
		health = rand.nextInt(50) + 50;
		armor = "Legal Fees";
		weapon = "Bad Credit Report";
	}
	@Override
	public String toString(){
		String message = "Credit Collector: " + GetName() + "\nHealth: "
					+ Integer.toString(GetHealth()) + "\nWeapon: "
					+ GetWeapon() + "\nArmor: " + GetArmor();
		return message;
	}
	@Override
	public int Fight() {
		Random atk = new Random();
		Random wep = new Random();
		int newWep = wep.nextInt(10)+1;
		if (newWep > 7){
			weapon = "Repo Men";
			return 40 + atk.nextInt(5);
		}
		else
			weapon = "Bad Credit Report";
		return 5 + atk.nextInt(35);
	}
}
