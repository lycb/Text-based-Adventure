import java.util.Random;
import java.util.Stack;
public class Puzzle
{
    private Stack<Integer> binary = null;
    public Puzzle()
    {
        binary = new Stack<Integer>();
        for (int i = 0; i < 16; i++)
        {
            binary.push(generatePuzzle());
        }
    }
    
    public boolean checkAnswer(int answer)
    {
        boolean result = false;
        //TODO check answer for the generate puzzle
        return result;
    }

    public Integer nextBinary()
    {
        return binary.pop();
    }

    public int generatePuzzle()
    {
        Random rand = new Random();
        int puzzleNum = 0;
        int randomNum = rand.nextInt(16);
        switch(randomNum)
        {
            case 0:
                puzzleNum = 0000;
                break;
            case 1:
                puzzleNum = 0001;
                break;
            case 2:
                puzzleNum = 0010;
                break;
            case 3:
                puzzleNum = 0011;
                break;
            case 4:
                puzzleNum = 0100;
                break;
            case 5:
                puzzleNum = 0101;
                break;
            case 6:
                puzzleNum = 0110;
                break;
            case 7:
                puzzleNum = 0111;
                break;
            case 8:
                puzzleNum = 1000;
                break;
            case 9:
                puzzleNum = 1001;
                break;
            case 10:
                puzzleNum = 1010;
                break;
            case 11:
                puzzleNum = 1011;
                break;
            case 12:
                puzzleNum = 1100;
                break;
            case 13:
                puzzleNum = 1101;
                break;
            case 14:
                puzzleNum = 1110;
                break;
            case 15:
                puzzleNum = 1111;
                break;
        }
        return puzzleNum;
    }
    public int answer(int bin) throws Exception
    {
        int ans = 0;
        switch(bin)
        {
            case 0000:
                ans = 0;
                break;
            case 0001:
                ans = 1;
                break;
            case 0010:
                ans = 2;
                break;
            case 0011:
                ans = 3;
                break;
            case 0100:
                ans = 4;
                break;
            case 0101:
                ans = 5;
                break;
            case 0110:
                ans = 6;
                break;
            case 0111:
                ans = 7;
                break;
            case 1000:
                ans = 8;
                break;
            case 1001:
                ans = 9;
                break;
            case 1010:
                ans = 10;
                break;
            case 1011:
                ans = 11;
                break;
            case 1100:
                ans = 12;
                break;
            case 1101:
                ans = 13;
                break;
            case 1110:
                ans = 14;
                break;
            case 1111:
                ans = 15;
                break;
            default:
                throw new Exception("not a valid puzzle");
        }
        return ans;
    }
}
