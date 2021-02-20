import java.util.HashMap;

public class Num4 
{
    public static void main(String[] args)
    {
        String[] a = { "b" };
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", a));
        System.out.println(stripUrlParams("https://edabit.com", a));
    }
    private static HashMap<String, String> parseParams(String paramsString)
    {
        /** Making set of parameters to make new unique link */
        String[] params = paramsString.split("&");
        HashMap<String, String> newParams = new HashMap<String, String>();
        for(String param : params)
        {
            int valSeparatorInteger = param.indexOf('=');
            String name = param.substring(0, valSeparatorInteger);
            String arg = param.substring(valSeparatorInteger + 1);
            newParams.put(name, arg);
        }
        return newParams;
    }
    public static String stripUrlParams(String str)
    {
        /** Extract url from str */
        int argSeparatorInteger = str.indexOf('?');
        String urlString = str.substring(0, argSeparatorInteger);
        String paramsString = str.substring(urlString.length() + 1);  // get rest of the string

        /** Make HashMap of params */
        HashMap<String, String> paramsMap = parseParams(paramsString);

        /** Create new link */
        String ret = new String(urlString);
        if(paramsMap.size() == 0) return ret;
        ret += '?';
        Object[] keyArray = (paramsMap.keySet().toArray());
        for(int i = 0; i < keyArray.length; i++)
        {
            ret += keyArray[i];
            ret += '=';
            ret += paramsMap.get(keyArray[i]);
            if(i + 1 < keyArray.length)
                ret += '&';
        }
        return ret;
    }
    public static String stripUrlParams(String str, String[] args)
    {
        /** Extract url from str */
        int argSeparatorInteger = str.indexOf('?');
        if(argSeparatorInteger == -1) return str;
        String urlString = str.substring(0, argSeparatorInteger);
        String paramsString = str.substring(urlString.length() + 1);  // get rest of the string

        /** Make HashMap of params */
        HashMap<String, String> paramsMap = parseParams(paramsString);

        /** Clear not needed params */
        HashMap<String, String> newHashMap = new HashMap<>();
        for(String key : paramsMap.keySet())
        {
            boolean finded = false;
            for(int j = 0; j < args.length; j++)
            {
                if(key.equals(args[j]))
                {
                    finded = true;
                    break;
                }
            }
            if(finded == false)
                newHashMap.put(key, paramsMap.get(key));
        }

        /** Create new link */
        String ret = new String(urlString);
        if(newHashMap.size() == 0) return ret;
        ret += '?';
        Object[] keyArray = (newHashMap.keySet().toArray());
        for(int i = 0; i < keyArray.length; i++)
        {
            ret += keyArray[i];
            ret += '=';
            ret += newHashMap.get(keyArray[i]);
            if(i + 1 < keyArray.length)
                ret += '&';
        }
        return ret;
    }
}