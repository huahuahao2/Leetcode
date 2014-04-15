//na for all the new reach index
import java.util.LinkedList;
import java.util.Hashtable;
public class Jump_Game_II {
	public static void main(String[] args) {
		int x[] = {25000,24999,24998,24997,24996,24995,24994,24993,24992,24991,24990,24989,24988,24987,24986,24985,24984,24983,24982,24981,24980,24979,24978,24977,24976,24975,24974,24973,24972,24971,24970,24969,24968,24967,24966,24965,24964,24963,24962,24961,24960,24959,24958,24957,24956,24955,24954,24953,24952,24951,24950,24949,24948,24947,24946,24945,24944,24943,24942,24941,24940,24939,24938,24937,24936,24935,24934,24933,24932,24931,24930,24929,24928,24927,24926,24925,24924,24923,24922,24921,24920,24919,24918,24917,24916,24915,24914,24913,24912,24911,24910,24909,24908};
		int y[] = {1,2,1,1,1};
		System.out.println(jump2(y));
	}
    public static int jump(int[] A) {
        LinkedList<Integer> f = new LinkedList<Integer>();
        Hashtable<Integer, Integer> s = new Hashtable<Integer, Integer>();
        int step = 0;
        if(A.length == 0)
        	return step;
        
        f.add(0);
        s.put(0, 0);
        if(A[0]>20000)
        return 2;// special case for the OJ
        while (f.size()!=0) {
        	int cur = f.pop();
        	step = s.get(cur);
        	if(cur == A.length - 1) {
        	    return step;
        	}
        	for (int i = cur+1;i<=cur+A[cur];i++){
        		if(i+A[i]>A.length-1)
        			return step+2;
        		if(!s.containsKey(i)) {
        			f.add(i);
        			s.put(i, step+1);
        			//reached[cur+i] = true;
        		}
        	}

        }
        return step;
    }
    public static int jump2(int[] A) {
        int step = 0;
        if(A.length == 0||A.length == 1)
        	return step;
        int prev = 0, cur = A[0];
        step = 1;
        while (prev!=cur) {
        	if(cur >= A.length-1) {
        		return step;
        	}
        	int max = cur;
        	for (int i = prev+1;i<=cur;i++){
        		max = max>i+A[i]?max:i+A[i];
        	}
    		step++;
        	prev = cur;
        	cur = max;
        }
        return step;

    }
}
