import java.util.Random;

public class Pokemon
{
    private int pokiHealth;
    private int yourHealth;
    private Random rand = new Random();
    public Pokemon(Character mainChar)
    {
        pokiHealth = 100;
        yourHealth = mainChar.getHealth();
    }
    
    public void fight()
    {
        System.out.println("You attacked the mysterious Pokemon!!!");
        pokiHealth -= rand.nextInt(50);
        yourHealth -= rand.nextInt(50);
        
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
        if (pokiHealth < 20)
        {
            System.out.println("You caught the Pokemon!!!!");
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
    public void playPokemon()
    {
        System.out.println("YOU HAVE ENCOUNTERED A POKEMON");
    }

    public void pokemonPrompt()
    {
        System.out.print("Fight, run, or catch!> ");
    }
}
