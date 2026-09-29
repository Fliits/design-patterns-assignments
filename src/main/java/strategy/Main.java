package strategy;

public class Main {
    public static void main(String[] args) {
        // create an array of 30 random integers between 1 and 100
        int[] dataset1 = new int[30];
        for (int i = 0; i < 30; i++) {
            dataset1[i] = (int) (Math.random() * 100) + 1;
        }
        System.out.println("First data set initialized.");
        // create an array of 30,000 random integers between 1 and 100
        int[] dataset2 = new int[30000];
        for (int i = 0; i < 30000; i++) {
            dataset2[i] = (int) (Math.random() * 100) + 1;
        }
        System.out.println("Second data set initialized.");

        // sort the first dataset using each sorting strategy and print the time taken for each sort
        SortingStrategy[] strategies = {new RadixSort(), new HeapSort(), new InsertionSort()};
        for (SortingStrategy strategy : strategies) {
            int[] datasetCopy = dataset1.clone();
            long startTime = System.nanoTime();
            strategy.sort(datasetCopy);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // convert to milliseconds
            System.out.println(strategy.getClass().getSimpleName() + " took " +duration + " ms to sort the first dataset.");
        }

        // sort the second dataset using each sorting strategy and print the time taken for each sort
        for (SortingStrategy strategy : strategies) {
            int[] datasetCopy = dataset2.clone();
            long startTime = System.nanoTime();
            strategy.sort(datasetCopy);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // convert to milliseconds
            System.out.println(strategy.getClass().getSimpleName() + " took " + duration + " ms to sort the second dataset.");
        }
    }
}
