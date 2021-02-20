public class Num3 
{
    public static void main(String[] args)
    {
        System.out.println("validColor(\"rgb(0,0,0)\") -> " + validColor("rgb(0,0,0)"));
        System.out.println("validColor(\"rgb(0,,0)\") -> " + validColor("rgb(0,,0)"));
        System.out.println("validColor(\"rgb(255,256,255)\") -> " + validColor("rgb(255,256,255)"));
        System.out.println("validColor(\"rgba(0,0,0,0.123456789)\") -> " + validColor("rgba(0,0,0,0.123456789)"));
    }

    public static boolean validColor(String str)
    {
        /** Check for valid prefix */
        int pos = str.indexOf("rgb");
        if(pos == -1) return false;

        /** Check for bracketness */
        boolean isRgba = (str.charAt(pos + 1) == 'a');
        int args = 3 + (isRgba ? 1 : 0);    // for rgb - 3 args, rgba - 4 args
        int bracketStart = str.indexOf('(');
        int bracketEnd = str.indexOf(')');
        if(bracketStart == -1 || bracketEnd == -1) return false;

        /** Check for colors len */
        String[] colorsString = str.substring(bracketStart + 1, bracketEnd).split(",");
        if(colorsString.length != args) return false;

        /** Check for have argument in each string */
        for(String s : colorsString) if(s.equals("")) return false;

        /** Parse all colors and checks them */
        int r = Integer.parseInt(colorsString[0]);
        int g = Integer.parseInt(colorsString[1]);
        int b = Integer.parseInt(colorsString[2]);

        if(r < 0 || r > 255) return false;
        if(g < 0 || g > 255) return false;
        if(b < 0 || b > 255) return false;

        /** If entered alpha-channel, we check it too */
        if(isRgba)
        {
            double a = Double.parseDouble(colorsString[3]);
            if(a < 0 || a > 1) return false;
        }
        return true;
    }
}