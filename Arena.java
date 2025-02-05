public class Arena
{
	private Player p1;
	private Player p2;
	private Dice d20;

	public Arena(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.d20 = new Dice(20);
	}

	public void startFight()
	{
		Player currentAttacker = this.p1;
		Player currentDefender = this.p2;
		Dice d4 = new Dice(4);

		while(true) //we internally break out as part of the logic
		{
		    this.p1.display();
		    this.p2.display();
		    
			//attacker attempts to attack the defender
			int attackRoll = this.d20.roll();
			if(attackRoll >= currentDefender.getAC())
			{
				//we have hit the defender
				int damage = d4.roll();
				currentDefender.takeDamage(damage);

				if(currentDefender.isDead())
				{
					System.out.println(currentAttacker.getName() + " has won the fight!");
					break; //stop fighting!!!!
				}
			}
			else
			{
				//we missed
				System.out.println(currentAttacker.getName() + " swings and misses");

				if(attackRoll == 1)
				{
					System.out.println("**** Critical Miss **** " + currentAttacker.getName() + " stumbles and stabs themselves in the foot!");
				}
			}

			//defender is still alive! Switch roles
			Player temp = currentAttacker;
			currentAttacker = currentDefender;
			currentDefender = temp;
		} //end of the infinite loop
		
		//after the loop but before the end of the method
		System.out.println("Game Over!!!!");
		
	}
}