import java.util.HashMap;
public class Fraction_to_Recurring_Decimal {
	//be really careful about the 0 and -2147483648 boundary case
	//should think more.
    public String fractionToDecimal(int numerator, int denominator) {
    	String ret = "";
    	long num = (long) numerator;
    	long den = (long) denominator;
    	if ((num < 0 && den > 0) || (num > 0 && den < 0)) {
    		ret += "-";
    		num *= num < 0 ? -1 : 1;
    		den *= den < 0 ? -1 : 1;
    	}
    	ret += String.valueOf(num / den);
    	int reminder = (int)(num % den);
    	HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
    	StringBuilder d = new StringBuilder();
    	int i = 0;
    	while(!set.containsKey(reminder) && reminder != 0){
    		set.put(reminder, i++);
    		d.append(String.valueOf(((long)reminder*10)/den));
    		reminder = (int)(((long)reminder*10)%den);
    	}
    	if (reminder == 0) {
    		if (d.length() == 0) {
    			return ret;
    		}
    		else {
    			ret += ".";
    			ret += d.toString();
    		}
    	}
    	else {
    		ret += ".";
    		int index = set.get(reminder);
    		d.insert(index, '(');
    		d.insert(d.length(), ')');
    		ret += d.toString();
    	}
    	return ret;
    }	
}