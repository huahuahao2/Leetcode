import java.util.Hashtable;


public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		/*int[] numbers  = {2, 7, 11, 15, 7};*/
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
		System.out.println(lengthOfLongestSubstring("wrcbyne"));
		
	}
    public static int lengthOfLongestSubstring(String s) {
    	int max = 0, ret = 0;
        char[] a = s.toCharArray();
        Hashtable<Character, Integer> b = new Hashtable<Character,Integer>();
        for (int i = 0; i < a.length; i++) {
        	if(b.containsKey(a[i])) {
        		if((i-b.get(a[i])) <= max)
        			max = i-b.get(a[i]);
        		else
        			max++;
        		b.remove(a[i]);
        		b.put(a[i], i);
        	}
        	else {
        		b.put(a[i], i);
        		max++;
        	}
        	if (max > ret)
        		ret = max;
        }
        return ret;
    }
}
