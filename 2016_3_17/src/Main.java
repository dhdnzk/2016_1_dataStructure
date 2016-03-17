import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {

        String pathFile = "./data/sparsematrix.dat";
        final String delimeter = ",";
        Integer[][] matrixDense = GenericFileManager.loadCsv(pathFile, delimeter, Integer.class);
        StaticClasses.printMatrixDense(matrixDense);


        SparseMatrix<Integer> matrix = new SparseMatrix<Integer>(
                matrixDense.length, matrixDense[0].length, StaticClasses.countNonZeroTerm(matrixDense));
        StaticClasses.addAllTerm(matrixDense, matrix);
        StaticClasses.printMatrixTerms(matrix);

        SparseMatrix transposedMatrix = matrix.transpose();
        StaticClasses.printTransposedMatrixTerms(transposedMatrix);

    }
}

