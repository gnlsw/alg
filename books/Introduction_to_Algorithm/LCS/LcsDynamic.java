public class LcsDynamic
{
    public static void printLcs(String[][] b, String X, int xLen, int yLen)
    {
        if((xLen == 0) || (yLen == 0))
        {
            return;
        }

        if(b[xLen][yLen] == "dia")
        {
            printLcs(b, X, xLen - 1, yLen -1);
            System.out.println(X.charAt(xLen - 1));
        }
        else if (b[xLen][yLen] == "up")
        {
            printLcs(b, X, xLen - 1, yLen);
        }
        else if(b[xLen][yLen] == "left")
        {
            printLcs(b, X, xLen, yLen - 1);
        }
        else
        {
            System.out.print("unkown case");
        }
    }
    public static void main(String[] args)
    {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        int xLen = X.length();
        int yLen = Y.length();

        String[][] b = new String[xLen + 1][yLen + 1];
        int[][] c = new int[xLen + 1][yLen + 1];

        for(int j = 0; j <= yLen; j++)
        {
            c[0][j] = 0;
            b[0][j] = "";
         }

        for(int i = 0; i <= xLen; i++)
        {
            c[i][0] = 0;
            b[i][0] = "";
        }

        for(int i = 1; i <= xLen; i++)
        {
            for(int j = 1; j <= yLen; j++)
            {
                if(X.charAt(i - 1) == Y.charAt(j - 1))
                {
                    c[i][j] = 1 + c[i-1][j-1];
                    b[i][j] = "dia";
                }
                else
                {
                    if(c[i-1][j] >= c[i][j-1])
                    {
                        c[i][j] = c[i-1][j];
                        b[i][j] = "up";
                     }
                    else
                    {
                        c[i][j] = c[i][j-1];
                        b[i][j] = "left";
                    }
                }
            }
        }

        printLcs(b, X, xLen, yLen);

        

        System.out.println("lcs is " + c[xLen][yLen]);
    }
}