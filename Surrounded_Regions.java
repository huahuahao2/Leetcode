import java.util.Arrays;
import java.util.LinkedList;

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
	static class Matrix {
		int x;
		int y;
		Matrix(int x, int y) {this.x = x; this.y = y;}
	}
    public static void solve(char[][] board) {
    	int l = board.length;
    	if (l <= 1)
            return;
        int w = board[0].length;
        if (w <= 1)
            return;
        LinkedList<Matrix> list = new LinkedList<Matrix>();
        int i = 0, j = 0;
        for (; j < w-1; j++) {
        	if(board[i][j] == 'O') {
        		board[i][j] = 'Y';
        		list.add(new Matrix(i,j));
        	}
        }
        for (; i < l-1; i++) {
        	if(board[i][j] == 'O') {
        		board[i][j] = 'Y';
        		list.add(new Matrix(i,j));
        	}
        }
        for (; j > 0; j--) {
        	if(board[i][j] == 'O') {
        		board[i][j] = 'Y';
        		list.add(new Matrix(i,j));
        	}
        }
        for (; i > 0; i--) {
        	if(board[i][j] == 'O') {
        		board[i][j] = 'Y';
        		list.add(new Matrix(i,j));
        	}
        }
        while(!list.isEmpty()) {
        	Matrix cur = list.remove();
        	if(cur.x > 0 && board[cur.x-1][cur.y] == 'O') {
        		board[cur.x-1][cur.y] = 'Y';
        		list.add(new Matrix(cur.x-1,cur.y));
        	}
        	if(cur.x < l-1 && board[cur.x+1][cur.y] == 'O') {
        		board[cur.x+1][cur.y] = 'Y';
        		list.add(new Matrix(cur.x+1,cur.y));
        	}
        	if(cur.y > 0 && board[cur.x][cur.y-1] == 'O') {
        		board[cur.x][cur.y-1] = 'Y';
        		list.add(new Matrix(cur.x,cur.y-1));
        	}
        	if(cur.y < w-1 && board[cur.x][cur.y+1] == 'O') {
        		board[cur.x][cur.y+1] = 'Y';
        		list.add(new Matrix(cur.x,cur.y+1));
        	}
        }
        for(i = 0; i < l; i++)
        	for(j = 0; j < w; j++){
        		if (board[i][j] == 'O')
        			board[i][j] = 'X';
        		if (board[i][j] == 'Y')
        			board[i][j] = 'O';
        	}
    }
}
