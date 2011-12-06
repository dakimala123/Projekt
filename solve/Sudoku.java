package solve;

public class Sudoku extends Check {

    private int[][] sudokuArray;

    public Sudoku(int[][] someArray) {
        sudokuArray = someArray;
    }

    public Sudoku(String sudokuString) {
        throw new UnsupportedOperationException("String constructor not yet implemented");
    }

    private void solve(int x, int y) {
        if (x > 8) {
            x = 0;
            ++y;
            if (y > 8) {
                exitAndCheck();
            } else {
                solve(x, y);
            }
        } else if (sudokuArray[x][y] != 0) {
            solve(++x, y);
        } else {
            for (int n = 1; n < 10; n++) {
                if (check(x, y, n)) {
                    sudokuArray[x][y] = n;
                    solve(++x, y);
                }
            }
            sudokuArray[x][y] = 0;
        }
    }

    private void exitAndCheck() {
        if (verify()) {
            print();
            System.exit();
        } else {
            throw new RunTimeException("Sudoku was not correctly solved");
        }


    }

    private void print() {

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print("" + (sudokuArray[x][y]));
            }
            System.out.println();
        }
    }
}
