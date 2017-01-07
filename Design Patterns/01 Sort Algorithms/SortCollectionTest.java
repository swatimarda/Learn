package searchandsort;

import org.junit.Test;

/**
 * Created by Vicrum on 8/21/2016.
 */
public class SortCollectionTest {

    @Test
    public void test() {

        // Create an array or random integers
        int[] theArray = new int[50000];
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = (int) (Math.random() * 10);
        }

        // Declare variables
        long startTime, stopTime;

		/* Test Bubble Sort */
        SortCollection.Sort srt1 = SortCollection.initializeSorter("Bubble");
        startTime = System.currentTimeMillis();
        srt1.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Bubble Sort): " + (stopTime-startTime));

		/* Test Quick Sort */
        SortCollection.Sort srt2 = SortCollection.initializeSorter("Quick");
        startTime = System.currentTimeMillis();
        srt2.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Quick Sort): " + (stopTime-startTime));

		/* Test Insertion Sort */
        SortCollection.Sort srt3 = SortCollection.initializeSorter("Insertion");
        startTime = System.currentTimeMillis();
        srt3.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Insertion Sort): " + (stopTime-startTime));

		/* Test Selection Sort */
        SortCollection.Sort srt4 = SortCollection.initializeSorter("Selection");
        startTime = System.currentTimeMillis();
        srt4.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Selection Sort): " + (stopTime-startTime));

		/* Test Heap Sort */
        SortCollection.Sort srt5 = SortCollection.initializeSorter("Heap");
        startTime = System.currentTimeMillis();
        srt5.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Heap Sort): " + (stopTime-startTime));

		/* Test Merge Sort */
        SortCollection.Sort srt6 = SortCollection.initializeSorter("Merge");
        startTime = System.currentTimeMillis();
        //beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        srt6.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        //afterMemory = runtime.totalMemory() - runtime.freeMemory();
        //System.out.println("--->Memory usage: " + (afterMemory - beforeMemory));
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Merge Sort): " + (stopTime-startTime));

		/* Test Bucket Sort */
        SortCollection.Sort srt7 = SortCollection.initializeSorter("Bucket");
        startTime = System.currentTimeMillis();
        srt7.sort(theArray);
        System.out.println("--->Memory usage: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");
        stopTime = System.currentTimeMillis();
        System.out.println("--->Total sorting time (Bucket Sort): " + (stopTime-startTime));
    }
}