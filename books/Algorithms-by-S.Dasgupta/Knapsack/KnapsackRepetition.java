public class KnapsackRepetition
{
    static int maxValue(int[] weight, int[] values, int capacity)
    {
        int[] total = new int[capacity + 1];

        total[0] = 0;

        for(int currWeight = 1; currWeight <= capacity; currWeight++)
        {
            int max = 0;
            int tmpSumValue = 0;
            for(int j = 0; j < weight.length; j++)
            {
                if(currWeight >= weight[j])
                {
                    tmpSumValue = total[currWeight - weight[j]] + values[j];
                    max = max > tmpSumValue ? max : tmpSumValue;
                }
            }
            total[currWeight] = max;
        }

        return total[capacity];
    }

    public static void main(String args[])
    {
        int[] weight = {6, 3, 4, 2};
        int[] value = {30, 14, 16, 9};
        int capacity = 10;

        System.out.println("The maximum value of items is " + maxValue(weight, value, capacity));
    }
}
