import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Merge_Intervals {
	public static void main(String[] args) {
		List<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(0,2));
		System.out.println(merge(a));
	}
	public static List<Interval> merge(List<Interval> intervals) {
        /*
         * sort the array
         * Object[] a = intervals.toArray();
        int[] sort = new int[a.length];
        for(int i = 0; i < a.length; i++) {
        	Interval x = (Interval) a[i];
        	sort[i] = x.start;
        }*/
		List<Interval> ret = new ArrayList<Interval>();
		Interval[] result = new Interval[intervals.size()];
		for (int i = 0; i < result.length-1; i++) {
			if (result[i].end < result[i+1].start) {
				ret.add(result[i]);
			}
			else {
				result[i+1].start = result[i].start;
				result[i+1].end = Math.max(result[i].end, result[i+1].end);
			}
		}
		ret.add(result[result.length-1]);
        return ret;
    }
    public static List<Interval> merge2(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        //Interval[] result = new Interval[intervals.size()];
        for (int i = 0; i < intervals.size()-1; i++) {
            if (intervals.get(i).end < intervals.get(i+1).start) {
                ret.add(intervals.get(i));
            }
            else {
                intervals.get(i+1).start = intervals.get(i).start;
                intervals.get(i+1).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
            }
        }
        ret.add(intervals.get(intervals.size()-1));
        return ret;
    }

}

