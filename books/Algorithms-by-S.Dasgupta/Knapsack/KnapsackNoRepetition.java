public class KnapsackNoRepetition
{
    static int maxValue(int[] weights, int[] values, int capacity)
    {
        int size = weights.length;
        int[][] totalValue = new int[capacity + 1][size + 1];
        for(int i = 0; i <= capacity; i++)
        {
            for(int j = 0; j <= size; j++)
            {
                totalValue[i][j] = 0;
            }
        }

        for(int currCapacity = 1; currCapacity <= capacity; currCapacity++ )
        {
            for(int item = 1; item <= size; item++)
            {
                int value1 = totalValue[currCapacity][item - 1];
                int value2 = 0;
                if(currCapacity >= weights[item - 1])
                {
                    value2 = totalValue[currCapacity - weights[item - 1]][item - 1] + values[item -1];
                }
                totalValue[currCapacity][item] = maxInt(value1, value2);
            }
        }

        return totalValue[capacity][size];
    }

    static int maxInt(int v1, int v2)
    {
        if(v1 > v2)
        {
            return v1;
        }
        else
        {
            return v2;
        }
    }
    public static void main(String[] args)
    {
        int[] weights = {6, 3, 4, 2};
        int[] values = {30, 14, 16, 9};
        int capacity = 10;

        System.out.println("" + maxValue(weights, values, capacity));
    }
}
