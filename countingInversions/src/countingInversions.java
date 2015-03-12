import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class countingInversions
{
   public static void main(String[] args){
       //int[] array = new int[] {1,3};
       int[] array = readFromFile("unsortedArray.txt");
       long startTime = System.currentTimeMillis();
       int countBrute = countingInversionsBrute(array);
       long endTime = System.currentTimeMillis(); 
       int duration = Math.round(endTime - startTime);
       System.out.format("Brute force found %d inversions in this\n" +
                          " array of length %d in %d milliseconds",
                          countBrute,array.length,duration);
    }
    public static int countingInversionsBrute(int[] array)
    {
        int inversionCount = 0;
        for(int i = 0; i<array.length-1; i++)
            for(int j = i+1; j<array.length; j++)
                if(array[i] > array[j])
                    inversionCount++;
        return inversionCount;
    }
    public static int[] readFromFile(String filename)
    {
        int[] array = {};
        try
        {
            Scanner s = new Scanner(new File(filename));
            array = new int[20000];
            for (int i = 0; i < array.length; i++)
                array[i] = s.nextInt();
        }
        catch(FileNotFoundException filenotfoundexception)
        {
            System.out.println("File not found.");
        }
        return array;
    }
}
