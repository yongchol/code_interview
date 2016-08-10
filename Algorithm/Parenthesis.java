import java.util.Scanner;

/**
 * to find valid parenthesis string
 * 
 */
public class Parenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
		
        while(n-- > 0) {
        	System.out.println(isValidLine(sc.nextLine()));
        }
	}
	
	/*
	 * check if input parentheis string is valid then return YES, or return NO
	 */
	public static String isValidLine(String str) {
		
		str = str.trim();
		int cnt = 0;
		
		for(int i=0;i<str.length();i++) {
			// meet char '(', count increased like stack push
			if(str.charAt(i) == '(') {
				cnt++;
			}
			// meets char ')', count decreased like stach pop
			else {
				cnt--;
			}
			
			if(cnt <0) {
				return "NO";
			}
			
		}
		
		// if stack is empty, then return YES means valid string 
		if(cnt ==0) {
			return "YES";
		}
		// if stack is not empty, then return NO means not valid string 
		else {
			return "NO";
		}
		
	}

}
