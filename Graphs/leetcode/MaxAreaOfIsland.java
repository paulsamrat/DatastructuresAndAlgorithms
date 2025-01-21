package leetcode;

public class MaxAreaOfIsland {
	//https://leetcode.com/problems/max-area-of-island/description/
	
	public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0 ;
        for (int i=0;i<grid.length;i++) {
        	for(int j= 0 ; j < grid[i].length ;j++) {
        		if (grid[i][j] == 1) { //island found
        			int currArea = dfsUtil(grid, i, i);
        			maxArea = Math.max(maxArea, currArea);
        		}
        	}
        }
        return maxArea;
    }
	
	private int dfsUtil(int[][] grid , int rowIdx , int colIdx) {
		//check bounds
		if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[rowIdx].length || grid[rowIdx][colIdx] == 0)
				return 0;
		grid[rowIdx][colIdx] = 0 ; // mark the current island as visited // it has to be island if it comes here 
		int area = 1;
		//lets go in all 4 direction
		area+=dfsUtil(grid, rowIdx+1, colIdx);
		area+=dfsUtil(grid, rowIdx, colIdx+1);
		area+=dfsUtil(grid, rowIdx-1, colIdx);
		area+=dfsUtil(grid, rowIdx, colIdx-1);
		return area;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int area = obj.maxAreaOfIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
									   {0,0,0,0,0,0,0,1,1,1,0,0,0},
									   {0,1,1,0,1,0,0,0,0,0,0,0,0},
									   {0,1,0,0,1,1,0,0,1,0,1,0,0},
									   {0,1,0,0,1,1,0,0,1,1,1,0,0},
									   {0,0,0,0,0,0,0,0,0,0,1,0,0},
									   {0,0,0,0,0,0,0,1,1,1,0,0,0},
									   {0,0,0,0,0,0,0,1,1,0,0,0,0}});
		
		int area1 = obj.maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0,},
		{1, 1, 0, 0, 0},
		{0 ,0 ,1 ,0 ,0},
		{0, 0, 0, 1, 1}});
		System.out.println(area1);
		}

}
