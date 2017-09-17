import java.lang.String;

public class LcsRecursive
{
    public static int lcs(String X, String Y, int xLen, int yLen)
    {
        if((xLen == 0) || (yLen == 0))
        {
            return 0;
        }
        if(X.charAt(xLen - 1) == Y.charAt(yLen -1))
        {
            return 1 + lcs(X, Y, xLen - 1, yLen -1);
        }
        else
        {
            int xLcs = lcs(X, Y, xLen - 1, yLen);
            int yLcs = lcs(X, Y, xLen, yLen -1);
            return (xLcs >= yLcs ? xLcs : yLcs);
        }
    }
    public static void main(String[] args)
    {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        int len = lcs(X, Y, X.length(), Y.length());

        System.out.println("lcs is " + len);
    }
}
