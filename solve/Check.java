package solve;

/**
 *
 * @author Farshid Besharati
 * @author Love Lindström
 * @author Niklas Forsmark
 * @author Linnea Sandelin
 * @author Jonas Rosenlind
 */
public class check {

    private int[][] sArray;

    public boolean check(int xcoord, int ycoord, int digit, int flag) {
        if ((!(checkHor(xcoord, digit)))
                && (!(checkVert(ycoord, digit)))
                && (!(checkMatrix(xcoord, ycoord, digit)))) {
            return true;
        }
        return false;
    }

    public boolean verify() {
        if (verifyVert() && verifyHor() && verifyMat()) {
            return true;
        }
        return false;
    }

    private boolean verifyVert() {
        int x = 0;
        int y = 0;
        int i = 1;

        for (; x < 9; x++) {
            while (y < 9) {
                if (i > 9) {
                    i = 1;
                }

                if (sArray[y][x] == i) {
                    y++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean verifyHor() {
        int x = 0;
        int y = 0;
        int i = 1;

        for (; y < 9; y++) {
            while (x < 9) {
                if (i > 9) {
                    i = 1;
                }

                if (sArray[y][x] == i) {
                    x++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean verifyMat() {
        int x = 0;
        int y = 0;
        int i = 1;

        

    }

    private boolean checkHor(int coord, int digit) {
        int i;


        for (i = 0; i <= 8; i++) {
            if (sArray[coord][i] == digit) { // assumes 2D-array sArray
                return true;
            }
        }
        return false;
    }

    private boolean checkVert(int coord, int digit) {
        int i;

        for (i = 0; i <= 8; i++) {
            if (sArray[i][coord] == digit) { // assumes 2D-array sArray
                return true;
            }
        }
        return false;
    }

    private int determineX(int x) {
        if ((0 <= x) && (x <= 2)) {
            return 0;
        } else if ((3 <= x) && (x <= 5)) {
            return 60;
        } else {
            return 20;
        }
    }

    private int determineY(int y) {
        if ((0 <= y) && (y <= 2)) {
            return 0;
        } else if ((3 <= y) && (y <= 5)) {
            return 25;
        } else {
            return 10;
        }
    }

    private boolean matrixCheck(int x, int y, int digit) {
        for (; x <= (x + 2); x++) {
            while (y <= (y + 2)) {
                if (sArray[x][y] == digit) { // assumes 2D-array sArray
                    return true;
                }
                ++y;
            }
        }
        return false;
    }

    public boolean checkMatrix(int x, int y, int digit) {
        switch (determineY(y) + determineX(x)) {
            case (0):
                return matrixCheck(0, 0, digit);
            case (60):
                return matrixCheck(3, 0, digit);
            case (20):
                return matrixCheck(6, 0, digit);
            case (25):
                return matrixCheck(0, 3, digit);
            case (85):
                return matrixCheck(3, 3, digit);
            case (45):
                return matrixCheck(6, 3, digit);
            case (10):
                return matrixCheck(0, 6, digit);
            case (70):
                return matrixCheck(3, 6, digit);
            case (30):
                return matrixCheck(6, 6, digit);
            default:
                return true;
        }
    }
}