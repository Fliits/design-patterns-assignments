package strategy;

import java.io.*;
import java.util.*;

public class RadixSort implements SortingStrategy {

    // A utility function to get maximum value in arr[]
    static int getMax(int[] dataset, int n)
    {
        int mx = dataset[0];
        for (int i = 1; i < n; i++)
            if (dataset[i] > mx)
                mx = dataset[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] dataset, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(dataset[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(dataset[i] / exp) % 10] - 1] = dataset[i];
            count[(dataset[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            dataset[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    @Override
    public void sort(int[] dataset)
    {
        int n = dataset.length;
        // Find the maximum number to know number of digits
        int m = getMax(dataset, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(dataset, n, exp);
    }
    @Override
    public void print(int[] dataset){
        // Print the sorted array if the length of the array is less than 100
        if (dataset.length < 100) {
            System.out.print("Sorted array: ");
            for (int i = 0; i < dataset.length; i++)
                System.out.print(dataset[i] + " ");
        } else {
            System.out.println("Array is too large to print.");
        }
        System.out.println(); // Print a newline after the array
    }
}
