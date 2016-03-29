import java.util.Random;

public class Exams extends Enemy {

	public Exams(){
		name = "Java Final";
		weapon = "Failing Grade";
		Random rand = new Random();
		health = rand.nextInt(50) + 50;
		armor = "Misleading Questions";
	}
	@Override
	public int Fight() {
		Random atk = new Random();
		Random wep = new Random();
		int newWep = wep.nextInt(10)+1;
		if (newWep > 7){
			weapon = "A big Fat Zero";
			return 40 + atk.nextInt(5);
		}
		else
			weapon = "Failing Grade";
		return 10 + atk.nextInt(30);
	}
	@Override
	public String toString(){
		String message = "Exam: " + GetName() + "\nHealth: "
					+ Integer.toString(GetHealth()) + "\nWeapon: "
					+ GetWeapon() + "\nArmor: " + GetArmor();
		return message;
	}
}
