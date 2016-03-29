import java.util.Random;

public class Knight extends Enemy{
	
	  //user constructed class with parameters 
	  Knight (String n, String stick)
	  {
		Random randomizer = new Random();
		name = n;
		health = 300;
		weapon = stick;
		int armorTest = randomizer.nextInt(2);
		if (armorTest == 0){
			armor = "Leather";
		}
		if (armorTest == 1){
			armor = "Steel";
		}
	  }
	@Override
	public int Fight() {
		 Random randomizer = new Random();
		 int damage = 0;
		 //randomize damage based on weapon
		 if (weapon.equals("Long Sword")){
			 damage = randomizer.nextInt(21) + 10;
		 }
		 else if (weapon.equals("Warhammer")){
			 damage = randomizer.nextInt(30) + 10;
		 }
		 else if (weapon.equals("Battle Axe")){
			 damage = randomizer.nextInt(11)+30;
		 }
		 else if (weapon.equals("Spear")){
			 damage = randomizer.nextInt(40) + 1;
		 }
		 return damage;
	}
	@Override
	public String toString(){
		String message = "Enemy: " + GetName() + "\nHealth: "
					+ Integer.toString(GetHealth()) + "\nWeapon: "
					+ GetWeapon() + "\nArmor: " + GetArmor();
		return message;
	}
}
	