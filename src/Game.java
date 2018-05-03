import java.util.Random;
import java.util.Scanner;

public class Game
{
    private static Map currentLocation;
    private static Character mainChar;
    private static Map beginning = null;
    private static Map lounge = null;
    private static Map store = null;
    private static Map room309 = null;
    //private static Map room311 = null;
    //private static Map room317 = null;
    private static Map room325 = null;
    private static Scanner keyboard = new Scanner(System.in);
    private static Pokemon game = null;
    private static Random rand = new Random();


    public Game(Map startingLocation)
    {
        currentLocation = startingLocation;
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
            currentLocation = currentLocation.getNorth();
        }
        if (command.equalsIgnoreCase("West"))
        {
            currentLocation = currentLocation.getWest();
        }
        if (command.equalsIgnoreCase("East"))
        {
            currentLocation = currentLocation.getEast();
        }
        if (command.equalsIgnoreCase("South"))
        {
            currentLocation = currentLocation.getSouth();
        }
        if (command.equalsIgnoreCase("find"))
        {
            if (currentLocation.equals(lounge))
            {
                roomQuest(lounge);
            }
        }
        if (command.equalsIgnoreCase("solve"))
        {
            if (currentLocation.equals(room325))
            {
                roomQuest(room325);
            }
        }
        if (command.equalsIgnoreCase("stats"))
        {
            printStats();

        }
        if (command.equalsIgnoreCase("bag"))
        {
            System.out.println(mainChar.getInventory().toString());
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

            catch (NullPointerException e)
            {
                game = new Pokemon(mainChar);
                game.playPokemon();
                game.pokemonPrompt();
                while (keyboard.hasNext()) {
                    String command1 = keyboard.nextLine();
                    game.playPokemonCommands(command1);
                    game.pokemonPrompt();
                }
            }
        }
    }

    public static void namePrompt()
    {
        System.out.print("what's your name? > ");
        System.out.flush();
    } 
    public static void prompt()
    {
        System.out.print("command > ");
        System.out.flush();
    }
    public static void printStats()
    {
        System.out.println("Health: " + mainChar.getHealth());
        System.out.println("Coins: " + mainChar.getCoins());
        //System.out.println("Inventory: " + mainChar.getInventory());
    }

    public static void roomQuest(Map room)
    {
        if (room == lounge)
        {
            try
            {
                int i = rand.nextInt(11);
                if (i % 2 == 0)
                {
                    System.out.println("> You found a sword");
                    if (!mainChar.getInventory().contains("sword"))
                    {
                        mainChar.getInventory().addItems("sword");
                        System.out.println("> You have a sword in your inventory now");
                    }
                    else if (mainChar.getInventory().contains("sword"))
                    {
                        System.out.println("> You already have this item. Find something else");
                    }

                }
                else if (i % 3 == 0)
                {
                    System.out.println("> You found a hammer");
                    if (!mainChar.getInventory().contains("hammer"))
                    {
                        mainChar.getInventory().addItems("hammer");
                        System.out.println("> You have a hammer in your inventory now");
                    }
                    else if (mainChar.getInventory().contains("hammer"))
                    {
                        System.out.println("> You already have this item. Find something else");
                    }

                }
                else if (i % 4 == 0)
                {
                    System.out.println("> You found a bow and arrows");
                    if (!mainChar.getInventory().contains("bow and arrows"))
                    {
                        mainChar.getInventory().addItems("bow and arrows");
                        System.out.println("> You have a bow and arrows in your inventory now");
                    }
                    else if (mainChar.getInventory().contains("bow and arrows"))
                    {
                        System.out.println("> You already have this item. Find something else");
                    }

                }
                else
                {
                    System.out.println("> You found potion");
                    if (!mainChar.getInventory().contains("potion"))
                    {
                        mainChar.getInventory().addItems("potion");
                        System.out.println("> You have a potion in your inventory now. \n"
                            + "> It can restore 100% of your health");
                    }
                    else if (mainChar.getInventory().contains("potion"))
                    {
                        System.out.println("> You already have this item. \n> Find something else");
                    }

                }
                System.out.println("> You have [" + mainChar.getInventory().size() + "] item(s) in your bag." );
                System.out.println("> You can move on to the next room now.\n"
                    + "> Or you can stay to find more items");
            } 
            catch (NullPointerException a)
            {
                a.printStackTrace();
            }

        }
        if (room == room309)
        {
            Monster mon = new Monster(mainChar);
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
                    mon.run(mainChar.getInventory());
                }

                if (!mon.mAlive())
                {
                    System.out.println("> You have defeated the JAVA monster.");
                    System.out.println("> Move on to the next room!");
                    prompt();
                }
                else if (!command.equalsIgnoreCase("fight")
                    || !command.equalsIgnoreCase("heal")
                    || !command.equalsIgnoreCase("run"))
                {
                    mon.prompt();
                }
            }
        }
        if (room == store)
        {
            Store str = new Store();
            str.buyingPrompt();
            prompt();
            while (keyboard.hasNext())
            {
                String command = keyboard.nextLine();
                if (command.equalsIgnoreCase("potion"))
                {
                    str.buy("potion", mainChar);
                    printStats();
                    System.out.println(mainChar.getInventory().toString());
                }
                if (command.equalsIgnoreCase("sword"))
                {
                    str.buy("sword", mainChar);
                    printStats();
                    System.out.println(mainChar.getInventory().toString());
                }
                if (command.equalsIgnoreCase("hammer"))
                {
                    str.buy("hammer", mainChar);
                    printStats();
                    System.out.println(mainChar.getInventory().toString());
                }
                if (command.equalsIgnoreCase("bow and arrows"))
                {
                    str.buy("bow and arrows", mainChar);
                    printStats();
                    System.out.println(mainChar.getInventory().toString());
                }
                prompt();
            }
        }
        if (room == room325)
        {
            Puzzle puz = new Puzzle();
            String puzGen = puz.generatePuzzle();
            System.out.println("> Solve this to move on: " + puzGen);
            System.out.print("> Answer: ");
            while (keyboard.hasNext())
            {
                String ans = keyboard.nextLine();
                if (puz.check(puzGen, ans))
                {
                    System.out.println("> Good job! Move on to the next room");
                }
                else
                {
                    System.out.println("> Wrong! TRY AGAIN");
                    System.out.print("> Answer: ");
                }
            }
        }
        /*
            if (room == room311)
            {
                Monster tues = new Monster(mainChar);
                System.out.println("> You have encountered the ECLIPSE monster");
                tues.prompt();
                while(keyboard.hasNext())
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
                        tues.run(mainChar.getInventory());
                    }
                    else
                    {
                        tues.prompt();
                    }
                }
            }
        }
        if (room == room317)
        {
            Monster weds = new Monster(mainChar);
            //weds.play();
            System.out.println("> You have encountered the GO monster");
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
                        weds.run(mainChar.getInventory());
                        throw new Exception("> You cannot escape");
                    }
                    else
                    {
                        System.out.println("> Not a valid command");
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
            }*/


    }
    public static void main(String[] args)
    {


        beginning = new Map("WELCOME TO THE COMPUTER SCIENCE DEPARTMENT \n"
            + "--------------------------------------------------------------------- \n"
            + "> Every room (but the store) has some objectives you can do. \n"
            + "> You must complete these objectives before you \n> move on to the next room. \n"
            + "--------------------------------------------------------------------- ");
        lounge = new Map("> You are in the lounge,\n"
            + "> use the 'find' command to find items");
        store = new Map("> You have entered Chris Waldon's office"); //Room 313
        room309 = new Map("> You have entered Room 309. \n"
            + "> You must fight the JAVA monster to continue.");
        room325 = new Map("> You have entered Room 325");

        beginning.setNorth(lounge);
        lounge.setSouth(beginning);

        lounge.setEast(room309);
        room309.setWest(lounge);

        lounge.setNorth(store);
        store.setSouth(lounge);

        lounge.setWest(room325);
        room325.setEast(lounge);

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
            try {
                String command = keyboard.nextLine();
                g.handleCommand(command);
                if (!command.equalsIgnoreCase("exits")
                    && !command.equalsIgnoreCase("find")
                    && !command.equalsIgnoreCase("bag"))
                {
                    System.out.println(g.describe());
                }
                if (currentLocation == room309)
                {
                    roomQuest(room309);
                }
                if (currentLocation == store)
                {
                    roomQuest(store);
                }
                if (currentLocation == room325)
                {
                    roomQuest(room325);
                }

                prompt();
            }

            catch (NullPointerException f)
            {
                game = new Pokemon(mainChar);
                game.playPokemon();
                game.pokemonPrompt();
                while (keyboard.hasNext()) {
                    String command1 = keyboard.nextLine();
                    game.playPokemonCommands(command1);
                    game.pokemonPrompt();
                }
            }
        }
    }
}
