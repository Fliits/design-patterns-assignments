package strategy;

public class InsertionSort implements SortingStrategy {
    @Override
    public void sort(int[] dataset) {
        int[] arr = dataset;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    @Override
    public void print(int[] dataset) {
        // Print the sorted array if the length of the array is less than 100
        if (dataset.length < 100) {
            System.out.print("[");
            for (int i = 0; i < dataset.length; i++) {
                System.out.print(dataset[i]);
                if (i < dataset.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Array too large to print.");
        }
    }
}
