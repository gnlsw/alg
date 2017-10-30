import java.lang.*;
import java.util.*;
import java.math.*;

public class ArrayStain {
    public static void main(String[] args) {
        if(args.length != 1)
        {
            System.out.println("please input a decimal");
            return;
        }

        int var;
        try
        {
            var = Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e)
        {
            System.out.println(args[0] + "is not number.");
            return;
        }

        induction(var);
        
        // calc();

        exhaust(var);
    }

    private static void calc() {
        String element_1 = "R";
        String element_2 = "G";
        String element_3 = "B";
        String[] elements = {element_1, element_2, element_3};

        ArrayList<String> result_1 = new ArrayList<String>();
        result_1.add("R");
        result_1.add("G");
        result_1.add("B");

        List<String> result_2 = new ArrayList<>();
        int count = 0;
        for (int index = 0; index < result_1.size(); index++) 
        {
            for (int element_index = 0; element_index < elements.length; element_index++) 
            {
                String item = result_1.get(index) + elements[element_index];
                boolean result = judge(item);
                System.out.println(item + " " + result);
                result_2.add(item);
                if (true == result) 
                {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);

        List<String> result_3 = new ArrayList<>();
        count = 0;
        for (int index = 0; index < result_2.size(); index++) 
        {
            for (int element_index = 0; element_index < elements.length; element_index++) 
            {
                String item = result_2.get(index) + elements[element_index];
                boolean result = judge(item);
                System.out.println(item + " " + result);
                result_3.add(item);
                if (true == result) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);

        List<String> result_4 = new ArrayList<>();
        count = 0;
        for (int index = 0; index < result_3.size(); index++) {
            for (int element_index = 0; element_index < elements.length; element_index++) {
                String item = result_3.get(index) + elements[element_index];
                boolean result = judge(item);
                System.out.println(item + " " + result);
                result_4.add(item);
                if (true == result) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static boolean judge(String item) {
        if (0 == item.length()) {
            return false;
        }

        if (1 == item.length()) {
            return true;
        }

        /* 检查相邻字符是否相同，如果相同，返回0 */
        for (int pos = 0; pos < item.length() - 1; pos++) {
            if (item.charAt(pos) == item.charAt(pos + 1)) {
                return false;
            }
        }

        /* 检查首尾字符是否相同，如果相同，返回0 */
        if (item.charAt(0) == item.charAt(item.length() - 1)) {
            return false;
        }

        return true;
    }

    private static void induction(int n)
    {
        if(0 >= n)
        {
            System.out.println(0 + " ways to color.");
        }
        if(1 == n)
        {
            System.out.println(3 + " ways to color.");
        }
        if(2 == n)
        {
            System.out.println(6 + " ways to color.");
        }
        if(3 == n)
        {
            System.out.println(6 + " ways to color.");
        }

        BigInteger a = BigInteger.valueOf(6); // for var = 2
        BigInteger b = BigInteger.valueOf(6); // for var = 3
        BigInteger c = BigInteger.valueOf(0); // c = 2 * a + b
        BigInteger m = BigInteger.valueOf(2);

        int count = 4;
        while(count <= n)
        {
            c = (a.multiply(m)).add(b);
            a = b;
            b = c;
            count++;
        }
        System.out.println(c + " ways to color.");
    }

    public static void exhaust(int var)
    {
        String[] elements = {"R", "G", "B"};
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        // n = 0
        ArrayList<String> list_0 = new ArrayList<>();
        list.add(list_0);

        // n = 1
        ArrayList<String> list_1 = new ArrayList<String>();
        for(int index = 0; index < elements.length; index++)
        {
            list_1.add(elements[index]);
        }
        list.add(list_1);

        for(int n = 2; n <= var; n++)
        {
            ArrayList<String> prev_result = list.get(n - 1);
            ArrayList<String> next_result = new ArrayList<String>();
            int count = 0;
            for(int i = 0; i < prev_result.size(); i++)
            {
                String item = prev_result.get(i);
                for(int j = 0; j < elements.length; j++)
                {
                    String new_item = item + elements[j];
                    boolean result = judge(new_item);
                    if (true == result)
                    {
                        count++;
                        System.out.println(new_item + " " + result);
                    }
                    next_result.add(new_item);
                }
            }
            System.out.println("n = " + n + " , count = " + count);
            list.add(next_result);
        }
    }
}
