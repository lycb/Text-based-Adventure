import java.util.Random;
import java.util.Scanner;

public class Game
{
    private static Map currentLocation;
    private static Character mainChar;
    //private static Character jennyBot = new Character("Jenny", true);
    //private static Character waldonBot = new Character("Chris Waldon", true);
    //private static Character swansonBot = new Character("Joel Swanson", true);
    //private static Character watersBot = new Character("Chad Waters", true);
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
    private static Random rand = new Random();


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
        else if (command.equalsIgnoreCase("quests"));
        {
            if (currentLocation == lounge)
            {
                
                if (mainChar.getInventory().size() == 1)
                {
                    System.out.println("You have [" + mainChar.getInventory().size() + "] item(s) in your bag." );
                    System.out.println("You can move on to the next room now.");
                }
                else
                {
                    System.out.println("You are in the lounge, use the find command to find items");
                }
            }
            if (currentLocation == room309)
            {
                roomQuest(room309);
            }
            if (currentLocation == store)
            {
                roomQuest(store);
            }
            if (currentLocation == room318)
            {
                roomQuest(room318);
            }
            if (currentLocation == room325)
            {
                roomQuest(room325);
            }
        }
        if (command.equalsIgnoreCase("bag"))
        {
            System.out.println(mainChar.getInventory().toString());
        }
        
        if (command.equalsIgnoreCase("exits"))
        {
            /*
            try
            {*/
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
            //}
            /*
            catch(NullPointerException e)
            {
                System.out.println("Dead end. Go somewhere else");
                prompt();
            } */
        }
        if (command.equalsIgnoreCase("find"))
        {
            if (currentLocation.equals(lounge))
            {
                roomQuest(lounge);
            }
        }
        
