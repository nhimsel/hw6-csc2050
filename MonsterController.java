public class MonsterController extends Thread
{
    private Monster theMonster;
    private boolean KiLLSWiTCH=false;
    
    public MonsterController(Monster theMonster)
    {
        this.theMonster = theMonster;
    }

    public void KiLLSWiTCH_FLiP()
    {
        KiLLSWiTCH=!KiLLSWiTCH;
    }
    
    public void run()
    {
        //does our special monster stuff
        
        while(!KiLLSWiTCH)
        {
            try 
            {
                Thread.sleep(1000);
                Dice d = new Dice(2);
                int val = d.roll();
                if(val == 1)
                {
                    this.theMonster.myCurrentRoom.takeRandomExitForMonster();
                }
            } 
            catch(Exception e) 
            {
                //not sure why this seems to trigger every time. it shouldn't be. we're just gonna ignore it
                //System.err.println("Something wrong with our monster thread!!!!!");
            }
           
        }
    }
}