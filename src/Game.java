import java.util.Random;
import java.util.Scanner;

public class Game
{
    private static Map currentLocation;
    private static Character mainChar;
    private static Character jennyBot = new Character("Jenny", true);
    private static Character waldonBot = new Character("Chris Waldon", true);
    private static Character swansonBot = new Character("Joel Swanson", true);
    private static Character watersBot = new Character("Chad Waters", true);
    private static Map beginning = null;
    private static Map rules = null;
    private static Map lounge = null;
    private static Map store = null;
    private static Map room309 = null;
    private static Map room310 = null;
    private static Map room311 = null;
    private static Map room317 = null;
    private static Map room318 = null;
    private static Map room325 = null;
    private static Scanner keyboard = new Scanner(System.in);
    private static Pokemon game = null;
    private static Store storeObj = null;
    private Random rand = new Random();


    public Game(Map startingLocation)
    {
        this.currentLocation = startingLocation;
    }

    public String describe()
    {
        return currentLocation.getDescription();
    }

    public void handleCommand(String command)
    {
        //TODO handle commands
        if (command.equalsIgnoreCase("bag"))
        {
            System.out.println(mainChar.getInventory().toString());
        }
        if (command.equalsIgnoreCase("North"))
        {
            this.currentLocation = currentLocation.getNorth();
        }
        if (command.equalsIgnoreCase("West"))
        {
            this.currentLocation = currentLocation.getWest();
        }
        if (command.equalsIgnoreCase("East"))
        {
            this.currentLocation = currentLocation.getEast();
        }
        if (command.equalsIgnoreCase("South"))
        {
            this.currentLocation = currentLocation.getSouth();
        }
        if (command.equalsIgnoreCase("talk"));
        {
            if (currentLocation == lounge || currentLocation == room309)
            {
                robotPrompt(jennyBot);
            }
            if (currentLocation == store || currentLocation == room318)
            {
                robotPrompt(waldonBot);
            }
            if (currentLocation == room325)
            {
                robotPrompt(swansonBot);
            }
        }
        if (command.equalsIgnoreCase("exits"))
        {
            try
            {
                if (currentLocation.getNorth()!= null)
                {
                    System.out.println("north");
                }
                if (currentLocation.getSouth()!= null)
                {
                    System.out.println("south");
                }
                if (currentLocation.getEast()!= null)
                {
                    System.out.println("east");
                }
                if (currentLocation.getWest()!= null)
                {
                    System.out.println("west");
                }
            }
            catch(NullPointerException e)
            {
                System.out.println("Dead end. Go somewhere else");
                prompt();
            }
        }
        if (command.equalsIgnoreCase("action"))
        {
            try
            {
                if (currentLocation.equals(store))
                {
                    System.out.println("buy");
                    System.out.println("talk");
                }
                if (currentLocation.equals(lounge))
                {
                    System.out.println("talk");
                    System.out.println("find");
                }

            }
            catch (NullPointerException j)
            {
                System.out.println("Not a valid command");
            }
        }
        if (command.equalsIgnoreCase("find"))
        {
            if (currentLocation.equals(lounge))
            {
                int i = rand.nextInt(11);
                if (i % 2 == 0)
                {
                    System.out.println("Jenny Ly: You found a sword");
                    if (mainChar.getInventory().contains("sword"))
                    {
                        System.out.println("Jenny Ly: You already have this item. Find something else");
                    }
                    if (!mainChar.getInventory().contains("sword"))
                    {
                        mainChar.getInventory().addItems("sword");
                        System.out.println("Jenny Ly: You have a sword in your inventory now");
                    }
                }
                else
                {
                    System.out.println("Jenny Ly: You found potion");
                    if (mainChar.getInventory().contains("potion"))
                    {
                        System.out.println("Jenny Ly: You already have this item. Find something else");
                    }
                    else if (!mainChar.getInventory().empty() && !mainChar.getInventory().contains("potion"))
                    {
                        mainChar.getInventory().addItems("potion");
                        System.out.println("Jenny Ly: You have a potion in your inventory now. It can restore 100& of your health");
                    }
                }
            }
        }
    }

    public static void namePrompt()
    {
        System.out.print("what's your name? > ");
        System.out.flush();
    } 

