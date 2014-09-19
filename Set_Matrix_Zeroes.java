public class Set_Matrix_Zeroes {
	//space O(n+m)
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}        		
        	}
        }
        for (int i = 0; i < matrix.length; i++) {
        	if (row[i]) {
        		setRow(matrix, i);
        	}
        }
    	for (int j = 0; j < matrix[0].length; j++) {
			if (col[j]) {
				setCol(matrix, j);
			}        		
    	}
    }
    public void setRow(int[][] matrix, int i) {
    	for (int j = 0; j < matrix[0].length; j++) {
    		matrix[i][j] = 0;
    	}
    }
    public void setCol(int[][] matrix, int j) {
    	for (int i = 0; i < matrix.length; i++) {
    		matrix[i][j] = 0;
    	}
    }
    //constant space.
    public void setZeroes2(int[][] matrix) {
    	int first_row = -1;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (first_row == -1) {
						first_row = i;
						for (j = 0; j < matrix[0].length; j++) {
							if (matrix[i][j] == 0) {
								matrix[i][j] = 1;
							}
							else {
								matrix[i][j] = 0;
							}
						}
					}
					else {
						for (j = 0; j < matrix[0].length; j++) {
							if (matrix[i][j] == 0) {
								matrix[first_row][j] = 1;
							}
							matrix[i][j] = 0;
						}
					}

				}        		
        	}
        }
        if (first_row != -1) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[first_row][j] == 1) {
        			setCol(matrix, j);
        			//matrix[first_row][j] = 0;
        		}
        	}
        }
    }
}