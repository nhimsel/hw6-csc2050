class Player extends Object
{
    protected String name;
    protected int hp; //hit points - a value between 15 and 30
    protected int str; //strength - a value between 8 and 12
    protected int ac; //armor class - a value between 5 and 17
    protected Room myCurrentRoom = null;
    
    public Player(String name)
    {
        //who is super?
        this.name = name;
        
        Dice hpDice = new Dice(16);
        this.hp = hpDice.roll() + 14;
        
        Dice strDice = new Dice(5);
        this.str = strDice.roll() + 7;
        
        Dice acDice = new Dice(13);
        this.ac = acDice.roll() + 4;
    }
    
    public void setTheCurrentRoom(Room r)
    {
        if(r != null)
        {
            this.myCurrentRoom = r;
        }
    }
    
    public Room getTheCurrentRoom()
    {
        return this.myCurrentRoom;
    }
    
    public boolean isDead()
    {
        return this.hp <= 0;
    }
    
    public void takeDamage(int damage)
    {
        this.hp = this.hp - damage;
    }
    
    public int getAC()
    {
        return this.ac;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void display()
    {
        System.out.println("*******************");
        System.out.println("Name: " + this.name);
        System.out.println("HP: " + this.hp);
        System.out.println("STR: " + this.str);
        System.out.println("AC: " + this.ac);
        System.out.println("*******************");
    }
    
}