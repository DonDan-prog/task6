public class Num8
{
    public static void main(String[] args)
    {
        System.out.println("convertToRoman(2) -> " + convertToRoman(2));
        System.out.println("convertToRoman(12) -> " + convertToRoman(12));
        System.out.println("convertToRoman(16) -> " + convertToRoman(16));
    }
    public static String convertToRoman(int n)
    {
        if(n > 3999) return "Invalid input";

        /** Constants to rome numbers */
        final String ONE = "I";
        final String FIVE = "V";
        final String TEN = "X";
        final String FIFTY = "L";
        final String HUNDRED = "C";
        final String FHUNDRED = "D";
        final String THOUSAND = "M";

        /** Digits of the number; we can convert them independetly and then concatenate converted */
        int thousandsAmount = n / 1000;
        int hundredsAmount = n / 100 % 10;
        int tensAmount = n / 10 % 10;
        int digitsAmount = n % 10;

        /** Return the concatenated digits of the number */
        return convertDigit(thousandsAmount, THOUSAND, "", "") 
        + convertDigit(hundredsAmount, HUNDRED, FHUNDRED, THOUSAND) 
        + convertDigit(tensAmount, TEN, FIFTY, HUNDRED) 
        + convertDigit(digitsAmount, ONE, FIVE, TEN);
    }

    /** Simple func to convert one digit of the number based on the current, next and next next number in Rome notation */
    private static String convertDigit(int n, final String current, final String next, final String overNext)
    {
        String ret = "";
        if(n == 1) ret += current;
        else if(n > 1 && n < 4)
        {
            for(int i = 0; i < n; i++)
                ret += current;
        }
        else if(n == 4) ret += next + current;
        else if(n > 4 && n < 9)
        {
            ret += next;
            for(int i = 5; i < n; i++)
                ret += current;
        }
        else if(n == 9) ret += current + overNext;
        return ret;
    }
}