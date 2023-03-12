package graph;

import java.util.Queue;

//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;


public class Graph {
	
	
	public static ArrayList<Integer> getPathBFS(int [][] adjMatix, int source, int destination){
		Queue <Integer> pendingVertices = new LinkedList<>();
		boolean [] visited = new boolean[adjMatix.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		visited[source] =true;
		pendingVertices.add(source);
		map.put(source, -1);
		boolean pathFound=false;
		
		while(!pendingVertices.isEmpty()){
			int curr = pendingVertices.poll();
			for(int i=0; i<adjMatix.length; i++){
				if(adjMatix[curr][i]==1 && visited[i]==false){
					pendingVertices.add(i);
					visited[i]=true;
					map.put(i,curr);
					if (i == destination) {
						pathFound=true;				
						break;
					}
				}
			}
			
		}

		if(pathFound==true){
			ArrayList<Integer> output = new ArrayList<>();
			int currVertex = destination;
			while(currVertex != -1) {
				output.add(currVertex);
				int parent = map.get(currVertex);
				currVertex = parent;
			}
			return output;
		}else{
			return null;
		}
	}
	
	
	public static void breadthFirstTraversal(int adjMatrix[][]) {
		Queue<Integer> pendingVertex = new LinkedList<>();
		boolean visited[] = new boolean[adjMatrix.length];
		for(int j=0; j<adjMatrix.length; j++) {
			if(!visited[j]) {
				
				visited[j]=true;
				pendingVertex.add(j);
				while(!pendingVertex.isEmpty()){
					int curr = pendingVertex.poll();
					for(int i=0; i<adjMatrix.length;i++) {
						if(adjMatrix[curr][i]==1 && visited[i]==false) {
							pendingVertex.add(i);
							visited[i]=true;
						}
					}
					System.out.print(curr +" ");
				}
		
			System.out.println();
			}
		}	
	}
	
	
	public static void deptFirstTraversal(int adjMatrix[][], int currentVertex, boolean visited[]) {
		visited[currentVertex]=true;
		System.out.print(currentVertex +" ");
		
		for(int i=0; i<adjMatrix.length; i++) {
//			i neighbor of current vertex
			if(adjMatrix[currentVertex][i]==1 && visited[i]==false) {
				deptFirstTraversal(adjMatrix, i, visited);
			}
		}
		
		
	}
	
	public static void deptFirstTraversal(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];
		for(int i=0; i< adjMatrix.length; i++) {
			if(!visited[i]) {				
				deptFirstTraversal(adjMatrix, i, visited);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Implementation using Adjacency matrix
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int [][] adjMatrix = new int[n][n];
		
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjMatrix[v1][v2]= 1;
			adjMatrix[v2][v1]= 1;
		}
		
//		deptFirstTraversal(adjMatrix);
//		System.out.println();
//		breadthFirstTraversal(adjMatrix);
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		int source = sc.nextInt();
		int destination = sc.nextInt();
		// System.out.println(source);
		// System.out.println(destination);
		// breadthFirstTraversal(adjMatix);
		ArrayList<Integer> output = getPathBFS(adjMatrix, source, destination);
		 
		for(int i=0; i<output.size();i++){
			System.out.print(i +"");
		}

	}

}
