public class MaxSum
{
    public static void main(String[] args)
    {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_ending_here[] = new int[size];
        int max = 0;
        if(a[0] > 0)
        {
            max_ending_here[0] = a[0];
        }
        else
        {
            max_ending_here[0] = 0;
        }

        for(int i = 1; i < size; i++)
        {
            max_ending_here[i] = max_ending_here[i - 1] + a[i];
            if((max_ending_here[i]) < 0)
            {
                max_ending_here[i] = 0;
            }
        }

        for(int i = 0; i < size; i++)
        {
            if(max_ending_here[i] > max)
            {
                max = max_ending_here[i];
            }
        }

        return max;
    }
}
