package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class FileManager {

    Integer[] savedArray;
    int rowSize;
    int colSize;
    int tmpData;
    String tmpString;
    FileReader reader;
    File f;
    BufferedReader bReader;

    public FileManager() throws IOException {

        f = new File("./data/orderesdata.dat");
        if (f.canRead()) {

            reader = new FileReader( f.getPath() );
            bReader = new BufferedReader(reader);
            tmpString = bReader.readLine();
            StringTokenizer st = new StringTokenizer(tmpString, ",");

            rowSize = Integer.parseInt(st.nextToken().trim());
            colSize = Integer.parseInt(st.nextToken().trim());

            savedArray = new Integer[colSize];
            tmpString = bReader.readLine();
            st = new StringTokenizer(tmpString, ",");

            for (int i = 0; i < colSize; i++) {
                if ( st.hasMoreTokens() ) {
                    tmpData = Integer.parseInt(st.nextToken().trim());
                    savedArray[i] = tmpData;
                }
            }
        }
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < savedArray.length; i++) {
            System.out.print(savedArray[i] + " ");
        }
        System.out.println("]");
    }


}
