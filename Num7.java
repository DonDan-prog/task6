public class Num7 
{
    public static void main(String[] args)
    {
        System.out.println("longestNonrepeatingSubstring(\"abcabcbb\") -> " + longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("longestNonrepeatingSubstring(\"aaaaaa\") -> " + longestNonrepeatingSubstring("aaaaaa"));
        System.out.println("longestNonrepeatingSubstring(\"abcde\") -> " + longestNonrepeatingSubstring("abcde"));
        System.out.println("longestNonrepeatingSubstring(\"abcda\") -> " + longestNonrepeatingSubstring("abcda"));
    }
    /** Algorithm, which works for O(n) for speed and O(n + m) where m is alphabet of input */
    public static String longestNonrepeatingSubstring(String str)
    {
        /** The constant of unique symbols using in input (alphabet, so called) */
        final int ALPHABET_COUNT = 256;
        /** Array of visited characters; set to 0 as not vsisited; operates only 1 and 0, so byte will reduce the memory */
        byte[] visited = new byte[ALPHABET_COUNT];
        for(int i = 0; i < ALPHABET_COUNT; i++) visited[i] = 0;
        /** Inital values for start position of another subseq,
         *  end of another subseq, start of longest and
         *  actually length of of non repeated subseq
         */
        int start = 0;
        int end = 0;
        int bestStart = 0;
        int best = 0;
        /** Iterate over all string */
        while(end < str.length())
        {
            /** If the last symbol is visited, then we need to unvisit all symbols before end */
            while(visited[str.charAt(end)] == 1)
            {
                start++;
                visited[str.charAt(start)] = 0;
            }
            /** Visit the end symbol, as we already visit it */
            visited[str.charAt(end)] = 1;
            /** If length of finded subseq is greater than best, then save the values of this subseq */
            /** Important note: we need to increment end to get the length correctly and it forces while loop to continue be iteratable */
            end++;
            if(end - start > best)
            {
                bestStart = start;
                best = end - start;
            }
        }
        return str.substring(bestStart, bestStart + best);
    }
}