//O(nlogn) cuz use sort;
import java.util.Arrays;


public class Next_Permutation {
	public static void main(String[] args) {
		int[] num = {2,3,1};
		nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
	}
    public static void nextPermutation(int[] num) {
        if(num.length == 0 || num.length == 1)
            return;
        int max = num[num.length-1];
    	int temp = 0;
    	int i = num.length-1;
    	int k = num.length-1;
        for(; i>=0; i--) {
        	if(num[i]<max)
        		break;
        	max = max>num[i]?max:num[i];
        }
        if(i == -1) {
        	Arrays.sort(num);
        	return;
        }
        temp = num[i];
        //Arrays.sort(num);
        Arrays.sort(num, i, num.length);
        while(true) {
        	if (num[k]==temp)
        		break;
        	k--;
        }
        temp = num[k+1];
        for (;k>=i;k--)
        	num[k+1] = num[k];
        num[i] = temp;
    }
    
}
