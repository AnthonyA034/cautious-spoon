/*
 *Anthony Abello PID:6046807   U02 
 */
package assignment_3;

import java.util.Random;

/**
 *
 * both of the following methods are as given in class.
 */
public class SearchingAlgorithms {
        static boolean binarySearch(int[] list, int x){
        int end, beg, pivot;
        beg = 0;
        end = list.length -1;
        boolean found = false;
        while(beg <= end && !found){
            pivot = (end + beg)/2;
            if(list[pivot] == x) found = true;
            else
                if(x<list[pivot]) end = pivot -1;
                else beg = pivot +1;
    }
        return found;
}
            static boolean seqSearch(int[] list, int x){
        boolean found = false;
        for(int i =0; i<list.length -1; i++){
        if(list[i] == x){
            found = true; 
            break;
        }
    }
        return found;
    }
            static boolean sortSearch(int[] list, int x){
                boolean found = false;
                int i = 0;
                while( i<list.length -1 && list[i]<x) i++;
                if( i< list.length - 1 && list[i] == x)
                found = true;
                else found = false; 
                return found;
            }
        public static void fillArray(int[] list)
    {
        Random rnd = new Random();
        for(int i = 0; i< list.length-1; i++){
            list[i] = rnd.nextInt();
        }
    }
public static void printArray(int[] list)
    {
        System.out.println("\nThe Array is ");
        for(int i = 0; i<list.length-1; i++){
            System.out.print("\n" + list[i] + " ");
        }
    }
     
    
     /**
     * methods given along with assignment 3
     * Recursive quickSort algorithm
     * @author Prof. A. Hernandez
     */
    public static void quickSort(int[] list)
    {
        quicksort(list, 0, list.length - 1);
    }

    private static void quicksort(int[] list, int begin, int end)
    {
        int temp;
        int pivot = findPivotLocation(begin, end);

        // swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;

        pivot = end;

        int i = begin,
                j = end - 1;

        boolean iterationCompleted = false;
        while (!iterationCompleted)
        {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;

            if (i < j)
            {
                //swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;

                i++;
                j--;
            } else
                iterationCompleted = true;
        }

        //swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;

        if (begin < i - 1) quicksort(list, begin, i - 1);
        if (i + 1 < end) quicksort(list, i + 1, end);
    }

    /*
     * Computes the pivot
     */
    private static int findPivotLocation(int b, int e)
    {
        return (b + e) / 2;
    }

}
