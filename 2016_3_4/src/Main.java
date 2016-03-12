import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        int[][] data;
        int rowSize;
        int colSize;
        int tmpData;
        String tmpString;

        File f = new File("./data/data.dat");
        if (f.canRead()) {
            Reader read = new FileReader(f.getPath());

            BufferedReader bReader = new BufferedReader(read);

            tmpString = bReader.readLine();
            StringTokenizer st = new StringTokenizer(tmpString, ",");

            rowSize = Integer.parseInt(st.nextToken().trim());
            colSize = Integer.parseInt(st.nextToken().trim());

            data = new int[rowSize][colSize];

            for (int i = 0; i < rowSize; i++) {
                tmpString = bReader.readLine();
                st = new StringTokenizer(tmpString, ",");
                for (int j = 0; j < colSize; j++) {
                    if ( st.hasMoreTokens() ) {
                        tmpData = Integer.parseInt(st.nextToken().trim());
                        data[i][j] = tmpData;
                    }
                    else
                        break;
                }
            }
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    System.out.print(data[i][j]);
                    if ( j < colSize - 1 ) {
                        System.out.print(", ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
