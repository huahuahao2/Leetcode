class Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int index = searchMatrix(matrix, target, 0, matrix.length-1);
        if (index == -1) {
        	return false;
        }
        return search(matrix[index], target, 0, matrix[index].length-1);
    }
    public static int searchMatrix(int[][] matrix, int target, int start, int end) {
		if (start == end) {
			return start;        	
		}
		else if (start > end) {
			return -1;
		}
		if (matrix[(start+end+1)/2][0] <= target) {
			//be extra careful about the bound!
			return searchMatrix(matrix, target, (start+end+1)/2, end);
		}
		else {
			return searchMatrix(matrix, target, start, (start+end+1)/2-1);
		}
    }
    public static boolean search(int[] a, int target, int start, int end) {
    	if (end < start) {
    		return false;
    	}
    	if (a[(start+end)/2] > target) {
    		return search(a, target, start, (start+end)/2-1);
    	}
    	else if (a[(start+end)/2] < target) {
    		return search(a, target, (start+end)/2+1, end);
    	}
    	else
    		return true;
    }
}
