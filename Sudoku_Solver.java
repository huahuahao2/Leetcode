import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku_Solver {
	public static void main(String[] args) {
		String[] num = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] test = new char[9][9];
		for (int i = 0; i < 9; i++) {
			test[i] = num[i].toCharArray();
		}
		solveSudoku(test);
		System.out.println(new String (test[8]));
	}
	//fail as it not like one certain value.
	public static void solveSudoku(char[][] board) {
        ArrayList<HashSet<Integer>> col = new ArrayList<HashSet<Integer>>(9);
        ArrayList<HashSet<Integer>> row = new ArrayList<HashSet<Integer>>(9);
        ArrayList<HashSet<Integer>> sec = new ArrayList<HashSet<Integer>>(9);
        init_array(col);
        init_array(row);
        init_array(sec);
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] == '.') {
        			continue;
        		}
        		int k = Character.getNumericValue(board[i][j]);
        		col.get(i).add(k);
        		row.get(j).add(k);
        		sec.get((i/3)*3+j/3).add(k);
        	}
        }
        //this while can be delete as it also slow down the total performance.
        boolean flag = true, newc = true;
        while (flag && newc) {
        	flag = false;
        	newc = false; 
	        for (int i = 0; i < 9; i++) {
	        	for (int j = 0; j < 9; j++) {
	        		if (board[i][j] == '.') {
	        			int count = 0, num = 0;
	        			for (int k = 1; k <= 9 && count < 2; k++) {
	        				if (!col.get(i).contains(k) && !row.get(j).contains(k) && !sec.get((i/3)*3+j/3).contains(k) && count < 2) {
	        					count++;
	        					num = k;
	        				}
	        			}
	        			if (count == 1) {
	        				board[i][j] = (char) ('0' + num);
			        		col.get(i).add(num);
			        		row.get(j).add(num);
			        		sec.get((i/3)*3+j/3).add(num);
			        		newc = true;
	        			}
	        			else {
	        				flag = true;
	        			}
	        		}
	        	}
	        }
        }
        dfs(board, col, row, sec);
    }
    public static boolean dfs(char[][] board, ArrayList<HashSet<Integer>> col, ArrayList<HashSet<Integer>> row, ArrayList<HashSet<Integer>> sec) {
        int i = 0;
        while (i < 9 && col.get(i).size() == 9)
        	i++;//different if you write in the while clause.
        if (i == 9) {
        	return true;
        }
        for (i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] == '.') {
        			int k = 1;
        			for (; k <= 9; k++) {
        				if (!col.get(i).contains(k) && !row.get(j).contains(k) && !sec.get((i/3)*3+j/3).contains(k)) {
	        				board[i][j] = (char) ('0' + k);
			        		col.get(i).add(k);
			        		row.get(j).add(k);
			        		sec.get((i/3)*3+j/3).add(k);
			        		if (dfs(board, col, row, sec)) {
			        			return true;
			        		}
	        				board[i][j] = '.';
			        		col.get(i).remove(k);
			        		row.get(j).remove(k);
			        		sec.get((i/3)*3+j/3).remove(k);
        				}
        			}
        			if (k == 10) {
        				return false;
        			}
        		}
        	}
        }
        return false;
	}
    public static void init_array(ArrayList<HashSet<Integer>> a) {
    	for (int i = 0; i < 9; i++) {
    		a.add(new HashSet<Integer>());
    	}
    }
}