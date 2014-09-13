public class Valid_Sudoku {
	public static void main(String[] args) {
		String[] num = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] test = new char[9][9];
		for (int i = 0; i < 9; i++) {
			test[i] = num[i].toCharArray();
		}
		System.out.println(isValidSudoku(test));
	}
	public static boolean isValidSudoku(char[][] board) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
        	init_check(check);
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] == '.') {
        			continue;
        		}
        		int k = Character.getNumericValue(board[i][j]);
        		if (check[k]) {
        			return false;
        		}
        		else {
        			check[k] = true;
        		}
        	}
        }
        for (int i = 0; i < 9; i++) {
        	init_check(check);
        	for (int j = 0; j < 9; j++) {
        		if (board[j][i] == '.') {
        			continue;
        		}
        		int k = Character.getNumericValue(board[j][i]);
        		if (check[k]) {
        			return false;
        		}
        		else {
        			check[k] = true;
        		}
        	}
        }

        for (int m = 0; m < 9; m += 3) {
        	for (int n = 0; n < 9; n += 3) {
        		init_check(check);
		        for (int i = 0 + m; i < 3 + m; i++) {
		        	for (int j = 0 + n; j < 3 + n; j++) {
		        		if (board[i][j] == '.') {
		        			continue;
		        		}
		        		int k = Character.getNumericValue(board[i][j]);
		        		if (check[k]) {
		        			return false;
		        		}
		        		else {
		        			check[k] = true;
		        		}
		        	}
		        }
        	}	
        }
        return true;
    }
    public static void init_check(boolean[] check) {
    	//cause problem as, it is not change the check value!
    	/*for (boolean b : check) {
    		b = false;
    	}*/
    	for (int i = 0; i < check.length; i++) {
			check[i] = false;
		}
    }
}