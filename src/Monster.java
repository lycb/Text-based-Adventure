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
    
    public void fight()
    {
        monsterHealth -= rand.nextInt(20);
        yourHealth -= rand.nextInt(20);
        
        if (monsterHealth > 0 && yourHealth > 0)
        {
            System.out.println("Monster's Health: " + monsterHealth);
            System.out.println("Your health: " + yourHealth);
        }
    }
    
}
