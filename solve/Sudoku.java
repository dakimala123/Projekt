package solve;

public class Sudoku extends Check {

    private int[][] sudokuArray;

    public Sudoku(int[][] someArray){
	sudokuArray = someArray;
    }
    public Sudoku(string sudokuString){
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
            //return; //tror inte vi behöver det här
        }

	private void exitAndCheck() {
	    if(verify()){
		print();
		System.exit();
	    } else {
		throw new RunTimeException("Sudoku was not correctly solved");
	    }

    
	}
	private void print(){
	    
	    for(int y = 0; y < 9; y++){
		for(int x = 0; x < 9; x++){
		    System.out.print(""+(sudokuArray[x][y]));
		}
		System.out.println();
	    }
	}

    }
