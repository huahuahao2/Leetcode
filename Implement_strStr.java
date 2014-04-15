
public class Implement_strStr {
	public static void main(String[] args) {

		System.out.println(strStr("aabab", "ab"));
	}
    public static String strStr(String haystack, String needle) {
    	int min = haystack.length();
    	boolean flag = false;
        for(int i = haystack.length()-needle.length(); i>=0; i--) {
        	int j = 0;
        	for(;j<needle.length();j++) {
        		if(haystack.charAt(i+j)!=needle.charAt(j))
        			break;
        	}
        	if(j == needle.length()) {
        		min = min<i?min:i;
        		flag = true;
        	}
        }
        if(!flag)
            return null;
		else {
			return haystack.substring(min);
	    }
    }
}
