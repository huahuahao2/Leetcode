//http://www.felix021.com/blog/read.php?2040
//O(n) solution
public class Longest_Palindromic_Substring {
	static public String str;
	static int begin, end, max;
	static boolean find[][];
	static int result[][];
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */

		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
    public static String longestPalindrome(String s) {
    	str = s;
    	find = new boolean[str.length()][str.length()];
    	result = new int[str.length()][str.length()];
    	findPalindrome(0, s.length()-1);
    	//System.out.println(findPalindrome(0, s.length()-1));
    	return str.substring(begin, end+1);
    }
    public static int findPalindrome(int i, int j) {
    	int x = 0, y = 0;
    	if (find[i][j])
    		return result[i][j];
    	find[i][j] = true;
    	if (i > j)
    		return str.charAt(i) == str.charAt(j) ? result[i][j] = 0 : 1;
    	if (i == j)
    		return result[i][j] = 1;
    	if ((x = findPalindrome(i+1,j-1)) == j-i-1)
    		if (str.charAt(i) == str.charAt(j)) {
    			if(x+2 > max) {
    				max = x+2;
    				begin = i;
    				end = j;
    			}
    			return result[i][j] = x+2;
    		}
    	x = findPalindrome(i+1,j);
    	y = findPalindrome(i,j-1);
    	return x>y ? x : y;
    }
    //DPsolution---solution2
    public static String longestPalindrome2(String str) {
    	boolean[][] find = new boolean[str.length()][str.length()];
    	int n = str.length();
    	int max = 0, begin = 0;
    	for(int k = 0; k < n; k++) {
    		find[k][k] = true;
    		max = 1;
    	}
    	for(int k = 0; k<n-1; k++) {
    		if(str.charAt(k) == str.charAt(k+1)) {
    			find[k][k+1] = true;
				max = 2;
				begin = k;
    		}
    	}
    	for(int len = 2; len < n;len++) {
    		for(int k = 0;k<n-len;k++) {
    			if(str.charAt(k) == str.charAt(k+len) && find[k+1][k+len-1]) {
    				find[k][k+len] = true;
    				max = len+1;
    				begin = k;
    			}
    			
    		}
    	}
    	if(max == 0)
    		return str;
    	return str.substring(begin, begin+max);//begin<=sub<begin+max
    }
    //-------solution3----using the 2n-1center
    public String longestPalindrome3(String str) {
        if(str.length()==0)
            return str;
    	int longest = 1, begin = 0;
    	for(int i = 0; i <str.length()-1;i++) {
    		int a = expand(str,i,i);
    		if (a>longest) {
    			longest = a;
    			begin = i-a/2;
    		}
    		a = expand(str,i,i+1);
    		if (a>longest) {
    			longest = a;
    			begin = i-a/2+1;
    		}
    	}
    	return str.substring(begin, begin+longest);
    }
    public int expand(String str, int c1, int c2) {
    	int max = c1==c2?-1:0;
    	for(int i = c1, j = c2; i>=0&& j<str.length();i--,j++) {
    		if(str.charAt(i)!=str.charAt(j))
    			break;
    		max+=2;
    	}
    	return max;
    }
}
