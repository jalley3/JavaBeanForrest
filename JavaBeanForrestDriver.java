import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JavaBeanForrestDriver {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			//intro and prompts
			System.out.println("Welcome to JavaBean Forrest");
			System.out.println("Enter Name");
			String name = scan.nextLine();
			System.out.printf("%n%nPlease Choose your weapon: ");
			System.out.printf("%n1. Longsword %n2. Warhammer %n3. Spear %n4. Battle Axe");
			int choice = 0;
			Boolean continueLoop = true;
			do
			{
			  try // read two numbers and calculate quotient
			  {
				choice = scan.nextInt();
				continueLoop = false;} // end try
			  catch ( InputMismatchException inputMismatchException )
		 	  {
			  System.err.printf( "\nException: %s\n",
			  inputMismatchException );
			  System.out.println(
					"You must enter an integer. Please try again.\n" );
			  scan.nextLine(); // discard input so user can try again
			
		      } // end catch
			}//end do
			while (continueLoop == true);
			String weapon = null;
			//switch based on weapon selection
			switch (choice){
			case 1: weapon = "Long Sword";
				break;
			case 2: weapon = "Warhammer";
				break;
			case 3: weapon = "Spear";
				break;
			case 4: weapon = "Battle Axe";
				break;
			default: System.out.println("Invalid choice");
				break;
			}
			Knight player = new Knight(name, weapon); //construct knight
			Random rand = new Random();
			int enemies = rand.nextInt(5) + 2;
			int numFights = 0;
			for (int i = 0; i < enemies; i++)
			{
				Enemy opponent = Enemy.GetRandomEnemy();
				System.out.printf("%n%nYou have encountered " + opponent.GetName() + "! Prepare for Battle%n");
				int turn = rand.nextInt(2)+1; // Randomly select first turn
				int round = 0; // Round counter
				int damage = 0; // damage
				int roundCnt = 1; // determine round change
				while (player.GetHealth() > 0 && opponent.GetHealth() > 0){
					if (turn % 2 == 0) //knight attacks
					{
						try{
							
							damage = opponent.Damage(player.Fight(), player.GetWeapon());
							if (player.GetHealth() > 0)
							{System.out.printf("%n");}
							else 
								throw (new NegativeDamageException());
						} catch (NegativeDamageException e){
							damage = 0; 
						}
					//print results
						roundCnt++;
						if (roundCnt % 2 == 0){
							round++;
							System.out.printf("%n");
						}
						System.out.printf(
								"Round " + round + ":\n" + player.GetName()
										+ " attacks " + opponent.GetName()
										+ " with a " + player.GetWeapon()
										+ " for " + damage + " damage!\n"
										+ opponent.GetName() + " has "
										+ opponent.GetHealth()
										+ " health remaining!"
										);
						turn++;
					}
					else if (opponent.GetHealth() > 0){
							try{
							
								damage = player.Damage(opponent.Fight(), opponent.GetWeapon());
								if (player.GetHealth() > 0)
								{System.out.printf("%n");}
								else 
									throw (new NegativeDamageException());
							} catch (NegativeDamageException e){
								damage = 0; 
							}
						//print results
							roundCnt++;
							if (roundCnt % 2 == 0){
								round++;
								System.out.printf("%n");
							}
							System.out.printf(
									"Round " + round + ":\n" + opponent.GetName()
											+ " attacks " + player.GetName()
											+ " with a " + opponent.GetWeapon()
											+ " for " + damage + " damage!\n"
											+ player.GetName() + " has ");
							if(player.GetHealth() > 0)
								{
								System.out.printf(player.GetHealth()
											+ " health remaining!");
								}
							else {
								System.out.printf(" 0 health remaining");
							}
							turn++;
						}
					}
				if (player.GetHealth() > 0) {
					System.out.printf(
							"%n%n" + player.GetName()
							+ " has vanquished " + opponent.GetName() + " after "
							+ round + " rounds!", "JavaBean Forest");
					System.out.printf(
							"%n%nBattle Synopsis:%n"
							+ player.toString() + "%n%n" + opponent.toString());	
					numFights++;
				} else {
					System.out.printf(
									"%n%n" + opponent.GetName()
									+ " has vanquished " + player.GetName()
									+ " after " + round + " rounds!");
					System.out.printf(
									"%n%nBattle Synopsis: %n"
									+ player.toString() + "%n%n"
									+ opponent.toString());
					break;
				}
				
			} // end enemies while
			if (numFights == enemies){
				System.out.printf("%nCongratulations, you successfully navigated the forrest");
			}
			else 
				System.out.printf("%nDarn. You were obliterated back there!");
			//prompt for restart
			System.out.printf("%n%ntype 'again' to restart");
			String temp = scan.nextLine();
			String end = temp.toLowerCase();
			if (end.equals("again")){
				JavaBeanForrestDriver.main(null);
			scan.close(); //close scanner
			}
		}//end main
}//end class
