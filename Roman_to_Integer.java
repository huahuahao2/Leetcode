import java.util.HashMap;
public class Roman_to_Integer {
	public static void main(String[] args) {
		System.out.println(romanToInt("CCVII"));
	}
    public static int romanToInt(String s) {
    	int ret = 0;
    	if (s.length() == 0)
    		return 0;
    	HashMap<Character, Integer> n = new HashMap<Character, Integer>();
		n.put('M', 1000);
		n.put('D', 500);
		n.put('C', 100);
		n.put('L', 50);
		n.put('X', 10);
		n.put('V', 5);
		n.put('I', 1);
		int last = n.get(s.charAt(0));
		ret = last;
        for (int i = 1; i < s.length(); i++) {
        	if (last < n.get(s.charAt(i)))
        		ret =  ret -2*last + n.get(s.charAt(i));
        	else
        		ret += n.get(s.charAt(i));
        	last = n.get(s.charAt(i));
        }
        return ret;
    }
}
