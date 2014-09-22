public class Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
        	path[i][0] = path[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
        	path[0][j] = path[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
	        for (int j = 1; j < grid[0].length; j++) {
	        	path[i][j] = (path[i-1][j] > path[i][j-1] ? path[i][j-1] : path[i-1][j]) + grid[i][j];
	        }
        }
        return path[grid.length-1][grid[0].length-1];
    }
}