
public class Interleaving_String {
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
        	return false;
        return isInterleave(s1, s2, s3, 0 , 0);
    }
    public static boolean isInterleave(String s1, String s2, String s3, int i, int j) { 
    	while (i < s1.length() && j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
    		if (s3.charAt(i+j) == s1.charAt(i)) {
    			i++;
    		}
    		else if (s3.charAt(i+j) == s2.charAt(j)) {
    			j++;
    		}
    		else
    			return false;
    	}
    	if ( i + j == s3.length())
    		return true;
    	else if (i == s1.length()) {
    		while (j < s2.length() && s3.charAt(i+j) == s2.charAt(j)) {
    			j++;
    		}
    		if (j == s2.length())
    			return true;
    		else
    			return false;
    	}
    	else if (j == s2.length()) {
    		while (i < s1.length() && s3.charAt(i+j) == s1.charAt(i)) {
    			i++;
    		}
    		if (i == s1.length())
    			return true;
    		else
    			return false;
    	}
    	else {
    		if (isInterleave(s1, s2, s3, i+1, j))
    			return true;
    		else
    			return isInterleave(s1, s2, s3, i, j+1);
    	}
    }
    /*
     * define the opt[i][j] as if we can use first i characters from s1 and first j characters from s2 to generate the s3 with length i+j.
     * opt[0][0] = true
     * return opt[n][m]
     */
    public static boolean isInterleave2(String s1, String s2, String s3) {
    	boolean[][] opt = new boolean[s1.length()+1][s2.length()+1];
    	opt[0][0] = true;
    	for (int i = 1; i <= s3.length(); i++) {
    		for (int j = 0 ; j <= i ; j++) {
    			opt[j][i-j] = false;
    		}
    	}
        return isInterleave(s1, s2, s3, 0 , 0);
    }
}
