
public class Palindrome_Number {
	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}
    public static boolean isPalindrome(int x) {
    	int i = 1000000000;
    	boolean first = true;
    	if (x == -2147483648)//always remember the bound
    		return false;
    	if (x < 0)
    		return false;//negetive is not palindrome;
    		//x = x * (-1);
    	while(x > 0) {
    		
    		if (first && x/i == 0) {
    			i /= 10;
    			continue;//first case
    		}
    		if (x/i != x%10)
    			return false;
    		first = false;
    		x = (x%i)/10;
    		i /=100;
    	}

        return true;
    }
}
