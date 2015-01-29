public class Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < v1.length && i < v2.length) {
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            if (n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
            else
                i++;
        }
        while (i < v1.length) {
            int n1 = Integer.parseInt(v1[i]);
            if (n1 == 0)
                i++;
            else
                return 1;
        }
        while (i < v2.length) {
            int n2 = Integer.parseInt(v2[i]);
            if (n2 == 0)
                i++;
            else
                return -1;
        }
        return 0;
    }
}