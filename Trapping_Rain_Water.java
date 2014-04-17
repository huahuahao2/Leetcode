public class Trapping_Rain_Water {
	public int trap(int[] A) {
		if (A.length <= 2)
			return 0;

		int rain = 0, block = 0, eindex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[eindex]) {
				rain += (i - eindex - 1) * A[eindex] - block;
				block = 0;
				eindex = i;
			} else
				block += A[i];
		}
		int maxindex = eindex;
		eindex = A.length - 1;
		block = 0;
		for (int i = A.length - 2; i >= maxindex; i--) {
			if (A[i] >= A[eindex]) {
				rain += (eindex - i - 1) * A[eindex] - block;
				block = 0;
				eindex = i;
			} else
				block += A[i];
		}
		return rain;
	}
}
