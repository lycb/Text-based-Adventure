import java.util.Scanner;

public class Character
{
    private String name;
    private int health;
    private int coins;
    private Inventory bag;
    private String charDescription;
    private boolean bot;
    
    public Character(String name)
    {
        this.name = name;
        health = 100;
        coins = 1000;
        bag = new Inventory();
        charDescription = "CHICKEN NUGGETS ARE MY FAVORITES";
        
    }  
    public Character(String name, boolean bot)
    {
        this.name = name;
        this.bot = bot;
        health = 10000000;
        coins = 1000000;
        bag = null;
        charDescription = "I AM A BOT";
    }
    
    public Inventory getInventory()
    {
        return bag;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public int getCoins()
    {
        return coins;
    }
    
    public void setCoins(int coins)
    {
        this.coins = coins;
    }
    
    public void setName(String name)
    {
        this.name = name; 
    }
    
    public String getName()
    {
        return name;
    }

    public String getCharDescription()
    {
        return charDescription;
    }

    public void setCharDescription(String charDescription)
    {
        this.charDescription = charDescription;
    }
    
    
    
}
