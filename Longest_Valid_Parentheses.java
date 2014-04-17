//idea here:
//link the pair together see if it have larger parent.
public class Longest_Valid_Parentheses {
	public static void main(String[] args) {

		System.out.println(longestValidParentheses("(()"));

	}

	public static int longestValidParentheses(String s) {
		// boolean[][] check = new boolean[s.length()][s.length()];
		int n = s.length();
		boolean[] c = new boolean[n];
		int[] d = new int[n];

		int max = 0;
		for (int k = 0; k < n - 1; k++) {
			if (s.charAt(k) == '(' && s.charAt(k + 1) == ')') {
				c[k] = true;
				d[k] = 2;
				max = 2;
			}
		}
		boolean change = max == 2 ? true : false;
		while (change) {
			max = merge(c, d, n);
			change = false;
			for (int k = 0; k < n - 1;) {
				if (!c[k]) {
					if (c[k + 1] && s.charAt(k) == '('
							&& (k + 1 + d[k + 1]) <n &&s.charAt(k + 1 + d[k + 1]) == ')') {
						change = true;
						d[k] = d[k + 1] + 2;
						c[k] = true;
						c[k + 1] = false;
						k = k + d[k];
					} else
						k++;
				} else
					k = k + d[k];
			}

		}

		return max;
	}

	public static int merge(boolean[] c, int[] d, int n) {
		int max = 2;
		for (int i = 0; i < n;) {
			if (c[i]) {
				int temp = i;
				while (i<n && c[i]) {
					c[i] = false;
					i += d[i];
				}
				c[temp] = true;
				d[temp] = i - temp;
				max = max>d[temp]?max:d[temp];
			} else
				i++;
		}
		return max;
	}
}
