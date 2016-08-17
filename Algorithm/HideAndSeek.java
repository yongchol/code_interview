import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * hide and seek play with BFS algorithm
 * 
 */
public class HideAndSeek {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int N = sc.nextInt();	// input hide position
        int K = sc.nextInt();	// input seek position
        int MAX = 1000000;
        
        boolean[] visited = new boolean[MAX];	// to check for visit
        int[] dist = new int[MAX];	// to calculate for move
        
        // initialize
        visited[N] = true;	// initialize start position
        dist[N] = 0;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        
        // searching queue until it is empty
        while(!queue.isEmpty()) {
        	int cur = queue.poll();	// pull out current position from queue
        	
        	// case 1. move to X-1
        	if(cur-1 > 0) {
        		if(!visited[cur-1]) {
        			queue.add(cur-1);
        			visited[cur-1] = true;	// mark visited = true
        			dist[cur-1] = dist[cur] + 1;	// add distance
        		}
        	}
        	
        	// case 2. move to X+1
        	if(cur+1 < MAX) {
        		if(!visited[cur+1]) {
        			queue.add(cur+1);
        			visited[cur+1] = true;
        			dist[cur+1] = dist[cur] + 1;
        		}
        	}
        	
        	// case 1. move to X*2
        	if(cur*2 < MAX) {
        		if(!visited[cur*2]) {
        			queue.add(cur*2);
        			visited[cur*2] = true;
        			dist[cur*2] = dist[cur] + 1;
        			
        		}
        	}
        	
        }
        
        
        // display moving count for seek position
        System.out.println(dist[K]);
	}

}
