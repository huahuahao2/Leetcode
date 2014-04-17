//Fibonacci
public class Climbing_Stairs {
    public int climbStairs(int n) {
    	int a = 1, b = 2, ret = 0;
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
        for(int i = 3; i <= n;i++) {
        	ret = a+b;
        	a = b;
        	b = ret;
        }
        return ret;
    }
}
