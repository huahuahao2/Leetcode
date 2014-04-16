
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] A) {
    	int len = 0;
    	if(A.length == 0)
    		return 0;
        for(int i = 0; i<A.length; ) {
        	A[len] = A[i];
        	do {
        		i++;
        		if(i >= A.length)
        			return len+1;
        	}
        	while (A[len] == A[i]);
        	len++;
        }
        return len+1;
    }
}
