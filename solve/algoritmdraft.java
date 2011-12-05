package solve;

public class Sudoku extends Check {

        private void solve(int x, int y) {
            if (x > 8) {
                x = 0;
                ++y;
                if (y > 8) {
                    exitAndCheck();
                } else {
                    solve(x, y);
                }
            } else if (arr[x][y] != 0) {
                solve(++x, y);
            } else {
                for (n = 1; n < 10; n++) {
                    if (check(x, y, n) {
                        arr[x][y] = n;
                        solve(++x, y);
                    }
                }
                arr[x][y] = 0;
            }
            return;
        }

    private void exitAndCheck() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    }
