
public class Store
{
    Map store;
    String[] listOfItems = {"potion", "sword", "hammer", "bow and arrow", "armor"};
    String[] identities = {"Chris Waldon", "Joel Swanson"};
    public Store()
    {
        store = new Map("Welcome to Chris Waldon's Office");
    }

    public void buyingPrompt()
    {
        System.out.println("-----------------------------------------");
        System.out.println("What would you like to buy?");
        System.out.println("Available Items: ");
        System.out.println("Potion: 200 coins || +100HP");
        System.out.println("Sword: 200 coins");
        System.out.println("Hammer: 200 coins");
        System.out.println("Bow and Arrow: 200 coins");
        System.out.println("-----------------------------------------");
    }

    public void buy(String item, Character mainChar)
    {
        switch(item)
        {
            case "potion":
                if (mainChar.getHealth() < 100)
                {
                    mainChar.setHealth(mainChar.getHealth() + 25);
                    mainChar.setCoins(mainChar.getCoins() - 100);
                }
                else
                {
                    System.out.println("full health");
                    mainChar.setCoins(mainChar.getCoins() - 100);
                }
                break;
            case "sword":
                mainChar.getInventory().addItems("sword");
                mainChar.setCoins(mainChar.getCoins() - 200);
                break;
            case "hammer":
                mainChar.getInventory().addItems("hammer");
                mainChar.setCoins(mainChar.getCoins() - 200);
                break;
            case "bow and arrow":
                mainChar.getInventory().addItems("bow and arrow");
                mainChar.setCoins(mainChar.getCoins() - 200);
                break;
            default:
                System.out.println("Items are not in store!!!!");
                break;
        }
    }
}
