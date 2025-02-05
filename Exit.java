public class Exit
{
    private String direction;
    private Room destination;
    
    public Exit(String direction, Room destination)
    {
        this.direction = direction;
        this.destination = destination;
    }
    
    public Room getDestinationRoom()
    {
        return this.destination;
    }
    
    public String getDirection()
    {
        return this.direction;
    }
}