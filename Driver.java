
public class Driver
{
	public static void main(String[] args) 
	{
	    Player p1 = new Player("Mike");
	    Dungeon theDungeon = new Dungeon("Death's Cross", p1);
	    theDungeon.play();
	}
}
