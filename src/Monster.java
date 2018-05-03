import java.util.Random;

public class Monster
{
    private int monsterHealth;
    private int yourHealth;
    private Random rand = new Random();
    
    public Monster(Character mainChar)
    {
        monsterHealth = 100;
        yourHealth = mainChar.getHealth();
    }
    
    public boolean mAlive()
    {
        if (monsterHealth <= 0)
        {
            return false;
        }
        return true;
    }
    
    public boolean yAlive()
    {
        if (yourHealth <= 0)
        {
            return false;
        }
        return true;
    }
    
    public void fight(Inventory bag)
    {
        if (bag.contains("sword")
            || bag.contains("hammer")
            || bag.contains("bow and arrow"))
        {
            System.out.println("You have attacked the Java compiler!!!");
            monsterHealth -= rand.nextInt(50);
            yourHealth -= rand.nextInt(10);
            printStats();
            
            if (!mAlive())
            {
                System.out.println("You win!");
            }
            if (!yAlive())
            {
                System.out.println("You died!");
                bye();
            }
        }
        else if (!bag.contains("sword")
            || !bag.contains("hammer")
            || !bag.contains("bow and arrow"))
        {
            System.out.println("You cannot fight the monster without weapons.");
            System.out.println("Go to the store or go to the lounge and find items");
        }
        
    }
   
    public void printStats()
    {
        if (monsterHealth > 0 && yourHealth > 0)
        {
            System.out.println("Monster's Health: " + monsterHealth);
            System.out.println("Your health: " + yourHealth);
        }
    }
    public void bye()
    {
        System.out.println("GAME OVER");
        System.exit(-1);
    }
    
    public void heal(Inventory bag)
    {
        if (bag.contains("potion"))
        {
            yourHealth += 100;
            bag.useItems("potion");
            if (yourHealth > 100)
            {
                yourHealth = 100;
            }
            printStats();
        }
        else if (!bag.contains("potion"))
        {
            System.out.println("> Cannot heal! There aren't any potions");
        }
    }
    
    public boolean run(Inventory bag)
    {
        boolean runable = false;
        System.out.println("> You decided to run");
        if (!(monsterHealth < 20))
        {
            if (!bag.contains("sword")
               && !bag.contains("hammer")
                && !bag.contains("bow and arrows"))
            {
                runable = true;
            }
            else
            {
                System.out.println("> You cannot run! Monster is not weak enough.");
            }
        }
        else
        {
            runable = true;
        }
        return runable;
    }
    
    
    public void prompt()
    {
        System.out.println("Fight, heal, or run > ");
    }

}
