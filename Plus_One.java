

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int k = 0;
    	digits[digits.length-1]++;
        for(int i = digits.length-1; i>=0; i--){
            int temp = digits[i]+k;
        	k = temp/10;
        	digits[i] =  temp%10;
        }
        if(k == 0)
        	return digits;
        else
        {
        	int[] n = new int[digits.length+1];
        	for(int i = n.length-1; i>=1; i--) {
        		n[i] = n[i-1];
        	}
        	n[0] = 1;
        	return n;
        }
    }
}
