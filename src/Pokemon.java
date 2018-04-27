public class Pokemon
{
    private int pokiHealth;
    private int yourHealth;
   
    
    public Pokemon()
    {
        pokiHealth = 20;
        yourHealth = 30;
        
    }
    
    public void fight()
    {
        pokiHealth -= 10;
        yourHealth -= 5;
        
        if (pokiHealth > 0 && yourHealth > 0)
        {
            System.out.println("Pokemon's HP: " + pokiHealth);
            System.out.println("Your HP: " + yourHealth);
        }
        
        if (!pAlive())
        {
            System.out.println("You win!");
            bye();
            System.exit(-1);
        }
        if (!yAlive())
        {
            System.out.println("You died!");
            bye();
            System.exit(-1);
        }
    }
    
    public void run() {
        System.out.println("You got away\n"
            + "but you died because you slipped on a banana");
        bye();
        System.exit(-1);
    }
    
    public void catchP()
    {
        if (pokiHealth < 11)
        {
            System.out.println("You caught the pokemon");
            bye();
            System.exit(-1);
        }
        else
        {
            System.out.println("Pokemon escaped");
            bye();
            System.exit(-1);
        }
    }
    
    public void bye()
    {
        System.out.println("GAME OVER");
    }
    public boolean pAlive()
    {
        if (pokiHealth <= 0)
        {
            return false;
        }
        
        return true;
    }
    
    public boolean yAlive() {
        if (yourHealth <= 0)
        {
            return false;
        }
        return true;
    }
   

    public void playPokemonCommands(String command)
    {
        if (command.equalsIgnoreCase("fight"))
        {
            fight();
        }
        if (command.equalsIgnoreCase("run"))
        {
            run();
        }
        if (command.equalsIgnoreCase("catch"))
        {
            catchP();
        }
        
    }
}
