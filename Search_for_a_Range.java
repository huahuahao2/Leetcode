public class Search_for_a_Range {
	public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = low(A, target, 0, A.length-1);
        ret[1] = high(A, target, 0, A.length-1);
        return ret;
    }
    public int low(int[] A, int target, int i, int j) {
    	if (i > j)
    		return -1;
    	else if (i == j) {
    		if (A[i] == target) {
    			return i;
    		}
    		else {
    			return -1;
    		}
    	}
    	if (A[(i+j)/2] < target) {
    		return low(A, target, (i+j)/2+1, j);
    	}
    	else {
    		return low(A, target, i, (i+j)/2);
    	}
    }
    public int high(int[] A, int target, int i, int j) {
    	if (i > j)
    		return -1;
    	else if (i == j) {
    		if (A[i] == target) {
    			return i;
    		}
    		else {
    			return -1;
    		}
    	}
    	if (A[(i+j+1)/2] <= target) {
    		return high(A, target, (i+j+1)/2, j);
    	}
    	else {
    		return high(A, target, i, (i+j+1)/2-1);
    	}
    }

}