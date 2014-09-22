public class Unique_Paths {
	public int uniquePaths(int m, int n) {
		int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
        	path[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
        	path[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
	        for (int j = 1; j < n; j++) {
	        	path[i][j] = path[i-1][j] + path[i][j-1];
	        }
        }
        return path[m-1][n-1];
    }
    //for unique_path2
    //too lazy to think!
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        path[0][0] = 1-obstacleGrid[0][0];//!forget to judge the impossible 
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0)
        	    path[i][0] = path[i-1][0];
        	else
        	    path[i][0] = 0;
        }
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0)
        	    path[0][j] = path[0][j-1];
        	else
        	    path[0][j] = 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
	        for (int j = 1; j < obstacleGrid[0].length; j++) {
        		if (obstacleGrid[i][j] == 0) 
        			path[i][j] = path[i-1][j] + path[i][j-1];
        		else
        			path[i][j] = 0;
	        }
        }
        return path[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}