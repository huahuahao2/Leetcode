
public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ret = -1, cur = 0;
        for(int i = 0; i < gas.length; i++) {
            cur = gas[i];
            for(int j = i; cur >= 0 ; j++) {
                if (i == j-gas.length) {
                    ret = i;
                    return ret;
                }
                if (cur >= cost[j%gas.length]) {
                    cur = cur - cost[j%gas.length] + gas[(j+1)%gas.length];
                }
                else
                    break;
            }
        }
        return ret;
    }
}
