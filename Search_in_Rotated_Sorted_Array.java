import java.util.Arrays;


public class Search_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		//int x[] = {25000,24999,24998,24997,24996,24995,24994,24993,24992,24991,24990,24989,24988,24987,24986,24985,24984,24983,24982,24981,24980,24979,24978,24977,24976,24975,24974,24973,24972,24971,24970,24969,24968,24967,24966,24965,24964,24963,24962,24961,24960,24959,24958,24957,24956,24955,24954,24953,24952,24951,24950,24949,24948,24947,24946,24945,24944,24943,24942,24941,24940,24939,24938,24937,24936,24935,24934,24933,24932,24931,24930,24929,24928,24927,24926,24925,24924,24923,24922,24921,24920,24919,24918,24917,24916,24915,24914,24913,24912,24911,24910,24909,24908};
		int y[] = {2,3,4,5,0,1};
		//System.out.println(find(y, 0, y.length-1, 7));
		System.out.println(findpivot(y, 0, y.length-1));
		System.out.println(search(y, 2));
	}
    public static int search(int[] A, int target) {
    	if(A.length == 0)
    		return -1;
    	int pivot = findpivot(A, 0, A.length-1);
        if (A[0] > A[A.length-1]) {
        	if (target == A[0])
        		return 0;
        	if (target == A[A.length-1])
        		return A.length-1;
        	if (target < A[0] && target > A[A.length-1])
        		return -1;
        	if (target > A[0])
        		return find(A, 0, pivot-1, target);
        	if (target < A[A.length-1])
        		return find(A, pivot, A.length-1, target);
        	return -1;
        }
        else
        	return find(A, 0, A.length-1, target);
    }
    public static int find(int[] A, int low, int high, int target) {//binary search
    	int mid = (low+high+1)/2;
    	if(target < A[low] || target > A[high] || low > high)
    		return -1;
    	if(low == high)
    		return low;
    	if(target >= A[mid]) {
    		return find(A, mid, high,target);
    	}
    	else
    		return find(A, low, mid-1,target);
    }
    public static int findpivot(int[] A, int low, int high) {
    	int mid = (low+high+1)/2;
    	if (A[low]>A[high]) {
    		if (A[mid]>=A[high])
    			return findpivot(A,mid,high);
    		if (A[low]>=A[mid])
    			return findpivot(A,low,mid);
    			
    	}
    	return low;
    }
}
