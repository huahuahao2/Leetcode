public class Search_Insert_Position {
	public int searchInsert(int[] A, int target) {
        return searchInsert(A, target, 0, A.length-1);
    }
    public int searchInsert(int[] A, int target, int i, int j) {
		if (i == j) {
    		if (A[i] == target) {
    			return i;
    		}
    		else if (A[i] > target) {
    			return i;
    		}
    		else {
    			return i + 1;
    		}
      	}
    	if (A[(i+j)/2] < target) {
    		return searchInsert(A, target, (i+j)/2+1, j);
    	}
    	else {
    		return searchInsert(A, target, i, (i+j)/2);
    	}
    }
}