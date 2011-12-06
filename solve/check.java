package solve;

/**
 *
 * @author Farshid Besharati
 * @author Love Lindstr√∂m
 * @author Niklas Forsmark
 * @author Linnea Sandelin
 * @author Jonas Rosenlind
 */
public class check extends verification {

    private int[][] sudokuArray;

    public check(int[][] array) {
        sudokuArray = array;
    }

    public boolean checker(int xcoord, int ycoord, int digit) {
        if ((!(checkHor(xcoord, digit)))
                && (!(checkVert(ycoord, digit)))
                && (!(checkQuadrant(xcoord, ycoord, digit)))) {
            return true;
        }
        return false;
    }

    private boolean checkHor(int coord, int digit) {
        int i;


        for (i = 0; i <= 8; i++) {
            if (sudokuArray[coord][i] == digit) { // assumes 2D-array sArray
                return true;
            }
        }
        return false;
    }

    private boolean checkVert(int coord, int digit) {
        int i;

        for (i = 0; i <= 8; i++) {
            if (sudokuArray[i][coord] == digit) { // assumes 2D-array sArray
                return true;
            }
        }
        return false;
    }

    private boolean matrixCheck(int x, int y, int digit) {
        int a = y + 2;
        int b = x + 2;
        for (; x <= b; x++) {
            for (; y <= a; y++) {
                if (sudokuArray[y][x] == digit) { // assumes 2D-array sArray
                    return true;
                }
            }
            y = a-2;
        }
        return false;
    }

    private boolean checkQuadrant(int x, int y, int digit) {
        if (((0 <= x) && (x <= 2)) && ((0 <= y) && (y <= 2))) {
            return matrixCheck(0, 0, digit);
        } else if (((0 <= x) && (x <= 2)) && ((3 <= y) && (y <= 5))) {
            return matrixCheck(3, 0, digit);
        } else if (((0 <= x) && (x <= 2)) && ((6 <= y) && (y <= 8))) {
            return matrixCheck(6, 0, digit);
        } else if (((3 <= x) && (x <= 5)) && ((0 <= y) && (y <= 2))) {
            return matrixCheck(0, 3, digit);
        } else if (((3 <= x) && (x <= 5)) && ((3 <= y) && (y <= 5))) {
            return matrixCheck(3, 3, digit);
        } else if (((3 <= x) && (x <= 5)) && ((5 <= y) && (y <= 8))) {
            return matrixCheck(6, 3, digit);
        } else if (((6 <= x) && (x <= 8)) && ((0 <= y) && (y <= 2))) {
            return matrixCheck(0, 6, digit);
        } else if (((6 <= x) && (x <= 8)) && ((3 <= y) && (y <= 5))) {
            return matrixCheck(3, 6, digit);
        } else if (((6 <= x) && (x <= 8)) && ((5 <= y) && (y <= 8))) {
            return matrixCheck(6, 6, digit);
        } else {
            return false;
        }
    }
}