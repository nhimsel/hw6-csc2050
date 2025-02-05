import java.util.Scanner;
import java.util.ArrayList;

public class Dungeon
{
    private String name;
    private Player thePlayer;
    private ArrayList<Room> theRooms = new ArrayList<Room>();
	Monster theMonster;
	MonsterController mc;

    public Dungeon(String name, Player thePlayer)
    {
        this.name = name;
        this.thePlayer = thePlayer;
        Room r1 = new Room("R1");
	    Room r2 = new Room("R2");
	    Room r3 = new Room("R3");
	    Room r4 = new Room("R4");
	    Room r5 = new Room("R5");
	    Room r6 = new Room("R6");
	    r1.setThePlayer(thePlayer);
	    
	    theMonster = new Monster("a troll");
	    r1.setTheMonster(theMonster);
	    mc = new MonsterController(theMonster);
	    mc.start();
	    
	    r1.setThePlayer(this.thePlayer);
	    r1.addExit("north", r2);
	    r2.addExit("north", r3);
	    r2.addExit("south", r1);
	    r3.addExit("south", r2);
	    r3.addExit("west", r4);
	    r3.addExit("north", r6);
	    r3.addExit("east", r5);
	    r4.addExit("east", r3);
	    r5.addExit("west", r3);
	    r6.addExit("south", r3);
	    
	    this.theRooms.add(r1);
	    this.theRooms.add(r2);
	    this.theRooms.add(r3);
	    this.theRooms.add(r4);
	    this.theRooms.add(r5);
	    this.theRooms.add(r6);

    }
    
    public void play()
    {
        String line = "";
        Scanner input = new Scanner(System.in);
        do
        {
            Room temp = this.thePlayer.getTheCurrentRoom();
            temp.display();
            System.out.print("What direction do you want to go? ");
            line = input.nextLine();
            
            temp.takeExit(line);
        
            
        }
        while(!line.equals("quit"));

		//kill the monsterthread when the game ends
		mc.KiLLSWiTCH_FLiP();

        System.out.println("Goodbye!");
    }
}