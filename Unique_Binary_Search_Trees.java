
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
    	int[] sum = new int[n+1];
    	sum[0] = 0;
    	sum[1] = 1;
    	int k = 0;
    	for(int i = 2; i<=n; i++) {
    		k = 0;
    		for (int j = 1; j <= i; j++) {
    			k+=sum[i-j]*sum[j-1];
    		}
    		sum[i] = k;
    	}
    	return sum[n];
    }

    public int numTrees(int n) {
        int[] opt = new int[n+1];
        opt[0] = 1;
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= k; i++) 
                opt[k] += opt[i-1]*opt[k-i];
        return opt[n];
    }

}
