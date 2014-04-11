
public class Regular_Expression_Matching {
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "a.b"));
	}
    public static boolean isMatch(String s, String p) {
    	int j = s.length()-1;
    	
    	for (int i = p.length()-1; i>=0; i--) {
    		if(p.charAt(i) == '*')
    		{
    			i--;
				if(isMatch(s.substring(0, j+1), p.substring(0, i)))
					return true;
    			while((j>=0)&&(s.charAt(j) == p.charAt(i) || p.charAt(i) == '.')) {
    				j--;
    				if(isMatch(s.substring(0, j+1), p.substring(0, i)))
    					return true;
    			}
    			return false;
    		}
    		else {
    			if(j<0)
    				return false;
    			if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.')
    				j--;
    			else
    				return false;
    		}
    	}
    	if (j<0)
    		return true;
        return false;
    }
}
