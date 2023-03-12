package Backtracking;

public class ratInMaze {
	
	public static void ratinMaze(int[][] maze) {
		int n= maze.length;
		int path[][] = new int[3][3]; 
//		return returnFirstpath(maze, 0, 0, path);
		allPossiblePaths(maze, 0, 0, path);
	} 
	
	public static boolean returnFirstpath(int[][] maze, int i, int j, int[][] path) {
		int n = maze.length;
		if(i<0 || j<0 || i>=n || j>=n || path[i][j]==1 || maze[i][j]==0) {
			return false;
		}
		
		path[i][j]=1;
		if(i==n-1 && j==n-1) {
			for(int m=0; m<n; m++) {
				for (int l=0; l<n; l++) {
					System.out.print(path[m][l]);
				}
				System.out.println();
			}
			
			return true;
		}
		
//		TOp
		if(returnFirstpath(maze, i-1, j, path)){
			return true;
		}
//		right
		if(returnFirstpath(maze, i, j+1, path)){
			return true;
		}
//		down
		if(returnFirstpath(maze, i+1, j, path)){
			return true;
		}
//		left
		if(returnFirstpath(maze, i, j-1, path)){
			return true;
		}
		return false;
		
	}
	
	static void allPossiblePaths(int maze[][], int i, int j, int[][] path){

		int n = maze.length;	
		if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || path[i][j]==1){
			return;
		}

		path[i][j]= 1;

		if(i==n-1 && j==n-1){
			for(int r=0; r<n; r++){
				for(int c=0; c<n; c++){
					System.out.print(path[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();
			path[i][j]=0;
			
			return;
		}

		allPossiblePaths(maze, i-1, j, path); //top
		allPossiblePaths(maze, i+1, j, path); // down
		allPossiblePaths(maze, i, j-1, path); // left
		allPossiblePaths(maze, i, j+1, path); //right
		path[i][j]=0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]maze = {{1,1},{1, 1}};
		ratinMaze(maze);
	}

}
