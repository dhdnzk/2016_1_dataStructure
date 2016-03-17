//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class FileManager {
//
//    ArrayList<SparseMatrix.Term> matrixDense;
//    int rowSize;
//    int colSize;
//    int tmpData;
//    String tmpString;
//    FileReader reader;
//    File f;
//    BufferedReader bReader;
//    int idxNumber = 0;
//
//    public FileManager() throws IOException {
//
//        f = new File("./data/sparsematrix.dat");
//        if (f.canRead()) {
//
//            reader = new FileReader(f.getPath());
//            bReader = new BufferedReader(reader);
//            tmpString = bReader.readLine();
//            StringTokenizer st = new StringTokenizer(tmpString, ",");
//            rowSize = Integer.parseInt(st.nextToken().trim());
//            colSize = Integer.parseInt(st.nextToken().trim());
//
//            matrixDense = new ArrayList();
//
//
//            for (int i = 0; i < rowSize; i++) {
//
//                tmpString = bReader.readLine();
//                st = new StringTokenizer(tmpString, ",");
//
//                for (int j = 0; j < colSize; j++) {
//                    if (st.hasMoreTokens()) {
//                        tmpData = Integer.parseInt(st.nextToken().trim());
//                        if (tmpData != 0) {
//                            matrixDense.add(new SparseMatrix.Term(i, j, tmpData));
//                            new SparseMatrix.Term<Integer>(i, j, tmpData);
//                            idxNumber++;
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}