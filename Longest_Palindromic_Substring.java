
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
}
