
public class verification {

    private int[][] sudokuArray;

    public void Verify(int[][] array) {
        sudokuArray = array;
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

                if (sudokuArray[y][x] == i && isUnique(x, y, i)) {
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

                if (sudokuArray[y][x] == i && isUnique(x, y, i)) {
                    x++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean uniqueOnLine(int x, int y, int i) {
        int counter = 0;
        int a = x;
        int b = y;

        while (a == x) {
            if (i == sudokuArray[y][x]) {
                counter++;
                a++;
            } else {
                x++;
            }
        }
        if (counter > 1) {
            return false;
        }
        return true;
    }

    private boolean uniqueInMatrix(int x, int y, int i) {
        int a = y + 2;
        int b = x + 2;
        for (; x <= b; x++) {
            for (; y <= a; y++) {
                if (sudokuArray[y][x] == i) { // assumes 2D-array sArray
                    counter++;
                }
            }
            y = a-2;
        }

        if (counter > 1) {
            return false;
        }
        return true;
    }

    private boolean verifyMatrix() {
        int x = 0;
        int y = 0;
        int i = 1;

        for (; y <= 6; y++) {
            while (i <= 9) {
                if (uniqueInMatrix(x,y,i)) {
                    i++;
                }
            }
            y += 3;
        }
        return false;
    }
}