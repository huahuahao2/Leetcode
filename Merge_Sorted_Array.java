
public class Merge_Sorted_Array {
    public void merge(int A[], int m, int B[], int n) {
    	int i = m-1, j = n-1, cur = m+n-1;
        while(i >= 0 && j >= 0) {
        	if(A[i]>B[j]) {
        		A[cur] = A[i];
        		i--;
        	}
        	else {
        		A[cur] = B[j];
        		j--;
        	}
        	cur--;
        }
        while(j>=0) {
        	A[j] = B[j];
        	j--;
        }
    }
    //what you call elegant.
    public void merge(int A[], int m, int B[], int n) {
        for(int k = m+n-1, i = m-1, j = n-1; k >= 0; ) {
            if(i >= 0 && j >= 0) {
                if(A[i]>B[j])
                    A[k--] = A[i--];
                else
                    A[k--] = B[j--];
                continue;
            }
            if (i >= 0)
                A[k--] = A[i--];
            if (j >= 0)
                A[k--] = B[j--];
        }
    }

}
