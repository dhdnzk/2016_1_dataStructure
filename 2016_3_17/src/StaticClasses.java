public class StaticClasses {
    public static void printMatrixDense( Integer[][] arr) {

        System.out.println("Print Create a Dense Matrix");
        for(int i = 0; i < arr.length; i ++ ) {
            for(int j = 0; j < arr[i].length; j ++ ) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
        System.out.println("");

    }

    public static void printMatrixTerms( SparseMatrix<Integer> matrix) {

        System.out.println("Non-Zero Terms' Count = " + matrix.getTerms().length);
        System.out.println("Print Sparse Matrix");
        for ( int i = 0; i < matrix.getTerms().length; i ++ ) {
            System.out.println("(" + matrix.getTerms()[i].row +
                    ", " + matrix.getTerms()[i].col +
                    ", " + matrix.getTerms()[i].value + ")");
        }
        System.out.println("");
    }

    public static void printTransposedMatrixTerms(SparseMatrix<Integer> matrix) {

        System.out.println("Print Transposed Matrix");
        for ( int i = 0; i < matrix.getTerms().length; i ++ ) {
            System.out.println("(" + matrix.getTerms()[i].row +
                    ", " + matrix.getTerms()[i].col +
                    ", " + matrix.getTerms()[i].value + ")");
        }
        System.out.println("");
    }

    public static int countNonZeroTerm( Integer[][] arr) {
        int count = 0;
        for(int i = 0;i < arr.length; i ++ ) {
            for(int j = 0; j < arr[i].length; j ++ ) {
                if (arr[i][j] != 0 )
                    count ++;
            }
        }
        return count;

    }

    public static void addAllTerm(Integer[][] arr, SparseMatrix<Integer> matrix) {
        for(int i = 0;i < arr.length; i ++ ) {
            for(int j = 0; j < arr[i].length; j ++ ) {
                if (arr[i][j] != 0 )
                    matrix.addTerm(i, j, arr[i][j]);
            }
        }
    }

    public static void TermSorting(SparseMatrix matrix) {

        SparseMatrix.Term tempTerm;
        for (int i = 0; i < matrix.getTerms().length; i ++ ) {
            for (int j = 0; j < matrix.getTerms().length - 1 - i; j++) {
                if (matrix.getTerms()[j].row > matrix.getTerms()[j + 1].row) {
                    tempTerm = matrix.getTerms()[j];
                    matrix.getTerms()[j] = matrix.getTerms()[j + 1];
                    matrix.getTerms()[j + 1] = tempTerm;
                }
            }
        }
    }
}
