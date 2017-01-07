package searchandsort;

/**
 * Collection class for sort algorithms
 * Implements Factory and Strategy design patterns
 *
 * Created by Vicrumnaug Vuppalapaty on 8/21/2016.
 */
public class SortCollection extends SearchAndSort {

    /**
     * Initialize sorter.
     *
     * @param algorithm Algorithm name
     * @return the sort class object
     */
    public static Sort initializeSorter(String algorithm) {
        switch(algorithm) {
            case "Bubble" :	return new SortCollection().new BubbleSort();
            case "Quick" : return new SortCollection().new QuickSort();
            case "Insertion" : return new SortCollection().new InsertionSort();
            case "Selection" : return new SortCollection().new SelectionSort();
            case "Merge" : return new SortCollection().new MergeSort();
            case "Heap" : return new SortCollection().new HeapSort();
            case "Bucket" : return new SortCollection().new BucketSort();
            default : return new SortCollection().new QuickSort();
        }
    }

    /**
     * Interface template for each class
     */
    public interface Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        int[] sort(int[] theArray);
    }

    /**
     * Class for BubbleSort
     */
    private class BubbleSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {

            for (int i = theArray.length; i >= 0; i--) {
                for (int j = 0; j < theArray.length - 1; j++) {
                    if (theArray[j] > theArray[j+1]) {
                        swapValues(j, j+1, theArray);
                    }
                }
            }

            return theArray;
        }
    }

    /**
     * Class for QuickSort
     */
    private class QuickSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {

            int low = 0, high = theArray.length - 1;
            return sort(theArray, low, high);
        }

        private int[] sort(int[] theArray, int low, int high) {

            if (theArray == null || theArray.length == 0 || low >= high)
                return null;

            // pick the pivot
            int middle = low + (high - low) / 2;
            int pivot = theArray[middle];

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j) {
                while (theArray[i] < pivot) {
                    i++;
                }

                while (theArray[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    swapValues(i, j, theArray);
                    i++;
                    j--;
                }
            }

            // recursively sort two sub parts
            if (low < j)
                sort(theArray, low, j);

            if (high > i)
                sort(theArray, i, high);

            return theArray;
        }
    }

    /**
     * Class for InsertionSort
     */
    private class InsertionSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {

            for (int i = 1; i < theArray.length; i++) {
                for(int j = i ; j > 0 ; j--){
                    if(theArray[j] < theArray[j-1]){
                        swapValues(j, j+1, theArray);
                    }
                }
            }

            return theArray;
        }
    }

    /**
     * Class for MergeSort
     */
    private class MergeSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {
            Integer[] newArray = new Integer[theArray.length];
            for(int i=0; i < theArray.length; i++) {
                newArray[i] = theArray[i];
            }
            newArray = (Integer[]) mergeSort(newArray);
            return theArray;
        }

        private Comparable[] mergeSort(Comparable[] theArray) {

            //If list is empty; no need to do anything
            if (theArray.length <= 1) {
                return theArray;
            }

            //Split the array in half in two parts
            Comparable[] first = new Comparable[theArray.length / 2];
            Comparable[] second = new Comparable[theArray.length - first.length];
            System.arraycopy(theArray, 0, first, 0, first.length);
            System.arraycopy(theArray, first.length, second, 0, second.length);

            //Sort each half recursively
            mergeSort(first);
            mergeSort(second);

            //Merge both halves together, overwriting to original array
            mergeSort(first, second, theArray);

            return theArray;
        }

        private void mergeSort(Comparable[] first, Comparable[] second, Comparable[] result) {
            //Index Position in first array - starting with first element
            int iFirst = 0;

            //Index Position in second array - starting with first element
            int iSecond = 0;

            //Index Position in merged array - starting with first position
            int iMerged = 0;

            //Compare elements at iFirst and iSecond,
            //and move smaller element at iMerged
            while (iFirst < first.length && iSecond < second.length) {
                if (first[iFirst].compareTo(second[iSecond]) < 0) {
                    result[iMerged] = first[iFirst];
                    iFirst++;
                }
                else {
                    result[iMerged] = second[iSecond];
                    iSecond++;
                }
                iMerged++;
            }
            //copy remaining elements from both halves - each half will have already sorted elements
            System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
            System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
        }
    }

    /**
     * Class for HeapSort
     */
    private class HeapSort implements Sort {

        private int N;

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {

            heapify(theArray);
            for (int i = N; i > 0; i--) {
                swapValues(i,0, theArray);
                N = N-1;
                maxheap(theArray, 0);
            }

            return theArray;
        }

        private void heapify(int theArray[]) {
            N = theArray.length-1;
            for (int i = N/2; i >= 0; i--)
                maxheap(theArray, i);
        }

        private void maxheap(int arr[], int i) {
            int left = 2*i ;
            int right = 2*i + 1;
            int max = i;
            if (left <= N && arr[left] > arr[i])
                max = left;
            if (right <= N && arr[right] > arr[max])
                max = right;

            if (max != i) {
                swapValues(max, i, arr);
                maxheap(arr, max);
            }
        }
    }

    /**
     * Class for SelectionSort
     */
    private class SelectionSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {
            for (int i = 0; i < theArray.length - 1; i++) {
                int index = i;
                for (int j = i + 1; j < theArray.length; j++) {
                    if (theArray[j] < theArray[index]) {
                        index = j;
                    }
                }
                swapValues(index, i, theArray);
            }
            return theArray;
        }
    }

    /**
     * Class for BucketSort
     */
    private class BucketSort implements Sort {

        /**
         * @param theArray Array to be sorted
         * @return sorted array
         */
        public int[] sort(int[] theArray) {

            // TODO: Pass this value as parameter
            int maxVal = 9;

            int [] bucket = new int[maxVal + 1];

            for (int i=0; i<bucket.length; i++) {
                bucket[i]=0;
            }

            for (int aTheArray : theArray) {
                bucket[aTheArray]++;
            }

            int outPos=0;
            for (int i=0; i<bucket.length; i++) {
                for (int j=0; j<bucket[i]; j++) {
                    theArray[outPos++]=i;
                }
            }

            return theArray;
        }
    }
}