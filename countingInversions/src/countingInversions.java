import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class countingInversions
{
   public static int countMergeSort = 0;
   
   public static void main(String[] args){
       int[] array = readFromFile("unsortedArray.txt");
       long startTime = System.currentTimeMillis();
       int countBrute = countingInversionsBrute(array);
       long endTime = System.currentTimeMillis(); 
       int duration = Math.round(endTime - startTime);
       System.out.format("Brute force found %d inversions in this\n" +
                          " array of length %d in %d milliseconds\n",
                          countBrute,array.length,duration);
       startTime = System.currentTimeMillis();
       int[] sortedArray = countingInversionsMergeSort(array);
       endTime = System.currentTimeMillis(); 
       duration = Math.round(endTime - startTime);
       System.out.format("MergeSort method found %d inversions in this\n" +
                          " array of length %d in %d milliseconds\n",
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
    public static int[] countingInversionsMergeSort(int[] array){
        if(array.length <= 1){
            return array;
        }
        else if(array.length == 2){
            if(array[0]<array[1]){
                return array;
            }
            else{
                int dummy = array[0];
                array[0] = array[1];
                array[1] = dummy;
                countMergeSort++;
                return array;
            }
        }
        else{
            int arrayLength = array.length;
            int splitPoint = arrayLength/2;

            int[] left = countingInversionsMergeSort(Arrays.copyOfRange(array,0,splitPoint));            
            int[] right = countingInversionsMergeSort(Arrays.copyOfRange(array,splitPoint,arrayLength));

            int idx = 0;
            int leftIdx = 0;
            int rightIdx = 0;
            while(idx<arrayLength){
                if (left[leftIdx] <= right[rightIdx]) {
                    array[idx] = left[leftIdx];
                    leftIdx++;
                    if (leftIdx == left.length)
                        leftIdx--;
                } else {
                    array[idx] = right[rightIdx];
                    rightIdx++;
                    countMergeSort++;
                    if (rightIdx == right.length)
                        rightIdx--;
                }
                idx++;
            }
            return array;        
        }
    }
}
