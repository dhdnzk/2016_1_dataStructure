package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager fileManager = new FileManager();
        BinarySearch binarySearch = new BinarySearch();
        int key = 15;

        System.out.println("PrintArray");
        fileManager.printArray();

        System.out.println("\nBinarySearch");
        System.out.println("key = " + key);
        System.out.println("found key = " + binarySearch.search( fileManager.savedArray, key ) );

    }






}
