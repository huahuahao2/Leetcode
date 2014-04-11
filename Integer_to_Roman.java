
public class Integer_to_Roman {
	public static void main(String[] args) {
		System.out.println(intToRoman(207));
	}
    public static String intToRoman(int num) {
        StringBuffer ret = new StringBuffer();

        int i = 0;
        for (i = num/1000; i>0; i--)
        	ret.append('M');
        i = (num%1000)/100;
    	if (i < 4) {
    		while (i > 0) {
    			ret.append('C');
    			i--;
    		}
    	}
    	if (i == 4)
    		ret.append("CD");
    	if (i >= 5 && i < 9) {
    		ret.append('D');
    		while (i >5) {
    			ret.append('C');
    			i--;
    		}
    	}
    	if (i==9)
    		ret.append("CM");
    	//...............................
        i = (num%100)/10;
    	if (i < 4) {
    		while (i > 0) {
    			ret.append('X');
    			i--;
    		}
    	}
    	if (i == 4)
    		ret.append("XL");
    	if (i >= 5 && i < 9) {
    		ret.append('L');
    		while (i >5) {
    			ret.append('X');
    			i--;
    		}
    	}
    	if (i==9)
    		ret.append("XC");
    	//...............................
        i = num%10;
    	if (i < 4) {
    		while (i > 0) {
    			ret.append('I');
    			i--;
    		}
    	}
    	if (i == 4)
    		ret.append("IV");
    	if (i >= 5 && i < 9) {
    		ret.append('V');
    		while (i >5) {
    			ret.append('I');
    			i--;
    		}
    	}
    	if (i==9)
    		ret.append("IX");
    	
    	return ret.toString();
    }
}
