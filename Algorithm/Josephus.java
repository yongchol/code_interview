import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * to implement Josephus algorithm
 * 
 */
public class Josephus {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();		// how many member	
        int m = sc.nextInt();		// define which member going out
        
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // initialize - fill members in Josephus queue
        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }
        
        // while searching in the queue, pull out each member and insert it in the end of queue until meets count m
        for(int i=0; i<n-1; i++) {
        	for(int j=0; j<m-1; j++) {
        		queue.offer(queue.poll());
        	}
        	// pull out the first member in the queue when meets count m
        	sb.append(queue.poll() + ", ");
        }
        
        // pull out the last member in the queue
        sb.append(queue.poll() + ">");
        
        System.out.println(sb);
        
	}
}
