import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * to implement simple editor using stack data structure
 * 
 */
public class Editor {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String str = br.readLine();	// initial string 
        
        Stack <Character> left = new Stack<Character>();		// stack in the left of cursor
        Stack <Character> right = new Stack<Character>();	// stack int the right of cursor
        
        // at first, push all string into left stack 
        for(int i=0;i<str.length();i++) {
        	left.push(str.charAt(i));
        }
        
        int cnt = Integer.parseInt(br.readLine());
        
        while (cnt-- > 0) {
        	String[] input = br.readLine().split(" ");
        	char command = input[0].charAt(0);
        	
        	// if command is L, then left stack pop and right stack push
        	if(command == 'L') {
        		if(!left.isEmpty()) {
        			right.push(left.pop());
        		}
        	}
        	// if command is D, then right stack pop and left stack push
        	else if(command == 'D') {
        		if(!right.isEmpty()) {
        			left.push(right.pop());
        		}
        	}
        	// if command is B, then left stack pop
        	else if(command == 'B') {
        		if(!left.isEmpty()) {
        			left.pop();
        		}
        	}
        	// if command is P, then left stack push with character
        	else if(command == 'P') {
        		if(!left.isEmpty()) {
        			left.push(input[1].charAt(0));
        		}
        	}
        }
        
        // print all string (all left stach pop and right stack push)
        while(!left.isEmpty()) {
        	right.push(left.pop());
        }
        
        StringBuffer sb = new StringBuffer();
        while(!right.isEmpty()) {
        	sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
	}
}
