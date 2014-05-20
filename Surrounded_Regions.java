import java.util.Arrays;

//observe the characteristic that only O in the 4 sides should not be clear out.
public class Surrounded_Regions {
	public static void main(String[] args) {
		char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++)
        	for (int j = 0; j < board[0].length; j++) {
        		/*if ((i+j)%2 == 1)
        			board[i][j] = 'O';
        		else
        			board[i][j] = 'X';*/
        		board[i][j] = 'X';
        	}
        board[1][1] = 'O';
		solve(board);
		//System.out.println(Arrays.toString(num));
		
	}
    public static void solve(char[][] board) {
    	int l = board.length;
        int w = board[0].length;
        boolean[][] check = new boolean[l][w];
        int i = 0, j = 0;
        for (; j < w-1; j++) {
        	int x = i;
        	while(x < l-1 && board[x][j] == 'O') {
        		check[x][j] = true;
        		x++;
        	}
        }
        
        for (; i < l-1; i++) {
        	int x = j;
        	while(x > 0 && board[i][x] == 'O') {
        		check[i][x] = true;
        		x--;
        	}
        }
        
        for (; j > 0; j--) {
        	int x = i;
        	while(x > 0 && board[x][j] == 'O') {
        		check[x][j] = true;
        		x--;
        	}
        }
        for (; i > 0; i--) {
        	int x = j;
        	while(x < w-1 && board[i][x] == 'O') {
        		check[i][x] = true;
        		x++;
        	}
        }
        
        for (; i < l; i++)
        	for (; j < w; j++) {
        		if (!check[i][j])
        			board[i][j] = 'X';
        	}
    }
}
