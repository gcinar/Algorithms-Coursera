public class countingInversionsBrute
{
   public static void main(String[] args){
       int[] array = new int[] {1,3};   
       System.out.println(countingInversionsBrute(array));
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
}
