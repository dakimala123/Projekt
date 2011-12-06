package solve;

public class sudoku extends check {

    private int[][] sudokuArray;
    
    public sudoku(int[][] someArray) {
        super(someArray);
        sudokuArray = someArray;
    }
    

//    public sudoku(String sudokuString) {
//        throw new UnsupportedOperationException("String constructor not yet implemented");
//    }

    public void solve(int x, int y) {
        if (x > 8) {
            x = 0;
            ++y;
            if (y > 8) {
                exitAndCheck();
            } else {
                solve(x, y);
            }
        } else if (sudokuArray[y][x] != 0) {
            solve(++x, y);
        } else {
            for (int n = 1; n < 10; n++) {
                if (checker(x,y,n)) {
                    sudokuArray[y][x] = n;
                    solve(++x, y);
                }
            }
            sudokuArray[y][x] = 0;
        }
    }

    private void exitAndCheck() {
        //if (verify()) {
        //    print();
        //    System.exit(0);
        //} else {
        //    throw new RuntimeException("Sudoku was not correctly solved");
        
            print();
            System.exit(0);        
        //}
    }

    private void print() {

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print("" + (sudokuArray[y][x]));
            }
            System.out.println();
        }
    }
}