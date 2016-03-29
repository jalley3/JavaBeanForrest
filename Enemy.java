import java.util.Random;

public abstract class Enemy {
	
		String name;
		int health;
		String weapon;
		String armor;
		
		  //getters and setters
		 public void SetName (String n){
			name = n;
		  }
		  public void SetHealth (int hp){
			health = hp;
		  }
		  void SetWeapon (String stick){
			weapon = stick;
		  }
		  void SetArmor (String protect){
			armor = protect;
		  }
		  String GetName (){
			return name;
		  }
		  public int GetHealth(){
			return health;
		  }
		  public String GetWeapon() {
			return weapon;
		  }
		  public String GetArmor(){
			return armor;
		  }
		  
		  public abstract int Fight();
		  public abstract String toString();
		  
		  public static Enemy GetRandomEnemy(){
			  Random rand = new Random();
			  int enemy = rand.nextInt(3);
			  switch (enemy){
			  case 0:
				  return new MonsterInLaw();
			  case 1:
				  return new CreditCollector();
			  case 2:
			  	  return new Exams(); 
			  }	  
			  return null;
		  }
		  public int Damage(int dmg, String wep){
			  
			  int damage;
			  
			  switch (armor){
			  case "Leather":
				  	if (wep.equals ("Bad Credit Score"))
				  	{
				  		damage = (int) Math.floor(dmg * 1.25);
				  		health -= damage;
				  		if (health < 0)
				  			health = 0;
				  		return damage;
				  	}
				  	else {
				  		damage = (int) Math.floor(dmg * .8);
				  		health -= damage;
				  		if (health < 0)
				  			health = 0;
				  		return damage;
				  	}
			 
			  case "Steel": 
				  if( wep.equals("Failing Grade")){
					 damage = (int) Math.floor(dmg * 1.5);
					 health -= damage;
					 if (health < 0)
						 health = 0;
					 return damage;
				 }
				  else {
					  damage = (int) Math.floor(dmg * .7);
					  health -= damage;
					  if (health < 0)
						  health = 0;
					  return damage;
				  }
			  default: 
				  health -= dmg;
				  if (health < 0)
					  health = 0;
				  return dmg;
		  }
		  
	  }
}