        if (command.equalsIgnoreCase("stats"))
        {
            printStats();
        }
    }

    public static void namePrompt()
    {
        System.out.print("what's your name? > ");
        System.out.flush();
    } 

    /*
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
     */
    public static void prompt()
    {
        System.out.print("command > ");
        System.out.flush();
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
            int i = rand.nextInt(11);
            if (i % 2 == 0)
            {
                System.out.println("You found a sword");
                if (mainChar.getInventory().contains("sword"))
                {
                    System.out.println("You already have this item. Find something else");
                }
                if (!mainChar.getInventory().contains("sword"))
                {
                    mainChar.getInventory().addItems("sword");
                    System.out.println("You have a sword in your inventory now");
                }
            }
            else
            {
                System.out.println("You found potion");
                if (mainChar.getInventory().contains("potion"))
                {
                    System.out.println("You already have this item. Find something else");
                }
                if (!mainChar.getInventory().contains("potion"))
                {
                    mainChar.getInventory().addItems("potion");
                    System.out.println("You have a potion in your inventory now. "
                        + "It can restore 100% of your health");
                }
            }
        }
        if (room == room309)
        {
            Monster mon = new Monster(mainChar);
            mon.play();
            System.out.println("You have encountered the JAVA monster");
            mon.prompt();
            while(keyboard.hasNext())
            {
                String command = keyboard.nextLine();
                if (command.equalsIgnoreCase("fight"))
                {
                    mon.fight(mainChar.getInventory());
                }
                if (command.equalsIgnoreCase("heal"))
                {
                    mon.heal(mainChar.getInventory());
                }
                if (command.equalsIgnoreCase("run"))
                {
                    mon.run();
                    System.out.println("You cannot escape!");
                    game = new Pokemon(mainChar);
                    game.playPokemon();
                    game.pokemonPrompt();
                    while (keyboard.hasNext()) {
                        String com = keyboard.nextLine();
                        game.playPokemonCommands(com);
                        game.pokemonPrompt();
                    }
                }
                else
                {
                    System.out.println("not a valid command");
                    mon.prompt();
                }
            }
            if (room == room310)
            {
                int i = rand.nextInt(11);
                
                if (i % 2 == 0)
                {
                    System.out.println("You found a sword");
                    if (mainChar.getInventory().contains("sword"))
                    {
                        System.out.println("You already have this item. Find something else");
                    }
                    if (!mainChar.getInventory().contains("sword"))
                    {
                        mainChar.getInventory().addItems("sword");
                        System.out.println("You have a sword in your inventory now");
                    }
                }
                else if (i % 2 != 0)
                {
                    System.out.println("You found potion");
                    if (mainChar.getInventory().contains("potion"))
                    {
                        System.out.println("You already have this item. Find something else");
                    }
                    else if (!mainChar.getInventory().contains("potion"))
                    {
                        mainChar.getInventory().addItems("potion");
                        System.out.println("You have a potion in your inventory now. "
                            + "It can restore 100& of your health");
                    }
                }
                
            }
            if (room == room311)
            {
                Monster tues = new Monster(mainChar);
                tues.play();
                System.out.println("You have encountered the ECLIPSE monster");
                tues.prompt();
                while(keyboard.hasNext())
                {
                    try
                    {
                        String command = keyboard.nextLine();
                        if (command.equalsIgnoreCase("fight"))
                        {
                            tues.fight(mainChar.getInventory());
                        }
                        if (command.equalsIgnoreCase("heal"))
                        {
                            tues.heal(mainChar.getInventory());
                        }
                        if (command.equalsIgnoreCase("run"))
                        {
                            tues.run();
                            throw new Exception("You cannot escape");
                        }

                        else
                        {
                            System.out.println("not a valid command");
                            tues.prompt();
                        }
                    }
                    catch (Exception e)
                    {
                        game = new Pokemon(mainChar);
                        game.playPokemon();
                        game.pokemonPrompt();
                        while (keyboard.hasNext()) {
                            String command = keyboard.nextLine();
                            game.playPokemonCommands(command);
                            game.pokemonPrompt();
                        }
                    }
                }
                if (room == room317)
                {
                    Monster weds = new Monster(mainChar);
                    weds.play();
                    System.out.println("You have encountered the GO monster");
                    weds.prompt();
                    while(keyboard.hasNext())
                    {
                        try
                        {
                            String command = keyboard.nextLine();
                            if (command.equalsIgnoreCase("fight"))
                            {
                                weds.fight(mainChar.getInventory());
                            }
                            if (command.equalsIgnoreCase("heal"))
                            {
                                weds.heal(mainChar.getInventory());
                            }
                            if (command.equalsIgnoreCase("run"))
                            {
                                weds.run();
                                throw new Exception("You cannot escape");
                            }

                            else
                            {
                                System.out.println("not a valid command");
                                weds.prompt();
                            }
                        }
                        catch (Exception e)
                        {
                            game = new Pokemon(mainChar);
                            game.playPokemon();
                            game.pokemonPrompt();
                            while (keyboard.hasNext()) {
                                String command = keyboard.nextLine();
                                game.playPokemonCommands(command);
                                game.pokemonPrompt();
                            }
                        }
                    }
                }
                if (room == room318)
                {
                    int i = rand.nextInt(11);
                    if (i % 2 == 0)
                    {
                        System.out.println("You found a sword");
                        if (mainChar.getInventory().contains("sword"))
                        {
                            System.out.println("You already have this item. Find something else");
                        }
                        if (!mainChar.getInventory().contains("sword"))
                        {
                            mainChar.getInventory().addItems("sword");
                            System.out.println("You have a sword in your inventory now");
                        }
                    }
                    else
                    {
                        System.out.println("You found potion");
                        if (mainChar.getInventory().contains("potion"))
                        {
                            System.out.println("You already have this item. Find something else");
                        }
                        else if (!mainChar.getInventory().empty() 
                            && !mainChar.getInventory().contains("potion"))
                        {
                            mainChar.getInventory().addItems("potion");
                            System.out.println("You have a potion in your inventory now. "
                                + "It can restore 100& of your health");
                        }
                    }
                }
                if (room == room325)
                {
                    Puzzle binary = new Puzzle();
                    System.out.println("Solve this and move on: "
                        + binary.generatePuzzle());
                    String answer = keyboard.nextLine();
                    if (binary.check(answer))
                    {
                        System.out.println("You can continue.");           
                    }
                    else
                    {
                        System.out.println("You've got the wrong answer.");
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
        }

    }
    public static void main(String[] args)
    {


        beginning = new Map("WELCOME TO THE COMPUTER SCIENCE DEPARTMENT \n"
            + "--------------------------------------------------------------------- \n"
            + "> Every room (but the store) has some objectives you can do. \n"
            + "> You must complete these objectives before you \n> move on to the next room. \n"
            + "--------------------------------------------------------------------- \n");
        lounge = new Map();
        store = new Map("You have entered Chris Waldon's office"); //Room 313
        room309 = new Map("You have entered Room 309");
        room310 = new Map("You have entered Room 310");    
        room311 = new Map("You have entered Room 311");
        room317 = new Map("You have entered Room 317");
        room318 = new Map("You have entered Room 318");
        room325 = new Map("You have entered Room 325");

        beginning.setNorth(lounge);
        lounge.setSouth(beginning);

        lounge.setEast(room309);
        room309.setWest(lounge);

        lounge.setWest(room325);
        room325.setEast(lounge);

        lounge.setNorth(room318);
        room318.setSouth(lounge);

        room318.setNorth(room317);
        room317.setSouth(room318);

        room309.setNorth(room310);
        room310.setSouth(room309);

        room310.setNorth(room311);
        room311.setSouth(room310);

        room311.setWest(store);
        store.setEast(room311);

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
                    System.out.println(g.describe());
                }
                prompt();
            }
        }
        catch (NullPointerException e)
        {
            game = new Pokemon(mainChar);
            game.playPokemon();
            game.pokemonPrompt();
            while (keyboard.hasNext()) {
                String command = keyboard.nextLine();
                game.playPokemonCommands(command);
                game.pokemonPrompt();
            }
        }
    }
}
