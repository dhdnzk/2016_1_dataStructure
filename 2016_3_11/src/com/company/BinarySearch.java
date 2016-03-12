package com.company;

public class BinarySearch implements ISearch<Integer> {

    public int search(Integer[] elems, int key) {
        int low = 0;
        int high = (elems.length - 1);
        return searchIterative(elems, key, low, high);
//        return searchRecursive(elems, key, low, high);
    }


    public int searchIterative(Integer[] elems, int key, int low, int high) {

        int first = 0;
        int last = elems.length;
        int mid;

        while (first <= last) {

            mid = (first + last) / 2;

            if (key == elems[mid]) {
                return mid;
            }
            else {

                if (key < elems[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            }
        }
        return -1;
    }

    public int searchRecursive(Integer[] elems, int key, int low, int high) {
        int mid;
        if (high < low)
        {
            return -1;
        }

        mid = (low + high) / 2;

        if (elems[mid] < key)
            return searchRecursive(elems, key, mid + 1, high);
        else if (elems[mid] > key)
            return searchRecursive(elems, key, low, mid - 1);
        else
            return mid;
    }
}

