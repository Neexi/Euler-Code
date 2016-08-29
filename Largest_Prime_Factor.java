import java.io.*;
import java.util.*;

public class Solution {

    /*
     * largest prime factor of a given number N
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
			long n = sc.nextLong();
			n = divideTwo(n);
			if(n == 1) {
				System.out.println("2");
				continue;
			}
			long odd = 3;
			while(n > 1 && odd <= Math.sqrt(n)) {
				n = divideOdd(n, odd);
				if(n == 1) {
					System.out.println(odd);
				}
				odd += 2;
			}
			if(n > 1) {
				System.out.println(n);
			}
			
		}
        sc.close();
    }
    
    /*
     * Divide the number by 2 until it's not divisible anymore
     */
    public static long divideTwo(long n) {
    	long cur = n;
    	while(cur % 2 == 0) {
    		cur /= 2;
    	}
    	return cur;
    }
    
    public static long divideOdd(long n, long odd) {
    	long cur = n;
    	while(cur % odd == 0) {
    		cur /= odd;
    	}
    	return cur;
    }
}