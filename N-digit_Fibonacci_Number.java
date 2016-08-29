import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

	private static int maxN = 5000;
	private static double phi = (1 + Math.sqrt(5)) / 2;
	
	/*
	 * print out the first term in the Fibonacci sequence to contain N digits?
	 * 2 <= N <= 5000
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
        	int n = sc.nextInt();
        	
			sb.append(firstTermWithNDigit(n) + "\n");
		}
        sc.close();
        System.out.println(sb);
    }
    
    /*
     * O(1) function, courtesy of discussion forum
     * Based on http://www.had2know.com/academics/number-digits-length-fibonacci-number.html
     * Some mathematical tampering is needed
     */
    public static int firstTermWithNDigit(int n) {
    	return (int) Math.ceil((Math.log(10) * (n - 1) + Math.log(5) / 2) / Math.log(phi));
    }
    
    public static void fillArray(int firstTermWithNDigit[]) {
    	firstTermWithNDigit[0] = 0;
    	int curDigit = 0;
    	int curIndex = 2;
    	BigInteger cur = BigInteger.valueOf(1);
    	BigInteger prev1 = BigInteger.valueOf(1);
    	BigInteger prev2 = BigInteger.valueOf(1);
    	while(curDigit < 5000) {
    		
    		curIndex++;
    		cur = prev1.add(prev2);
    		prev2 = prev1;
    		prev1 = cur;
    		
    		int newDigit = log10(cur) + 1;
    		if(newDigit > curDigit) {
    			//int newDigit = cur.toString().length();
    			for (int i = curDigit+1; i <= newDigit; i++) {
    				firstTermWithNDigit[i] = curIndex;
				}
    			curDigit = newDigit;
    			
    		}
    		
    	}
    }
    
    /*
     * Method taken from stackoverflow,
     * https://stackoverflow.com/questions/18828377/biginteger-count-the-number-of-decimal-digits-in-a-scalable-method
     * faster method to count the number of digit in a biginteger
     */
    private static int log10(BigInteger huge) {
        int digits = 0;
        int bits = huge.bitLength();
        // Serious reductions.
        while (bits > 4) {
          // 4 > log[2](10) so we should not reduce it too far.
          int reduce = bits / 4;
          // Divide by 10^reduce
          huge = huge.divide(BigInteger.TEN.pow(reduce));
          // Removed that many decimal digits.
          digits += reduce;
          // Recalculate bitLength
          bits = huge.bitLength();
        }
        // Now 4 bits or less - add 1 if necessary.
        if ( huge.intValue() > 9 ) {
          digits += 1;
        }
        return digits;
      }
    
    public static void printVoid(int firstTermWithNDigit[]) {
    	for (int i = 1; i < 500; i++) {
			System.out.println(firstTermWithNDigit[i] - firstTermWithNDigit[i-1]);
		}
    }
}