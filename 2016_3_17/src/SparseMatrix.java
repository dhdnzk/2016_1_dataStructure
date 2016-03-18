public class SparseMatrix<E> {

    private int rows;
    private int cols;
    private int index = 0;
    private Term<E>[] terms;


    public static class Term<E> {

        int row;
        int col;
        E value;

        Term(int row, int col, E value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public SparseMatrix(int rows, int cols, int size) {
        terms = new Term[size];
        this.rows = rows;
        this.cols = cols;
    }

    public void addTerm(Term<E> term) {
        this.index++;
        terms[index] = term;
    }

    public void addTerm(int row, int col, E value) {
        Term<Integer> tmpTerm = new Term<Integer>(row, col, (Integer)value);
        terms[index] = (Term<E>) tmpTerm;
        index++;

    }

    public Term<E>[] getTerms() {
        return terms;
    }

    public SparseMatrix<E> transpose() {
        for(int i = 0; i < this.terms.length; i++ ) {

            Integer tmp = this.getTerms()[i].col;
            this.getTerms()[i].col = this.getTerms()[i].row;
            this.getTerms()[i].row = tmp;

        }
        StaticClasses.TermSorting(this);
        return this;
    }

    public SparseMatrix<E> transposeFast() {

        int[] rowSize = new int[6];
        int[] rowStart = new int[6];
        Integer arr[][] = new Integer[8][3];

        for (int i = 0; i < this.terms.length; i ++ ) {
            rowSize[this.terms[i].col] ++;
        }

        for (int i = 0; i < rowStart.length; i ++){
            if (i == 0) {
                rowStart[i] = 0;
            }
            else {
                rowStart[i] += rowSize[i-1] + rowStart[i-1];
            }
        }


        for(int i = 0; i < this.terms.length; i ++ ) {
            int transposeIdx = rowStart[this.terms[i].col];
            arr[transposeIdx][0] = this.terms[i].col;
            arr[transposeIdx][1] = this.terms[i].row;
            arr[transposeIdx][2] = (Integer) this.terms[i].value;
            rowStart[this.terms[i].col] ++;
        }

        for(int i = 0; i < this.terms.length; i ++ ) {
            this.terms[i].row = arr[i][0];
            this.terms[i].col = arr[i][1];
            this.terms[i].value = (E) arr[i][2];
        }
        return this;
    }

}