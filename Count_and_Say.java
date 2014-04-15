import java.util.ArrayList;

public class Count_and_Say {
	public static void main(String[] args) {
		System.out.println(countAndSay(9));
		System.out.println(trans(11));
		System.out.println(trans(21));
		System.out.println(trans(1211));
	}
    public static String countAndSay(int n) {
    	//long x = 1;
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	StringBuffer ret = new StringBuffer();
    	a.add(1);
        for(int i = 1; i < n; i++) {
        	a = transa(a);
        }
        for (int i = 0; i < a.size(); i++) {
        	ret.append(a.get(i));
        }
        return ret.toString();
    }
    public static long trans(long n) {
    	long ret =0;
    	long cur = n;
    	long old = cur%10;
    	int j = 1, i = 0;
        for(; cur!=0; cur /= 10) {
        	if(old == (cur%10)) {
        		i++;
        	}
        	else {
        		ret += j*old;
        		j *= 10;
        		ret += j*i;
        		old = cur%10;
        		i = 1;
        		j*=10;
        	}
        }
		ret += j*old;
		j *= 10;
		ret += j*(i);
        return ret;
    }
    public static ArrayList<Integer> transa(ArrayList<Integer> x) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	int old = x.get(0);
    	int count =0;
    	//int k =0;
    	for(int i = 0; i < x.size(); i++) {
        	if(old == x.get(i)) {
        		count++;
        	}
        	else {
        		ret.add(count);
        		ret.add(old);
        		old = x.get(i);
        		count = 1;
        	}
    	}
		ret.add(count);
		ret.add(old);
    	return ret;
    }
}
