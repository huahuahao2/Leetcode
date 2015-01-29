public class Maximum_Product_Subarray {
	//this program is not hard but all about detail.
	public int maxProduct(int[] A) {
		boolean flag = true;
		int ret = Integer.MIN_VALUE;
		int cur = 1, min = Integer.MIN_VALUE, max = 1;
        for (int i = 0; i < A.length; i++) {
        	if (flag) {
        		cur = 1;
        		min = Integer.MIN_VALUE;
        		max = 1;
        		flag = false;
        	}
        	cur *= A[i];
        	ret = Math.max(A[i], ret);
        	if (cur < 0) {
        		min = Math.max(cur,min);
        		ret = Math.max(min, ret);
        		if (cur != min) {
        			ret = Math.max(cur/min,ret);
        		}
        	}
        	else if (cur > 0) {
        		max = Math.max(cur,max);
        		ret = Math.max(max, ret);
        	}
        	else {
        		
        		flag = true;
        	}
        }
        return ret;
    }
}