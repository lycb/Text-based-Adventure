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
    
    public boolean check(String bin)
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
        Random rand = new Random();
        int randomNum = rand.nextInt(16);
        String convert = randomNum + "";
        return binary.get(convert);
    }
    public String answer(String bin) 
    {
        String ans = "";
        switch(bin)
        {
            case "0000":
                ans = "0";
                break;
            case "0001":
                ans = "1";
                break;
            case "0010":
                ans = "2";
                break;
            case "0011":
                ans = "3";
                break;
            case "0100":
                ans = "4";
                break;
            case "0101":
                ans = "5";
                break;
            case "0110":
                ans = "6";
                break;
            case "0111":
                ans = "7";
                break;
            case "1000":
                ans = "8";
                break;
            case "1001":
                ans = "9";
                break;
            case "1010":
                ans = "10";
                break;
            case "1011":
                ans = "11";
                break;
            case "1100":
                ans = "12";
                break;
            case "1101":
                ans = "13";
                break;
            case "1110":
                ans = "14";
                break;
            case "1111":
                ans = "15";
                break;
            default:
                System.out.println("Not valid.");
        }
        return ans;
    }
}
