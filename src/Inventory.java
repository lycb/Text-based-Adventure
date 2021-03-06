
public class Inventory
{
    private String[] items;
    private static int currentItems = 0;

    public Inventory()
    {
        items = new String[4];
    }

    public void addItems(String thing)
    {
        if (currentItems > 4)
        {
            System.out.println("> Inventory is FULL");
        }
        items[currentItems++] = thing;
    }

    public int size()
    {
        return currentItems;
    }

    public void useItems(String thing)
    {
        int selectedItem = 0;
        int temp = 0;
        if (!empty())
        {
            for (int k = 0; k < currentItems; k++)
            {
                if (items[k].equals(thing))
                {
                    selectedItem = k;
                    for (int i = selectedItem; i < currentItems - 1; i++)
                    {
                        temp = selectedItem;
                        if (selectedItem < currentItems - 1) 
                        {
                            items[i] = items[i + 1];
                        }
                    }
                    if (selectedItem != currentItems)
                    {
                        selectedItem = temp;
                    }
                    //return items[selectedItem];
                }
            }
            currentItems--;
        }
        else
        {
            System.out.println("Cannot find items!");
        }
    }

    public boolean contains(String item)
    {
        if (!empty())
        {
            for (int i = 0; i < items.length; i++)
            {
                if (item == null || items[i] == null)
                {
                    continue;
                }
                if (item.equalsIgnoreCase(items[i]))
                {
                    return true;
                }      
            }
        }
        return false;
    }

    public boolean empty()
    {
        if (currentItems == 0)
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        String list = "\n";
        if (!empty())
        {
            for (int i = 0; i < items.length; i++)
            {
                if (items[i] != null)
                {
                    list += items[i] + "\n";
                }
                else
                {
                    list += "[ ]\n";
                }
            }
        }
        else
        {
            list += "Nothing to show in Inventory!";
        }
        return list;
    }
}
