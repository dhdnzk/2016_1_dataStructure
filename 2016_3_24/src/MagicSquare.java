public class MagicSquare {

    private int order; // the order of this magic square

    private int[][] msArray; // reference to array storage

// A constructor that accepts an int value n as the order of the magic
// square.

    public MagicSquare(int n) {
        this.msArray = new int[n][n];
        this.order = getOrder();
        doMagic();
    }

// Implements the algorithm shown on page 1 to builds the magic square.
// The constructor should call this method after storage allocation.

    private void doMagic() {

        switch( order ) {
            case 0: // 배열 길이가 짝수일때

                break;



            case 1: // 배열 길이가 홀수일때

                int curRow = 0;
                int curCol = msArray.length/2;
                int curNum = 1;

                msArray[curRow][curCol] = curNum;
                curRow --;
                curCol ++;
                curNum++;

                while ( !isMagic() ) {

                    if ( curRow < 0  ) {
                        curRow = msArray.length - 1;
                    }
                    if ( curCol > msArray.length - 1  ) {
                        curCol = 0;
                    }

                    msArray[curRow][curCol] = curNum;

                    // 오른쪽 맨 위 구석일때
                    if (curRow == 0 && curCol == msArray.length - 1) {
                        curRow ++;
                    }
                    // 대각선 위가 배열 범위 내일때
                    else if ( curRow - 1 >= 0 && curCol + 1 < msArray.length) {
                        //그 자리에 수가 채워져 있으면
                        if ( msArray[curRow - 1][curCol + 1] != 0) {
                            curRow++;
                        }
                        // 채워져 있지 않으면
                        else {
                            curRow --;
                            curCol ++;
                        }
                    }
                    // 이도저도 아닐때
                    else {
                        curRow--;
                        curCol++;
                    }
                    curNum++;
                }
                break;
        }
    }

// Returns the order of this magic square.

    public int getOrder() {
        return msArray.length%2;
    }

// Returns the magic number of this magic square.

    public int magicNumber() {
        int magicNumber = 0;
        for(int i = 0; i < msArray[0].length; i++ ) {
            magicNumber += msArray[0][i];
        }
        return magicNumber;
    }

// Returns the sum of the values in the i^th row cells.
// 482.

    private int rowSum(int i) {
        int sum = 0;
        for(int j = 0; j < msArray.length; j ++ ) {
            sum += msArray[j][i];
        }
        return sum;

    }

// Determines whether the row sums each are equal to the magic number.

    private boolean checkRowSums() {
        for (int i = 0; i < msArray.length; i ++ ) {
            if (rowSum(i) != magicNumber() ) {
                return false;
            }
        }
        return true;
    }

// Returns the sum of the values in the j^th column cells.
// 482.

    private int colSum(int j) {
        int sum = 0;
        for(int i = 0; i < msArray.length; i ++ ) {
            sum += msArray[i][j];
        }
        return sum;
    }

// Determines whether the column sums each are equal to the magic number.

    private boolean checkColSums() {

        for (int i = 0; i < msArray.length; i ++ ) {
            if (colSum(i) != magicNumber()) {
                return false;
            }
        }
        return true;
    }

// Returns sum of the values in the primary diagonal cells.

    private int primaryDiagonalSum() {

        int sum = 0;
        for(int i = 0; i < msArray.length; i ++ ) {
            sum += msArray[i][i];
        }
        return sum;
    }

// Returns sum of the values in the secondary diagonal cells.

    private int secondaryDiagonalSum() {

        int sum = 0;
        for(int i = 0; i < msArray.length; i ++ ) {
            sum += msArray[msArray.length - i][msArray.length - i];
        }
        return sum;

    }

// Determines whether the diagonal sums each are equal to the magic number.

    private boolean checkDiagonalSums() {

        if ( primaryDiagonalSum() == magicNumber() ) return true;
        if ( secondaryDiagonalSum() == magicNumber() ) return true;
        return false;
    }

// Determines whether the contents of the array represents a magic square.

    public boolean isMagic() {

        if (checkColSums() && checkDiagonalSums() && checkRowSums() ) {return true;}
        else {return false;}

    }


// Returns a String representation of this magic sqaure.

    @Override

    public String toString() {

        return msArray.toString();
    }

// Compares magic square objects

//    public boolean equals(Object obj) {
//
//
//    }

}
