package org.swea.eclipse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;


public class Solution {

	public static final int MAX=101;
	
	static boolean [][]adj;
	static int start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		for (int tc=1; tc<=10; tc++) {
			st=new StringTokenizer (br.readLine(), " ");
			int N=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			
			adj=new boolean[MAX][MAX];
			
			st=new StringTokenizer (br.readLine(), " ");
			for (int i=0; i<N/2; i++) {
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				adj[from][to]=true;
			}
			int ret=bfs();
			
			System.out.println("#"+tc+" "+ret);
		
		}

	}
	
	private static int bfs() {
		int ret=0;
		
		boolean[] visited=new boolean[MAX];
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		visited[start]=true;
		
		while (!q.isEmpty()) {
			
			int size=q.size();
			int maxNode=0;
			
			while (--size>=0) {
				int cur=q.poll();
				for (int i=1; i<MAX; i++) {
					if (adj[cur][i] && !visited[i]) {
						q.offer(i);
						maxNode=Math.max(maxNode,i);
						visited[i]=true;
					}
				}
				if (maxNode>0) ret=maxNode;
			}
		}
		return ret;
	}
}
