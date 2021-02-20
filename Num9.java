public class Num9 
{
    public static void main(String[] args)
    {
        System.out.println("formula(\"6 * 4 = 24\") -> " + formula("6 * 4 = 24"));
        System.out.println("formula(\"18 / 17 = 2\") -> " + formula("18 / 17 = 2"));
        System.out.println("formula(\"16 * 10 = 160 = 14 + 120\") -> " + formula("16 * 10 = 160 = 14 + 120"));
    }
    /** Simple thoughts - hard solutions.
     *  First, split into expressions relative to equality symbol.
     *  Second, each expression we need to count the 2 pos value, then we forming array of counted vals
     *  Third, we substract last of val from all vals in counted array; if all vals become zeros, then the formula is true
     */
    public static boolean formula(String str)
    {
        /** Split expressions over equality symbol */
        String[] relativeEqv = str.split("=");
        /** Number of expressions is equal to equality symbols */
        int numberOfExpressions = relativeEqv.length;
        /** Allocate array of expressions that splitted */
        String[][] expressions = new String[numberOfExpressions][];
        /** Array of values that is must be counted in each expressions */
        int[] vals = new int[numberOfExpressions];
        /** Split over space in every expression */
        for(int i = 0; i < relativeEqv.length; i++)
            expressions[i] = relativeEqv[i].split(" ");
        /** Handle every expression */
        for(int i = 0; i < numberOfExpressions; i++)
        {
            String[] expr = expressions[i];
            if(expr.length == 2) // equality
                vals[i] = Integer.parseInt(expr[1]);
            else
            {
                /** We can get the situation that we have a lot of spaces in begginig, if code below we skip them and get the index of first non-space String */
                int j = 0;
                for(; j < expr.length; j++) if(expr[j].equals("") == false) break;
                int a = Integer.parseInt(expr[j]);
                int b = Integer.parseInt(expr[j + 2]);
                char operation = expr[j + 1].charAt(0);

                /** Switch over all operation and count it */
                if(operation == '+')
                    vals[i] = a + b;
                else if(operation == '-')
                    vals[i] = a - b;
                else if(operation == '/')
                    vals[i] = a / b;
                else
                    vals[i] = a * b;
            }
        }
        /** Get last val in counted array */
        int val = vals[numberOfExpressions - 1];
        /** Decrease every val in counted arrray */
        for(int i = 0; i < vals.length; i++)
            vals[i] -= val;
        /** Check every val, if it is not zero, then the formula is false */
        for(int i = 0; i < vals.length; i++)
        {
            if(vals[i] != 0)
                return false;
        }
        return true;
    }
}