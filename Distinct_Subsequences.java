
public class Distinct_Subsequences {
	int count;
    public int numDistinct(String S, String T) {
    	count = 0;
        return count;
    }
    public void find(String S, String T, int s, int t) {
    	if (t == T.length())
    		count++;
    	for(int i = s; i < S.length(); i++) {
    		if (S.charAt(i) == T.charAt(t))
    			find(S, T, s+1, t+1);
    	}
    }
    
    
    
    /*https://oj.leetcode.com/discuss/2143/any-better-solution-that-takes-less-than-space-while-in-time*/
    /*
     * Solution (DP):
     * We keep a m*n matrix and scanning through string S, while
     * m = T.length() + 1 and n = S.length() + 1
     * and each cell in matrix Path[i][j] means the number of distinct subsequences of 
     * T.substr(1...i) in S(1...j)
     * 
     * Path[i][j] = Path[i][j-1]            (discard S[j])
     *              +     Path[i-1][j-1]    (S[j] == T[i] and we are going to use S[j])
     *                 or 0                 (S[j] != T[i] so we could not use S[j])
     * while Path[0][j] = 1 and Path[i][0] = 0.
     */
	public static void main(String[] args) {
		System.out.println(numDistinct2("ccc", "c"));
	}
    public static int numDistinct2(String S, String T) {
        int[] c = new int[S.length()+1];
        for (int j = 0; j < c.length; j++) 
        	c[j] = 1;
		for (int i = 0; i < T.length(); i++) {
			int prev = c[i];
			c[i] = 0;
	        for (int j = i+1; j < c.length; j++) {
	        	int cur = c[j-1] + (S.charAt(j-1) == T.charAt(i) ? prev : 0);//bracket is important
	        	prev = c[j];
	        	c[j] = cur;
	        }
		}
        return c[S.length()];
    }

    
    
    
}
