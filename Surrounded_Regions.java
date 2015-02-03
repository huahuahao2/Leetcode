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
		//solve(board);
        solve_2015(board);
		System.out.println(Arrays.toString(board));
		
	}
    //what complicate it more about the BFS.
    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve_2015(char[][] board) {
        if (board.length < 1 || board[0].length < 1)
            return;
        LinkedList<Node> list = new LinkedList<Node>();
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                board[i][0] = 'A';
                list.add(new Node(i,0));
            }
            if(board[0].length-1 != 0 && board[i][board[0].length-1] == 'O') {
                board[i][board[0].length-1] = 'A';
                list.add(new Node(i,board[0].length-1));
            }
        }
        for(int j = 1; j < board[0].length-1; j++) {
            if(board[0][j] == 'O') {
                board[0][j] = 'A';
                list.add(new Node(0,j));
            }
            if(board.length-1 != 0 && board[board.length-1][j] == 'O') {
                board[board.length-1][j] = 'A';
                list.add(new Node(board.length-1,j));
            }
        }
        Node cur = null;
        while(!list.isEmpty()) {
            cur = list.removeFirst();
            if (cur.x-1 >= 0 && board[cur.x-1][cur.y] == 'O') {
                board[cur.x-1][cur.y] = 'A';
                list.add(new Node(cur.x-1, cur.y));
            }
            if (cur.x+1 < board.length && board[cur.x+1][cur.y] == 'O') {
                board[cur.x+1][cur.y] = 'A';
                list.add(new Node(cur.x+1, cur.y));
            }
            if (cur.y-1 >= 0 && board[cur.x][cur.y-1] == 'O') {
                board[cur.x][cur.y-1] = 'A';
                list.add(new Node(cur.x, cur.y-1));
            }
            if (cur.y+1 < board[0].length && board[cur.x][cur.y+1] == 'O') {
                board[cur.x][cur.y+1] = 'A';
                list.add(new Node(cur.x, cur.y+1));
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') 
                    board[i][j] = 'X';
                if(board[i][j] == 'A') 
                    board[i][j] = 'O';
            }
        }
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
