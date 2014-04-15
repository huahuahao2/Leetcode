//when you think about duplicate use hashtable
import java.util.Hashtable;

public class First_Missing_Positive {
	public static void main(String[] args) {
		int[] a = { 3, 0, 4, 4 };
		System.out.println(firstMissingPositive(a));

	}

	public static int firstMissingPositive(int[] A) {
		Hashtable<Integer, Integer> track = new Hashtable<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if (!track.containsKey(A[i])) {
					track.put(A[i], 0);
					max = max > A[i] ? max : A[i];
				}
			}
		}
		if (track.size() == max)
			return max + 1;
		else {
			for (int i = 1; i < max; i++) {
				if (!track.containsKey(i))
					return i;
			}
		}
		return 0;
	}
}
