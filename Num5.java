import java.util.Arrays;

public class Num5 
{
    public static void main(String[] args)
    {
        System.out.println("getHashTags(\"How the Avocado Became the Fruit of the Global Trade\") -> " + Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("getHashTags(\"Why You Will Probably Pay More for Your Christmas Tree This Year\") -> " + Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println("getHashTags(\"Hey Parents, Surprise, Fruit Juice Is Not Fruit\") -> " + Arrays.toString(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println("getHashTags(\"Visualizing Science\") -> " + Arrays.toString(getHashTags("Visualizing Science")));
    }
    public static String[] getHashTags(String string)
    {
        /** Replace needed symbols to empty place */
        string = string.replaceAll("[.,?!]", ""); 
        /** Because of replaced, we can simply split into words */
        String[] words = string.split(" ");
        String[] tagsArray = null;
        /** Handle words length; if length is 0, we not enter to if's at all and return null */
        if(words.length == 1)  // if have just one word
        {
            tagsArray = new String[1];
            tagsArray[0] = "#" + words[0].toLowerCase();
        }
        else if(words.length == 2)  // if have two words
        {
            tagsArray = new String[2];
            int minPos = (words[0].length() > words[1].length() ? 1 : 0);
            int maxPos = (words[0].length() > words[1].length() ? 0 : 1);
            tagsArray[0] = "#" + words[maxPos].toLowerCase();
            tagsArray[1] = "#" + words[minPos].toLowerCase();
        }
        else    // if words 3 or more
        {   
            tagsArray = new String[3];
            int tagsCount = 0; // iterator for tagsArray
            for(int i = 0; i < 3; i++)
            {
                /** First, search for max length in words */
                int maxPos = 0;
                int maxLen = 0;
                for(int j = 0; j < words.length; j++)
                {
                    int len = words[j].length();
                    if(len > maxLen)
                    {
                        maxLen = len;
                        maxPos = j;
                    }
                }
                /** Add to tagArray, then clear finded largest word */
                tagsArray[tagsCount] = ("#" + words[maxPos]).toLowerCase();
                tagsCount++;
                words[maxPos] = "";
            }
        }
        return tagsArray;
    }
}
