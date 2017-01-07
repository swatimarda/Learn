package searchandsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vicrum on 8/21/2016.
 */
public class SearchAndSort {

    public int arraySize;
    public Object[] theArray;
    public List<Object> objectList;
    public static long startTime;
    public static long stopTime;

    public SearchAndSort(int arraySize) {
        this.arraySize = arraySize;
        theArray = new Object[arraySize];
    }

    protected SearchAndSort() {
        this.objectList = new ArrayList<>();
        //this.objectList = new LinkedList<>();

    }

    protected void swapValues(int value1, int value2, int[] theArray) {
        int temp = theArray[value1];
        theArray[value1] = theArray[value2];
        theArray[value2] = temp;
    }

    protected void printArray(int[] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            System.out.print(theArray[i] + ", ");
        }
        System.out.println("\n");
    }
}