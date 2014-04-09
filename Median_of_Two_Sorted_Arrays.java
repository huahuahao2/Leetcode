
public class Median_of_Two_Sorted_Arrays {
	public static void main(String[] args) {
		int[] a = {2,3};
		int[] b = {2,3};
		System.out.println(findMedianSortedArrays(a,b));
	}
    public static double findMedianSortedArrays(int A[], int B[]) {
	    if(A.length+B.length == 0)
	        return 0;
        return find(A, B, A.length/2, B.length/2, (A.length+B.length)/2);
    }
    
    public static double find(int A[], int B[], int i, int j, int m) {
    	if(i<0)
    		return (A.length+B.length)%2 == 0 ? (double)(B[(A.length+B.length)/2]+B[(A.length+B.length)/2 - 1])/2:B[(A.length+B.length)/2];
    	if(i>=A.length) {
    		if((A.length+B.length)%2 == 0) {
    			if((B.length-A.length)/2 == 0)
    				return (double)(B[0]+A[A.length-1])/2;
    			return (double)(B[(B.length-A.length)/2]+B[(B.length-A.length)/2 - 1])/2;
    		}
    		else
    			return B[(B.length-A.length)/2];
    	}
    		//return (A.length+B.length)%2 == 0 ? (double)(B[(B.length-A.length)/2]+B[(B.length-A.length)/2 - 1])/2:B[(B.length-A.length)/2];
    	if(j<0)
    		return (A.length+B.length)%2 == 0 ? (double)(A[(A.length+B.length)/2]+A[(A.length+B.length)/2 - 1])/2:A[(A.length+B.length)/2];
    	if(j>=B.length) {
    		if((A.length+B.length)%2 == 0) {
    			if((A.length-B.length)/2 == 0)
    				return (double)(A[0]+B[B.length-1])/2;
    			return (double)(A[(A.length-B.length)/2]+A[(A.length-B.length)/2 - 1])/2;
    		}
    		else
    			return A[(A.length-B.length)/2];
    	}
    		//return (A.length+B.length)%2 == 0 ? (double)(A[(A.length-B.length)/2]+A[(A.length-B.length)/2 - 1])/2:A[(A.length-B.length)/2];
    	if (A[i] == B[j]) {
			if((A.length+B.length)%2 == 0)
				return (double)(A[i]+B[j])/2.0;
			else
				return B[j];
			return A[i];
		}
		if ((A[i]>B[j] && i == 0)||(A[i]>B[j] && A[i-1]<=B[j])) {
			if((A.length+B.length)%2 == 0)
				return (double)(A[i]+B[j])/2.0;
			else
				return A[i];
		}
		if ((A[i]<B[j] && i == A.length-1)||(A[i]<B[j] && A[i+1]>=B[j])) {
			if((A.length+B.length)%2 == 0)
				return (double)(A[i]+B[j])/2.0;
			else
				return B[j];
		}
		if ((B[j]>A[i] && j == 0)||(B[j]>A[i] && B[j-1]<=A[i])) {
			if((A.length+B.length)%2 == 0)
				return (double)(A[i]+B[j])/2.0;
			else
				return A[i];
		}
		if ((B[j]<A[i] && j == B.length-1)||(B[j]<A[i] && B[j+1]>=A[i])) {
			if((A.length+B.length)%2 == 0)
				return (double)(A[i]+B[j])/2.0;
			else
				return B[j];
		}
		if (A[i]>B[j])
			return find(A, B, i-m/2, j+m/2, m/2);
		if (A[i]<B[j])
			return find(A, B, i+m/2, j-m/2, m/2);
		/*if (A[i]>B[j])
			return find(A, B, i-(m+1)/2, j+(m+1)/2, m/2);
		if (A[i]<B[j])
			return find(A, B, i+(m+1)/2, j-(m+1)/2, m/2);*/
		return 0;
    }
}
