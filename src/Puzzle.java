import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
public class Puzzle
{
    //HashMap, getKeySet collection of keys, randomize order of the keyset (put in array or arraylist then randomize order)
    private HashMap<String, String> binary = null;
    public Puzzle()
    {
        binary = new HashMap<String, String>(16);
        binary.put("0000", "0");
        binary.put("0001", "1");
        binary.put("0010", "2");
        binary.put("0011", "3");
        binary.put("0100", "4");
        binary.put("0101", "5");
        binary.put("0110", "6");
        binary.put("0111", "7");
        binary.put("1000", "8");
        binary.put("1001", "9");
        binary.put("1010", "10");
        binary.put("1011", "11");
        binary.put("1100", "12");
        binary.put("1101", "13");
        binary.put("1110", "14");
        binary.put("1111", "15");      
    }
    
    public boolean check(String puz, String bin)
    {
        boolean correct = false;
        if (binary.containsKey(bin))
        {
            if (binary.get(bin).equals(answer(bin)))
            {
                correct = true;
            }
        }
        else
        {
            correct = false;
        }
        return correct;
    }

    public String generatePuzzle()
    {
        //Random rand = new Random();
        //int randomNum = rand.nextInt(15);
        //String convert = randomNum + "";
        if (binary.get(15) != null)
        {
            return binary.get(15);
        }
        return "0000";
    }
    public String answer(String bin) 
    {
        String ans = "";
        switch(bin)
        {
            case "0":
                ans = "0000";
                break;
            case "1":
                ans = "0001";
                break;
            case "2":
                ans = "0010";
                break;
            case "3":
                ans = "0011";
                break;
            case "4":
                ans = "0100";
                break;
            case "5":
                ans = "0101";
                break;
            case "6":
                ans = "0110";
                break;
            case "7":
                ans = "0111";
                break;
            case "8":
                ans = "1000";
                break;
            case "9":
                ans = "1001";
                break;
            case "10":
                ans = "1010";
                break;
            case "11":
                ans = "1011";
                break;
            case "12":
                ans = "1100";
                break;
            case "13":
                ans = "1101";
                break;
            case "14":
                ans = "1110";
                break;
            case "15":
                ans = "1111";
                break;
            default:
                System.out.println("Not valid.");
        }
        return ans;
    }
}
