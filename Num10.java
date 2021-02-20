public class Num10 
{
    public static void main(String[] args)
    {
        System.out.println("palindromedescendant(11211230) -> " + palindromedescendant(11211230));
        System.out.println("palindromedescendant(13001120) -> " + palindromedescendant(13001120));
        System.out.println("palindromedescendant(23336014) -> " + palindromedescendant(23336014));
        System.out.println("palindromedescendant(11) -> " + palindromedescendant(11));
    }
    public static boolean palindromedescendant(long n)
    {
        String nString = Long.toString(n);
        /** If out number have 2 digits */
        if(nString.length() == 2 && nString.charAt(0) == nString.charAt(1)) return true;
        /** Next, get the boolean if it's palindrome */
        boolean isPalindrome = nString.equals(reverseString(nString));
        if(isPalindrome) return true;
        else
        {
            /** Storing the power of 10 of new long*/
            int pow10 = 1;
            long newLong = 0;
            /** Iterate from end to top, getting the digits of n, combine them and add with correct power to new long
             *  It's work in pairs, so iterator will decrease i by 2, decrease because we iterate from the end of n
             */
            for(int i = nString.length() - 1; i > 0; i-=2)
            {
                int a = nString.charAt(i - 1) - '0';
                int b = nString.charAt(i) - '0';
                newLong += (a + b) * pow10;
                pow10 *= 10;
            }
            return palindromedescendant(newLong);
        }
    }
    private static String reverseString(String s)
    {
        String ret = "";
        for(int i = s.length() - 1; i >= 0; --i)
            ret += s.charAt(i);
        return ret;
    }
}