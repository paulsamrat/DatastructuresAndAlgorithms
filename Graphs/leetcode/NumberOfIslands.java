package leetcode;

public class NumberOfIslands {

	private static int noOfIslands(final String[][] graph) {
		//iterate through 2d array
		if (null == graph || graph.length == 0) return 0;
		final boolean visited[][] = new boolean[graph.length][graph[0].length];
		int noOfIslands = 0 ;
		for (int i = 0 ; i < graph.length ; i++) {
			for (int j = 0 ; j < graph[i].length; j++) {
				 if (graph[i][j] == "1" && !visited[i][j]) {
					 dfsUtil(i,j,visited ,graph);
					 ++noOfIslands;
				 }
			}
		}
		return noOfIslands;
	}
	private static void dfsUtil(int rowIdx , int colIdx , final boolean[][] visited , final String [][] graph) {
		//check the boundaries
		if (rowIdx<0 || rowIdx > graph.length-1 || colIdx < 0 || colIdx > graph[0].length-1 || visited[rowIdx][colIdx] || graph[rowIdx][colIdx] == "0")
			return;
		visited[rowIdx][colIdx] = true;
		dfsUtil(rowIdx-1 ,colIdx ,visited ,graph);
		dfsUtil(rowIdx+1 , colIdx ,visited ,graph);
		dfsUtil(rowIdx , colIdx-1 ,visited ,graph);
		dfsUtil(rowIdx ,colIdx+1 ,visited ,graph);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] grid = new String[][]{
			
			{"1","1","0","0","0"},
			{"1","1","0","0","0"},
			{"0","0","1","0","0"},
			{"0","0","0","1","1"}
		};
		String[][] grid1 = new String[][]{
			{"1","1","1","1","0"},
			{"1","1","0","1","0"},
			{"1","1","0","0","0"},
			{"0","0","0","0","0"}
		};
		System.out.println(noOfIslands(grid1));
	}

}
