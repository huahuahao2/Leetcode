import java.util.ArrayList;
import java.util.Arrays;
public class _3Sum {
	public static void main(String[] args) {
		int[] num = {3,0,-2,-1,1,2};
		System.out.println(threeSum(num).toString());
	}
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	int same = 1;
    	int same2 = -2147483648;
    	for (int i = 0; i < num.length; i++) {
    		if (num[i] > 0)
    			return ret;
    		if (num[i] == same)
    		    continue;

    		for (int j = i+1, k = num.length-1; j < k; ) {
    			if (num[j]+num[k] == -num[i]) {
        		    if (num[j] == same2 && num[i] == same){
        		    	j++;
        		        continue;
        		    }
        		    else {
        		        same2 = num[j];
        		        same = num[i];
        		    }
    				ArrayList<Integer> sum = new ArrayList<Integer>();
    				sum.add(num[i]);
    				sum.add(num[j]);
    				sum.add(num[k]);
    				ret.add(sum);
    				j++;
    				k--;
    			}
    			if (num[j]+num[k] < -num[i]) {
    				j++;
    				continue;
    			}
    			if (num[j]+num[k] > -num[i]) {
    				k--;
    				continue;
    			}
    		}
    	}
    	return ret;
    }
}
