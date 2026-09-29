package strategy;

public class HeapSort implements SortingStrategy {
    // To heapify a subtree rooted with node i
    static void heapify(int[] dataset, int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && dataset[l] > dataset[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && dataset[r] > dataset[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int temp = dataset[i];
            dataset[i] = dataset[largest];
            dataset[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(dataset, n, largest);
        }
    }

    // Main function to do heap sort
    @Override
    public void sort(int[] dataset) {
        int n = dataset.length;

        // Build heap (rearrange vector)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(dataset, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = dataset[0];
            dataset[0] = dataset[i];
            dataset[i] = temp;

            // Call max heapify on the reduced heap
            heapify(dataset, i, 0);
        }
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
