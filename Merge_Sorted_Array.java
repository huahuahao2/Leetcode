
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
}
