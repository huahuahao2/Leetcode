import java.util.Stack;
public class Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
		int ret = s.charAt(0) - 'A' + 1;
        for (int i = 1; i < s.length(); i++) {
        	ret *= 26;
        	ret += s.charAt(i) - 'A' + 1;
        }
        return ret;
    }
    public String convertToTitle(int n) {
        Stack<Character> s = new Stack<Character>();
        while (n != 0) {
            char c = (char)((n-1)%26+'A');
            s.push(c);
            n = (n-1)/26;
        }
        StringBuilder ret = new StringBuilder();
        while (!s.isEmpty()) {
            ret.append(s.pop());
        }
        return ret.toString();
    }    
}