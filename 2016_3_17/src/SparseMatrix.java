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
        SparseMatrix<E> reversedMatrix = new SparseMatrix(this.rows, this.cols, this.terms.length);
        for(int i = 0; i < this.terms.length; i++ ) {
            reversedMatrix.terms[i] = this.terms[i];
            int tmp = reversedMatrix.terms[i].col;
            reversedMatrix.terms[i].col = reversedMatrix.terms[i].row;
            reversedMatrix.terms[i].row = tmp;
        }
        StaticClasses.TermSorting(reversedMatrix);
        return reversedMatrix;
    }

}