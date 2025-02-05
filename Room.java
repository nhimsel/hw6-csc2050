class Room
{
    private String name;
    private Player thePlayer;
    private Monster theMonster;
    private Exit[] availableExits = new Exit[4];
    private int currNumberOfExits = 0;
    
    public Room(String name)
    {
        this.name = name;
        this.thePlayer = null;
        
        //this.display(); //for testing purposes as the room is built
    }
    
    public void takeExit(String direction)
    {
        if(this.hasExit(direction))
        {
            //do we actually move the player
            for(int i = 0; i < this.currNumberOfExits; i++)
            {
                if(this.availableExits[i].getDirection().equalsIgnoreCase(direction))
                {
                    //put the player into the destination room
                    this.availableExits[i].getDestinationRoom().setThePlayer(this.thePlayer);
                    
                    //remove the player from this room
                    this.thePlayer = null;
                }
            }
        }
        else if (direction.equals("show"))
        {
            //doesn't print anything. will trigger play() to loop and print again without error
        }
        else
        {
            System.out.println("No exit in direction: " + direction);
        }
    }
    
    private boolean hasExit(String direction)
    {
        for(int i = 0; i < this.currNumberOfExits; i++)
        {
            if(this.availableExits[i].getDirection().equalsIgnoreCase(direction))
            {
                return true;
            }
        }
        return false;
    }
    
    public void addExit(String direction, Room destination)
    {
        if(this.currNumberOfExits <= 3)
        {
            Exit e = new Exit(direction, destination);
            this.availableExits[this.currNumberOfExits] = e;
            this.currNumberOfExits++;
        }
        else
        {
            System.err.println("there are too many exits!!!!");
        }
    }
    
    public void setThePlayer(Player thePlayer)
    {
        this.thePlayer = thePlayer;
        thePlayer.setTheCurrentRoom(this);
    }
    
    public void setTheMonster(Monster theMonster)
    {
        this.theMonster = theMonster;
        this.theMonster.setTheCurrentRoom(this);
    }
    
    public void takeRandomExitForMonster()
    {
        if(this.theMonster != null)
        {
            //randomly select the exit from available exits
            Dice randomDie = new Dice(currNumberOfExits);
            int exitNo = randomDie.roll() -1;
            
            //set the new room on the monster
            this.theMonster.setTheCurrentRoom(availableExits[exitNo].getDestinationRoom());

            //move the monster to the new room
            availableExits[exitNo].getDestinationRoom().setTheMonster(this.theMonster);

            //System.out.println("\nMonster moved to " + this.theMonster.getTheCurrentRoom());

            this.setTheMonster(null);
        }
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }

    public void display()
    {
        System.out.println("Room: " + this.name);
        
        //inline if statement example
        //System.out.println("Also here: " + ((this.thePlayer != null)?this.thePlayer.getName():"nobody"));
        if(this.thePlayer != null)
        {
            System.out.println("Other players here: " + this.thePlayer.getName());
        }
        else
        {
            System.out.println("Other players here: nobody");

        }
        
        if(this.theMonster != null)
        {
            System.out.println("Enemies nearby: " + this.theMonster.getName());
        }
        else
        {
            System.out.println("Enemies nearby: none");

        }
        
        //show obvious exits:
        System.out.print("Obvious Exits: ");
        if(this.currNumberOfExits == 0)
        {
            System.out.println("none");
        }
        else
        {
            for(int i = 0; i < this.currNumberOfExits; i++)
            {
                System.out.print(this.availableExits[i].getDirection() + " ");
            }
            System.out.println("");
        }
    }
}