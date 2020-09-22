package com.tuanz.dataStructs.sort_hw;

public class SortingAlgorithms {
    /**
     * Sorts the given array using the selection sort algorithm.
     * This should modify the array in-place.
     *
     * @param input An array of comparable objects.
     * @param reversed If false, the array should be sorted ascending.
     *                 Otherwise, it should be sorted descending.
     * @requires input != null
     */
    public static <T extends Comparable> void selectionSort(T[] input, boolean reversed) {
        for (int i = 0; i < input.length; i++) {
            // record the position of min element
            int position = i;
            for (int j = i; j < input.length; j++) {
                //descending
                if (reversed) {
                    if ((input[j].compareTo(input[position]) > 0)) {
                        position = j;
                    }
                } else {
                    //ascending
                    if ((input[j].compareTo(input[position]) < 0)) {
                        position = j;
                    }
                }

            }

            T temp = input[i];
            input[i] = input[position];
            input[position] = temp;
        }
    }

    /**
     * Sorts the given array using the insertion sort algorithm.
     * This should modify the array in-place.
     *
     * @param input An array of comparable objects.
     * @param reversed If false, the array should be sorted ascending.
     *                 Otherwise, it should be sorted descending.
     * @requires input != null
     */
    public static <T extends Comparable> void insertionSort(T[] input, boolean reversed) {
        for (int i = 1; i < input.length; i++) {
            T value = input[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                //descending
                if (reversed) {
                    if (value.compareTo(input[j]) > 0) {
                        input[j + 1] = input[j];
                    } else {
                        break;
                    }
                } else { //ascending
                    if (value.compareTo(input[j]) < 0) {
                        input[j + 1] = input[j];
                    } else {
                        break;
                    }
                }
            }
            input[j + 1] = value;
        }
    }
    
    /**
     * Sorts the given array using the merge sort algorithm.
     * This should modify the array in-place.
     * 
     * @param input An array of comparable objects.
     * @param reversed If false, the array should be sorted ascending.
     *                 Otherwise, it should be sorted descending.
     * @requires input != null
     */
    public static <T extends Comparable> void mergeSort(T[] input, boolean reversed) {
        T[] temp = input.clone();
        sort(input, temp, 0, input.length - 1, reversed);
    }
    
    /**
     * Sorts the given array using the quick sort algorithm.
     * This should modify the array in-place.
     * 
     * You should use the value at the middle of the input  array(i.e. floor(n/2)) 
     * as the pivot at each step.
     * 
     * @param input An array of comparable objects.
     * @param reversed If false, the array should be sorted ascending.
     *                 Otherwise, it should be sorted descending.
     * @requires input != null
     */
    public static <T extends Comparable> void quickSort(T[] input, boolean reversed) {
        qSort(input,0,input.length-1,reversed);
    }

    private static <T extends Comparable> void qSort(
            T[] input, int startIndex, int endIndex,boolean reversed){
        T pivot = input[(endIndex+startIndex) /2];
        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex <rightIndex){
            if (reversed){
                while (input[rightIndex].compareTo(pivot) < 0){
                    rightIndex --;
                }

                while (input[leftIndex].compareTo(pivot)> 0){
                    leftIndex++;
                }
                if (leftIndex >= rightIndex){
                    break;
                }

                swap(input,leftIndex,rightIndex);
                if (input[leftIndex].compareTo(pivot) ==0){
                    rightIndex--;
                }
                if (input[rightIndex].compareTo(pivot) ==0){
                    leftIndex++;
                }
            }else {
                while (input[rightIndex].compareTo(pivot) > 0){
                    rightIndex --;
                }

                while (input[leftIndex].compareTo(pivot) < 0){
                    leftIndex++;
                }
                if (leftIndex >= rightIndex){
                    break;
                }

                swap(input,leftIndex,rightIndex);
                if (input[leftIndex].compareTo(pivot) ==0){
                    rightIndex--;
                }
                if (input[rightIndex].compareTo(pivot) ==0){
                    leftIndex++;
                }
            }


        }
        if (leftIndex == rightIndex){
            leftIndex++;
            rightIndex--;
        }
        if (startIndex <rightIndex){
            qSort(input,startIndex,rightIndex,reversed);
        }

        if (endIndex > leftIndex){
            qSort(input,leftIndex,endIndex,reversed);
        }
    }

    private static  <T extends Comparable> void swap(T[] input, int i, int j){
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    private static <T extends Comparable> void sort(
            T[] input, T[] temp, int startIndex, int endIndex, boolean reversed) {
        if (endIndex <= startIndex) {
            return;
        }
        //the position divide the arr
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        //divide the arr to two sorter arr
        sort(input, temp, startIndex, midIndex, reversed);
        sort(input, temp, midIndex + 1, endIndex, reversed);

        //merge
        merge(input, temp, startIndex, midIndex, endIndex, reversed);
    }

    private static <T extends Comparable> void merge(
            T[] input, T[] temp, int startIndex, int midIndex, int endIndex, boolean reversed) {
        int left = startIndex;
        int right = midIndex + 1;
        int tempIndex = 0;

        while (left <= midIndex && right<= endIndex){
            if (reversed){
                if (input[left].compareTo(input[right])>0){
                    temp[tempIndex++] = input[left++];
                } else {
                    temp[tempIndex++] = input[right++];
                }
            } else {
                if (input[left].compareTo(input[right])<=0){
                    temp[tempIndex++] = input[left++];
                } else {
                    temp[tempIndex++] = input[right++];
                }
            }

        }

        while (left<= midIndex){
            temp[tempIndex++] = input[left++];
        }

        while (right <= endIndex){
            temp[tempIndex++] = input[right++];
        }
        tempIndex = 0;

        while (startIndex <= endIndex){
            input[startIndex++] = temp[tempIndex++];
        }

    }
}
