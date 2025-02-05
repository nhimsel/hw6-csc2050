import java.util.Random;

class Dice
{
    private int sides;
    private Random rng;
    
    public Dice(int sides)
    {
        this.sides = sides;
        this.rng = new Random();
    }
    
    public int roll()
    {
        return this.rng.nextInt(this.sides) + 1;
    }
}