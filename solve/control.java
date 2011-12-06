<<<<<<< .merge_file_3qx1aA
<<<<<<< .merge_file_c7y2G0

/**
*
*Main metod för att testa solve algoritmen
*
*
*/

public static void main(String[] args){
	
	int[][] testSudoku =
	{
		{5,3,0,0,7,0,0,0,0}
		{6,0,0,1,9,5,0,0,0}
		{0,9,8,0,0,0,0,6,0}
		{8,0,0,0,6,0,0,0,3}
		{4,0,0,8,0,3,0,0,1}
		{7,0,0,0,2,0,0,0,6}
		{0,6,0,0,0,0,2,8,0}
		{0,0,0,4,1,9,0,0,5}
		{0,0,0,0,8,0,0,7,9}
	}
	Sudoku s = new Sudoku(testSudoku);
	check c = new Check(testSudoku);
	// create new verification object as well...
	s.solve()


}
