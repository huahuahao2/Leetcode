public class Dungeon_Game {
	//recursive way get TLE
	public int all_min = Integer.MIN_VALUE;
	public int calculateMinimumHP(int[][] dungeon) {
		calculateMinimumHP(dungeon,0,0,0,0);
		if (all_min >= 0)
			return 0;
		else
			return -all_min+1;
    }
    //TLE don't know why
    public void calculateMinimumHP(int[][] dungeon, int i, int j, int blood, int cur_min) {
    	blood += dungeon[i][j];
    	if (blood < cur_min) {
    		cur_min = blood;
    	}
    	if (cur_min < all_min)
    		return;
    	if (i == dungeon.length-1 && j == dungeon[0].length-1) {
    		if (cur_min > all_min ) {
    			all_min = cur_min;
    		}
    	}
    	if (i < dungeon.length-1) {
			calculateMinimumHP(dungeon, i+1, j, blood, cur_min);
    	}
    	if (j < dungeon[0].length-1) {
			calculateMinimumHP(dungeon, i, j+1, blood, cur_min);
    	}
    }
    //DP
    //failed when you think from left to right problem is 
    //there might exist a big negtive number which makes you choose to go to a large positive first
    //or in the end only a positive exist makes you go to all the small negatives
    //Wrong idea.
    public int calculateMinimumHP_DP(int[][] dungeon) {
    	int[] compute = new int[dungeon[0].length];
    	compute[0] = dungeon[0][0];
    	for (int i = 1; i < compute.length; i++) {
    		compute[i] = compute[i-1] + dungeon[0][i];
    	}
    	for (int j = 1; j < dungeon.length; j++) {
    		compute[0] = dungeon[j][0];
    		for (int i = 1; i < compute.length; i++) {
    			compute[i] = Math.min(compute[i-1] + dungeon[j][i], compute[i] + dungeon[j][i]);
    		}
    	}
    	return compute[compute.length-1];
    }
    //bottom up.
    public int calculateMinimumHP_DP2(int[][] dungeon) {
    	int[][] hp = new int[dungeon.length+1][dungeon[0].length+1];
    	hp[dungeon.length][dungeon[0].length - 1] = 1;
    	hp[dungeon.length - 1][dungeon[0].length] = 1;
    	for (int i = dungeon[0].length-2; i >= 0; i--) {
    		hp[dungeon.length][i] = Integer.MAX_VALUE;
    	}
    	for (int i = dungeon.length-2; i >= 0; i--) {
    		hp[i][dungeon[0].length] = Integer.MAX_VALUE;
    	}
    	for (int j = dungeon.length-1; j >= 0; j--) {
    		for (int i = dungeon[0].length-1; i >= 0; i--) {
    			hp[j][i] = Math.min(hp[j+1][i], hp[j][i+1])-dungeon[j][i];
    			hp[j][i] = hp[j][i] <= 0 ? 1 : hp[j][i];
    		}
    	}
    	return hp[0][0];
    }
}