    public static void robotPrompt(Character bot)
    {
        if (bot == jennyBot)
        {
            if (currentLocation == lounge)
            {
                System.out.println("Jenny Bot: There is an ITEM somewhere near here");
            }
            else if (currentLocation == room309)
            {
                System.out.println("Jenny Bot:fight the JAVA MONSTER");
                playPokemon();
                pokemonPrompt();
                while (keyboard.hasNext()) 
                {
                    String command = keyboard.nextLine();
                    game.playPokemonCommands(command);
                }
            }
        }

        if (bot == waldonBot)
        {
            if (currentLocation == store)
            {
                System.out.println("Chris Waldon: Welcome to Chris Waldon's office. You can buy items here");
            }
            if (currentLocation == room318)
            {
                System.out.println("Chris Waldon: Afternoon class is better.");
            }
        }

        if (bot == swansonBot)
        {
            if (currentLocation == room325)
            {
                System.out.println("Swanson: Click if you are here. Then solve the puzzle.");
            }
        }


    }
    public static void prompt()
    {
        System.out.print("command > ");
        System.out.flush();
    }
    public static void playPokemon()
    {
        System.out.println("YOU HAVE ENCOUNTERED A POKEMON");

    }

    public static void pokemonPrompt()
    {
        System.out.print("Fight, run, or catch!> ");
    }
    public static void printStats()
    {
        System.out.println("Health: " + mainChar.getHealth());
        System.out.println("Coins: " + mainChar.getCoins());
        System.out.println("Inventory: " + mainChar.getInventory());
    }

    public static void roomQuest(Map room)
    {
        if (room == lounge)
        {
            //find item
        }
        if (room == room309)
        {
            //fight java monster
        }
        if (room == room310)
        {
            //find items
        }
        if (room == room311)
        {
            //find eclipse monster
        }
        if (room == room317)
        {
            //fight the C monster
        }
        if (room == room318)
        {
            //find items
        }
        if (room == room325)
        {
            Puzzle binary = new Puzzle();
            int answer = keyboard.nextInt();
            if(binary.checkAnswer(answer))
            {
                System.out.println("CORRECT! you can move on to another room now");
            }
            else
            {
                System.out.println("YOU FAILED");

            }

        }
        if (room == store)
        {
            storeObj = new Store();
            String item = keyboard.nextLine();
            storeObj.buyingPrompt();
            storeObj.buy(item, mainChar);
        }
    }
    public static void main(String[] args)
    {


        beginning = new Map("WELCOME TO THE COMPUTER SCIENCE DEPARTMENT \n"
            + "--------------------------------------------------------------------- \n"
            + "Every room (but the store) has some objectives you can do. \n"
            + "You must complete these objectives before you \nMove on to the next room. \n"
            + "--------------------------------------------------------------------- \n");
        lounge = new Map("This is the lounge area. Talk to Jenny to begin your quest.");
        store = new Map("You have entered Chris Waldon's office"); //Room 313
        room309 = new Map("You have entered Room 309");
        room310 = new Map("You have entered Room 310");    
        room311 = new Map("You have entered Room 311");
        room317 = new Map("You have entered Room 317");
        room318 = new Map("You have entered Room 318");
        room325 = new Map("You have entered Room 325");

        beginning.setNorth(lounge);
      
        lounge.setSouth(beginning);

        lounge.setEast(store);



        try
        {
            //TODO: make a game

            Game g = new Game(beginning);

            namePrompt();
            String name = keyboard.nextLine();
            mainChar = new Character(name);

            System.out.println(mainChar.getCharDescription());
            printStats();
            System.out.println(g.describe());
            prompt();
            while(keyboard.hasNext())
            {
                String command = keyboard.nextLine();
                g.handleCommand(command);
                if (!command.equalsIgnoreCase("exits"))
                {
                    g.describe();
                }
                prompt();
            }



        }
        catch (NullPointerException e)
        {
            game = new Pokemon();
            playPokemon();
            pokemonPrompt();
            while (keyboard.hasNext()) {
                String command = keyboard.nextLine();
                game.playPokemonCommands(command);
                pokemonPrompt();
            }
        }
    }
}
