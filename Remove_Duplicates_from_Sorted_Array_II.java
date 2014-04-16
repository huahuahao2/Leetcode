
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] A) {
        int len = 0;
    	if(A.length == 0)
    		return 0;
        for(int i = 0; i<A.length; ) {
        	A[len] = A[i];
        	int times = 1;
        	do {
        	    if(times == 2) {
        			len++;
        			A[len] = A[len-1];
        		}
        		i++;
        		if(i >= A.length)
        			return len+1;
        		times++;
        	}
        	while (A[len] == A[i]);
        	len++;
        }
        return len+1;
    }
}
