
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
    //this problem is more like a mathmatics problem.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, ret = 0;
        int sum_gas = 0, sum_cost = 0;
        for (int i = 0; i < gas.length; i++) {
            sum_gas += gas[i];
            sum_cost += cost[i];
            tank += gas[i]-cost[i];
            if(tank < 0) {//as a new start
                ret = i+1;
                tank = 0;
            }
        }
        
        return sum_gas<sum_cost ? -1 : ret;
    }

}
