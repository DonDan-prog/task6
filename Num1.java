public class Num1 
{
    public static void main(String[] args)
    {
        System.out.println("bell(1) -> " + bell(1));
        System.out.println("bell(2) -> " + bell(2));
        System.out.println("bell(3) -> " + bell(3));
    }
    /** Counting Bell's number using Pirc triangle */
    public static int bell(int n)
    {
        int[][] pirc = new int[n][n];

        int edge = 0;
        int number = 1;
        pirc[0][0] = number;
        for(int i = 1; i < n; i++)
        {
            pirc[i][0] = pirc[i-1][edge];
            for(int j = 0; j < i; j++)
                pirc[i][j + 1] = pirc[i][j] + pirc[i-1][j];
            edge++;
            number = pirc[i][edge];
        }
        return number;
    }
}