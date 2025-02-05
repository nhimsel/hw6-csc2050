public class MonsterController extends Thread
{
    private Monster theMonster;
    
    public MonsterController(Monster theMonster)
    {
        this.theMonster = theMonster;
    }
    
    public void run()
    {
        //does our special monster stuff
        while(true)
        {
            try 
            {
                Thread.sleep(1000);
                Dice d = new Dice(2);
                int val = d.roll();
                if(val == 1)
                {
                    //System.out.println("Leaving the room");
                    Dice whichExit new Dice()
                }
            } 
            catch(Exception e) 
            {
                System.err.println("Something wrong with our monster thread!!!!!");
            }
           
        }
    }
}