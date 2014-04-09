
public class Reverse_Integer {
	public static void main(String[] args) {
		/* case 10, what to get when reverse */
		/* case 1000000003, handle overflow */
		System.out.println(reverse(1000000003));
	}
    public static int reverse(int x) {
    	int neg = (x < 0)? -1:1;
        int ret = 0;
        x *= neg;
        while (x/10 != 0) {
        	ret = ret*10 + x%10;
        	x /= 10;
        }
    	if((long)ret*10 + (long)x > 2147483647L)
    		return 2147483647;
        ret = ret*10 + x;
        return ret*neg;
    }
}
