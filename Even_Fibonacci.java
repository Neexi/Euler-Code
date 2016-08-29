import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Calculating the sum of even valued Fibonacci sequence until (not including) n
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
			long n = sc.nextLong();
	        printFibo(n);
		}
        sc.close();
    }
    
    public static void printFibo(long limit) {
    	if(limit < 2) {
    		System.out.println(0);
    		return;
    	}
    	long prev1 = 1;
    	long prev2 = 2;
    	long sum = prev2;
    	while(prev2 + prev1 < limit) {
    		long temp = prev2;
    		prev2 = prev2 + prev1;
    		prev1 = temp;
    		sum += (prev2 % 2 == 0) ? prev2 : 0; 
    	}
    	System.out.println(sum);
    }
}