import java.util.ArrayList;
import java.util.Arrays;
// O(n3)

public class _4Sum {
	public static void main(String[] args) {
		int[] num = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(fourSum(num,-11).toString());
	}
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	for (int x = 0; x < num.length; x++) {
    		if(x != 0 && num[x] == num[x-1])
    			continue;
    	for (int i = x+1; i < num.length; i++) {
    		//if (num[x]+num[i] > target)//not gonna work
    		//	continue;
    		if (i!=x+1 && num[i] == num[i-1])//for the same;
    		    continue;
    		int cur = -2147483648;
    		for (int j = i+1, k = num.length-1; j < k; ) {
    			if (num[j]+num[k] == -num[i]-num[x]+target) {
    				if(cur == num[j]) {
    					j++;
    					continue;
    				}
    				ArrayList<Integer> sum = new ArrayList<Integer>();
    				sum.add(num[x]);
    				sum.add(num[i]);
    				sum.add(num[j]);
    				sum.add(num[k]);
    				ret.add(sum);
    				cur = num[j];
    				j++;
    				k--;
    			}
    			if (num[j]+num[k] < -num[i]-num[x]+target) {
    				j++;
    				continue;
    			}
    			if (num[j]+num[k] > -num[i]-num[x]+target) {
    				k--;
    				continue;
    			}
    		}
    	}
    	}
    	return ret;
    }
}
