import java.lang.Math;
import java.util.Arrays;

public class _3Sum_Closest {
	public static void main(String[] args) {
		int[] num = {1,1,1,0};
		System.out.println(threeSumClosest(num,50));
	}
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        if(num.length<3) {
        	return 0;
        }
        int closest = num[0]+num[1]+num[2];
    	for (int i = 0; i < num.length; i++) {
    		for (int j = i+1, k = num.length-1; j < k; ) {
    			if (num[j]+num[k] == -num[i]+target) {
    				return target;
    			}
    			if (num[j]+num[k] < -num[i]+target) {
    				closest = (target - (num[j]+num[k]+num[i])) > Math.abs(target - closest)? closest : num[j]+num[k]+num[i];
    				j++;
    				continue;
    			}
    			if (num[j]+num[k] > -num[i]+target) {
    				closest = (-target + num[j]+num[k]+num[i]) > Math.abs(target - closest)? closest : num[j]+num[k]+num[i];
    				k--;
    				continue;
    			}
    		}
    	}
    	return closest;
    }
}
