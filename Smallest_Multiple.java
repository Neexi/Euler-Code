import java.io.*;
import java.util.*;

public class Solution {

	/*
     * Find all the prime factor of number N
	 * Find the maximal number of occurrence for each prime from 1 to N
	 * Example in 10
	 * 1 2 3 4 5 6 7 8 9 10
	 * there are 2*2*2 (from 8)
	 * there are 3*3 (from 9)
	 * there is 5 (from 5 or 10)
	 * there is 7 (from 7)
	 * What's needed : prime breakdown function
	 * array to keep the maxcount of each
	 */
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
			int n = sc.nextInt();
			if(n == 1) {
				System.out.println("1");
				continue;
			}
			//Only prime number index will be changed
			int maxCount[] = new int[41];
			Arrays.fill(maxCount, 0);
			for (int j = 2; j <= n; j++) {
				int arr[] = primeBreakdown(j);
				for (int k = 2; k < arr.length; k++) {
					maxCount[k] = Math.max(maxCount[k], arr[k]);
				}
			}
			long sum = 1;
			//System.out.println(Arrays.toString(maxCount));
			for (int j = 0; j < maxCount.length; j++) {
				sum *= (maxCount[j] > 0) ? Math.pow(j, maxCount[j]) : 1;
			}
			System.out.println(sum);
		}
        sc.close();
    }
    
    public static int[] primeBreakdown(int n) {
    	int odd = 3;
    	int cur = n;
    	int arr[] = new int[n+1];
    	Arrays.fill(arr, 0);
    	cur = divideTwo(cur, arr);
    	while(cur > 1) {
    		cur = divideOdd(cur, odd, arr);
    		odd += 2;
    	}
    	return arr;
    }
    
    /*
     * How many times can the number be divided by 2
     */
    public static int divideTwo(int n, int[] arr) {
    	int cur = n;
    	int count = 0;
    	while(cur % 2 == 0) {
    		cur /= 2;
    		count++;
    	}
    	arr[2] = count;
    	return cur;
    }
    
    /*
     * How many times can the number be divided by odd
     */
    public static int divideOdd(int n, int odd, int[] arr) {
    	int cur = n;
    	int count = 0;
    	while(cur % odd == 0) {
    		cur /= odd;
    		count++;
    	}
    	arr[odd] = count;
    	return cur;
    }
}