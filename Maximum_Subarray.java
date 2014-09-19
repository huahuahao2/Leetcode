public class Maximum_Subarray {
	public static void main(String[] args) {
		int[] test = {-2};
		System.out.println(maxSubArray2(test));
	}
	// for this problem is not hard. You have to be more careful about every case.
	public static int maxSubArray(int[] A) {
		int ret = A[0];
		int min = 0;
		int sum = 0;
        for (int i = 0; i < A.length; i++) {
        	sum += A[i];
        	if (sum > min) {
        	
        		ret = ret > (sum - min) ? ret : (sum - min);
        	}
        	else
        		min = sum;
        }
        if (ret < 0) {
        	for (int i : A) {
        		ret = i > ret ? i : ret;
        	}
        }
        return ret;
    }
    //dp is the best approach.
    public static int maxSubArray2(int A[]) {
    	int n = A.length;
        int max = A[0];
        for(int i = 1; i < n; ++i)
        {
            if(A[i - 1] >= 0) A[i] += A[i - 1];
            if(max < A[i]) max = A[i];
        }
        return max;
    }
}