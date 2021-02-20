import java.util.regex.*;

public class Num2 
{
    public static void main(String[] args)
    {
        System.out.println("translateWord(\"flag\") -> " + translateWord("flag"));
        System.out.println("translateWord(\"Apple\") -> " + translateWord("Apple"));
        System.out.println("translateWord(\"button\") -> " + translateWord("button"));
        System.out.println("translateWord(\"\") -> " + translateWord(""));
        System.out.println("translateSentence(\"I like, to eat honey waffles.\") -> " + translateSentence("I like, to eat honey waffles."));
        System.out.println("translateSentence(\"Do you think it, is going to rain today?\") -> " + translateSentence("Do you think it, is going to rain today?"));
    }

    /** Translate word or sentence */
    public static String translateSentence(String string)
    {   
        /** Regex expression for index all choosed characters */
        final Pattern regexString = Pattern.compile("[A-Za-z]+|[ .,?]");
        int pos = 0; // used for iterative find
        Matcher matcher = regexString.matcher(string);
        String ret = "";
        while(matcher.find(pos) == true) // while we found somthing according to regex
        {
            /** Extract founded string, translate it and move position to end of founded string */
            String matchedString = string.substring(matcher.start(), matcher.end());
            ret += translateWord(matchedString);
            pos = matcher.end();
        }
        return ret;
    }
    public static String translateWord(String string)
    {
        /** There's a trick: commas, spaces and other symbols are been processed too, but not translating
         *  and just added to return string
        */
        /** Constant strings for separating characters */
        final String vowelsString = "AEIOUYaeiouy";
        final String consonantString = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";

        /** If we give empty string we must return empty string */
        if(string.equals("") == true) return "";

        String ret = "";
        /** Getting the first char because we need to know from what it starts */
        char firstChar = string.charAt(0);
        /** To keeping track is it starts from upper case */
        boolean isStartCapital = Character.isUpperCase(firstChar);
        /** convert word to lower */
        string = string.toLowerCase();
        if(vowelsString.indexOf(firstChar) != -1)
            string = startVowel(string, vowelsString);  // call this func if word start from vowel
        else if(consonantString.indexOf(firstChar) != -1)
            string = startConsonant(string, consonantString); // call this func otherwise
        if(isStartCapital)  // if word started from capital, we need a translated to be started from capital too
            string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
        ret += string;  // add a translated word to return string
        return ret;
    }
    /** If word starts with vowelcall this function */
    private static String startVowel(String str, final String vowelsString)
    {
        return str + "yay";
    }
    /** If word not starts with vowelcall this function */
    private static String startConsonant(String str, final String consonantString)
    {

        String begin = "";
        int i = 0;
        for(; i < str.length() && consonantString.indexOf(str.charAt(i)) != -1; i++) begin += str.charAt(i);
        return str.substring(i) + begin + "ay";
    }
}