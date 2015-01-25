public class Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int v1_x = Integer.parseInt(v1[0]);
        int v2_x = Integer.parseInt(v2[0]);
        if (v1_x != v2_x) {
        	return v1_x > v2_x ? 1 : -1;
        }
        else {
        	int v1_y = Integer.parseInt(v1[0]);
        	int v2_y = Integer.parseInt(v2[0]);
        	if (v1_y == v2_y) {
        		return 0;
        	}
        	else {
        		return v1_y > v2_y ? 1 : -1;
        	}
        }
    }
}