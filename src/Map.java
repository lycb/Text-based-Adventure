public class Map
{
    private String description;
    private Map north, south, east, west;
    
    public Map()
    {
        this.description = null;
    }
    
    public Map(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Map getNorth()
    {
        return north;
    }

    public void setNorth(Map north)
    {
        this.north = north;
    }

    public Map getSouth()
    {
        return south;
    }

    public void setSouth(Map south)
    {
        this.south = south;
    }

    public Map getEast()
    {
        return east;
    }

    public void setEast(Map east)
    {
        this.east = east;
    }

    public Map getWest()
    {
        return west;
    }

    public void setWest(Map west)
    {
        this.west = west;
    }
}