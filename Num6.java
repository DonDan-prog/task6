public class Num6
{
    public static void main(String[] args)
    {
        System.out.println("ulam(4) -> " + ulam(4));
        System.out.println("ulam(9) -> " + ulam(9));
        System.out.println("ulam(206) -> " + ulam(206));
    }
    public static int ulam(int n)
    {
        /** Special cases, because we allocate only n and there's no reason to not return this 
         *  because first and second values is intial values for Ulam sequance
        */
        if(n == 1) return 1;
        if(n == 2) return 2;
        /** Allocate array that contain all neccesary data */
        int[] ulam = new int[n];
        int size = 2; // var to control the size of imaginary dynamical array that over static
        ulam[0] = 1;  // initial values for Ulam
        ulam[1] = 2;
        /** This countings is based on that minimal sum in any iteration is equal to number of this iteration */
        for (int i = 3; size < n; i++) 
        {
            /** z is an amount of occurances of current sum */
            int z = 0;
            /** we iterate over ulam twice and sum all of numbers
             *  such that this value is greater than previous and sum of them
             *  and sum of them is equal to current iteration
             */
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++) 
                {
                    if (ulam[j] < ulam[k] && ulam[j] + ulam[k] == i)
                        z++;
                }
            }
            /** If count of occurances is equal to 1, that means we have only one way to get this number */
            /** So, add this number to array and increase the size */
            if (z == 1)
            {
                ulam[size] = i;
                size++;
            }  
        }
        /** return the last item */
        return ulam[size - 1];
    }
}