import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
       int[] array = readFromFile("unsortedArray.txt");
       //int[] array = {3,4,5,0,1,2,6};
       long startTime = System.currentTimeMillis();
       int[] sortedArray = mergeSort(array);
       long endTime = System.currentTimeMillis();
       int duration = Math.round(endTime-startTime);
       System.out.format("mergeSort sorted an array of length %d " +
               "in %d milliseconds\n", array.length, duration);
    }
    public static int[] mergeSort(int[] array){
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
                return array;
            }
        }
        else{
            int arrayLength = array.length;
            int splitPoint = arrayLength/2;

            int[] left = mergeSort(Arrays.copyOfRange(array,0,splitPoint));            
            int[] right = mergeSort(Arrays.copyOfRange(array,splitPoint,arrayLength));

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
                    if (rightIdx == right.length)
                        rightIdx--;
                }
                idx++;
            }
            return array;        
        }
    }
    public static int[] readFromFile(String filename)
    {
        int[] array = {};
        try
        {
            Scanner s = new Scanner(new File(filename));
            array = new int[99000];
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
