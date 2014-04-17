import java.util.HashSet;
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] num) {
        int max = 0;
        HashSet<Integer> n = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
        	n.add(num[i]);
        }
        for (int i = 0; i < num.length; i++) {
        	int cur = 0, j = num[i];
        	while(n.contains(++j)){
        		n.remove(j);
        		cur++;
        	}
        	j = num[i];
        	while(n.contains(j--)) {
        		n.remove(j+1);
        		cur++;
        	}
        	max = cur>max?cur:max;
        }
        return max;
    }
}
