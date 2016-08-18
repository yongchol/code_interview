import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * implements BFS and DFS algorithm 
 * 
 */
public class Graph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int N = sc.nextInt();	// count of point
        int M = sc.nextInt();	// count of line
        int S = sc.nextInt();	// starting point
        
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N+1];
        
        // make ArrayList N
        for(int i=1; i<=N; i++) {
        	a[i] = new ArrayList<Integer>();
        }
        
        // input line info. 
        for(int i=0; i<M; i++) {
        	int u = sc.nextInt();
        	int v = sc.nextInt();
        	
        	a[u].add(v);
        	a[v].add(u);
        	
        	// ex) 1 2 ->  a[1].add(2),  a[2].add(1)
        }
	
        for (int i=1; i<=N; i++) {
            Collections.sort(a[i]);
        }
        
        boolean[] visited = new boolean[N+1];
        
        dfs(a,visited, S);
        System.out.println();
        
        Arrays.fill(visited, false);
        
        bfs(a, visited, S);
        System.out.println();
	}
	
	public static void dfs(ArrayList<Integer>[] a, boolean[] visited, int cur) {
		
		if(visited[cur]) {
			return;
		}
		
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for(int y : a[cur]) {
			if(visited[y] == false) {
				dfs(a, visited, y);
			}
		}
	}
	
	public static void bfs(ArrayList<Integer>[] a, boolean[] visited, int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(cur);
		visited[cur] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			
			for(int y : a[x]) {
				if(visited[y] == false) {
					visited[y] = true;
					queue.add(y);
				}
			}
		}
	}

}
