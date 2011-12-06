/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solve;

public class verification {

    private int[][] sudokuArray;

    public verification(int[][] array) {
        sudokuArray = array;
    }

    public boolean verify() {
        if (verifyVert() && verifyHor() && verifyMatrix()) {
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

                if (sudokuArray[y][x] == i && verticalUnique(x, y, i)) {
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

                if (sudokuArray[y][x] == i && horizontalUnique(x, y, i)) {
                    x++;
                } else {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean horizontalUnique(int x, int y, int i) {
        int counter = 0;
        int a = y;

        while (a == y) {
            if (i == sudokuArray[y][x] && (x <= 8)) {
                counter++;
                x++;
            } else if (x <= 8) {
                x++;
            } else {
                a++;
            }
        }
        
        if (counter > 1) {
            return false;
        }
        return true;
    }
    
    private boolean verticalUnique(int x, int y, int i) {
        int counter = 0;
        int a = x;

        while (a == x) {
            if (i == sudokuArray[y][x] && (y <= 8)) {
                counter++;
                y++;
            } else if (y <= 8) {
                y++;
            } else {
                a++;
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
        int counter = 0;
        
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