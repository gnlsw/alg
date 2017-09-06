// Java program for implementation of Bubble Sort
class BubbleSort
{
    void bubbleSort(int[] arr)
    {
        int n = arr.length;
        System.out.println("---unsorted array---");
        printArray(arr);
        System.out.println("---unsorted array---");
        for(int i = 0; i < n -1; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j + 1]
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                printArray(arr);
            }
            System.out.println("---one trace---");
            printArray(arr);
            System.out.println("---one trace---");
        }
    }

    void printArray(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}