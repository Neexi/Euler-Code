import java.io.*;
import java.util.*;

public class Solution {

    //largest palindrome made from the product of two 3-digit numbers which is less than n
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
			int n = sc.nextInt();
			int palindrome = 0;
			boolean found = false;
			int cur = (n-1) - (n-1) % 11;
			while(!found && cur >= 10000) {
				//If this number is not palindrome, just continue
				if(!testPalindrome(cur)) {
					cur -= 11;
					continue;
				}
				//Otherwise, try to find the two 3-digit numbers
				
				//Since it is always divisible by 11
				int rem = cur / 11;
				//Smallest first number is 110 (11 * 10)
				int num1 = 10;
				while(num1 * 11 < 1000 && !found) {
					//3 digit number that is the multiplication of num1
					if(rem % num1 == 0 && (rem / num1) / 100 >= 1 && (rem / num1 ) / 100 <= 9 ) {
						found = true;
						palindrome = cur;
						continue;
					}
					num1++;
				}
				cur -= 11;
			}
			System.out.println(palindrome);
		}
        sc.close();
    }
    
    public static boolean testPalindrome(int n) {
    	String nStr = String.valueOf(n);
    	int length = nStr.length();
    	int test = length / 2;
    	for (int i = 0; i < test; i++) {
			if(nStr.charAt(i) != nStr.charAt(length - 1 - i)) return false;
		}
    	return true;
    }
}