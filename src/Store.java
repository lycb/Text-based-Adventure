
public class Store
{
    Map store;
    public Store()
    {
        store = new Map("> Welcome to the store!");
    }

    public void buyingPrompt()
    {
        System.out.println("-----------------------------------------");
        System.out.println("> What would you like to buy?");
        System.out.println("> Available Items: ");
        System.out.println("> Potion: 200 coins || +100HP");
        System.out.println("> Sword: 200 coins");
        System.out.println("> Hammer: 200 coins");
        System.out.println("> Bow and Arrows: 200 coins");
        System.out.println("-----------------------------------------");
    }

    public void buy(String item, Character mainChar)
    {
        switch(item)
        {
            case "potion":
                if (mainChar.getHealth() < 100)
                {
                    mainChar.setHealth(mainChar.getHealth() + 100);
                    mainChar.setCoins(mainChar.getCoins() - 200);
                }
                else
                {
                    System.out.println("> full health.\n"
                        + "> cannot buy potion");
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
