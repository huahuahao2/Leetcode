
public class String_to_Integer_atoi {
	public static void main(String[] args) {
		System.out.println(atoi("      -11919730356x"));
	}
    public static int atoi(String str) {
    	int flag = 1, ret = 0, i = 0;
        str = str.trim();
        if (str.length() == 0 || (!symbol(str.charAt(0)) && !check(str.charAt(0))) || (str.length() == 1 && symbol(str.charAt(0))) || (str.length() > 1 && symbol(str.charAt(0)) && !check(str.charAt(1))))
        	return 0;
        if (str.charAt(0) == '-') {
        	flag = -1;
        	i++;
        }
        if (str.charAt(0) == '+')
        	i++;
        for (; i < str.length() && check(str.charAt(i)); i++) {//condition's order is very important.
        	if((long)ret*flag+(long)(str.charAt(i) - '0') >= 2147483647L - (flag-1)/2)
        		return 2147483647*flag + (flag-1)/2;
        	ret += (str.charAt(i) - '0')*flag;
        	if (ret*flag <= 214748364)
        		ret *= 10;
        	else {
        		i++;
        		if(i >= str.length() || !check(str.charAt(i)))
        				return ret;
        		else
        			return flag ==1? 2147483647:-2147483648;
        	}
        }

        ret /= 10;
        return ret;
    }
    public static boolean check(char c) {
    	switch (c) {
    		case '0': ;
    		case '1': ;
    		case '2': ;
    		case '3': ;
    		case '4': ;
    		case '5': ;
    		case '6': ;
    		case '7': ;
    		case '8': ;
    		case '9': return true;
    		default: return false;
    	}
    }
    public static boolean symbol(char c) {
    	if (c == '+' || c == '-')
    		return true;
    	return false;
    }
}
