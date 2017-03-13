/*
 * Recursion.java
 *
 * [Jonathan Berg]
 *
 * Starter code for the recursion lab.
 *
This program has seven different recursive functions. The main method prompts a dialogue allowing
the user to test them all. Have fun!
 */
import structure5.*;
import java.util.Scanner;

public class Recursion {


    /*****  1  ***************************************************/

    /*
     * Return number of cannoballs in pyramid with the given height.
     */
    //BIG O: O(n)
    //Pre: Height >= 1
    public static int countCannonballs(int height) {
	if (height < 1) {
	    return 0;
	}
	if (height == 1) {
	    return 1;
	} else {
	    return (int)Math.pow(height,2) + countCannonballs(height-1);
	}
    }


    /*****  2  ***************************************************/

    /*
     * Return true if str is a palindrome.
     */
    //BIG O: O(n)
    public static boolean isPalindrome(String str) {
	if (str.length()==0 || str.length() == 1) {
	    return true;
	}
	if (str.charAt(0) != str.charAt(str.length()-1)) {
	    return false;
	} else {
	    return isPalindrome(str.substring(1,str.length()-1));
	}
    }

    /*****  3  ***************************************************/

    /*
     * Return true if str is a string of matched parens,
     * brackets, and braces.
     */
    //BIG O: O(n)
    public static boolean isBalanced(String str) {
	if (str.length() == 0) {
	    return true;
	}
	if (!(str.contains("()") || str.contains("{}") || str.contains("[]"))) {
	    return false;
	} else {
	    return isBalanced(str.replace("()","").replace("{}","").replace("[]",""));
	}
    }


    /*****  4  ***************************************************/

    /*
     * Print all substrings of str.  (Order does not matter.)
     */
    //BIG O: O(2^n)
    public static void substrings(String str) {
	substringHelper(str,"");
    }

    public static void substringHelper(String str, String soFar) {
	if (str.length() == 0) {
	    System.out.println(soFar);
	} else {
	    substringHelper(str.substring(1),soFar + str.charAt(0));
	    substringHelper(str.substring(1),soFar);
	}
    }

    /*****  5  ***************************************************/

    /*
     * Print number in binary
     */
    //BIG O: O(log n) (with respect to decimal input)
    //Pre: input is positive
    public static void printInBinary(int number) {
	assert (number >= 0) : "Number cannot be negative";
	
	if (number <= 1) {
	    System.out.print(number%2);
	} else {
	    printInBinary(number/2);
	    System.out.print(number%2);
	}
    }


    /*****  6  ***************************************************/

    /*
     * Return whether a subset of the numbers in nums add up to sum,
     * and print them out.
     */

    //BIG O: O(2^n)
    public static boolean printSubSetSum(int nums[], 
					 int targetSum) {
	boolean result = printSubHelper(nums,targetSum,0);
	System.out.println();
	return result;
	
    }

    public static boolean printSubHelper(int nums[], int target, int index) {
	if (nums.length == index) {
	    return target==0;
	} else {
	    boolean with = printSubHelper(nums,target-nums[index],index+1);
	    if (with) {
		System.out.print(nums[index]+" ");
		return true;
	    }
	    
	    boolean without = printSubHelper(nums,target,index+1);

	    return with||without;
	}
    }


    /*
     * Return the number of different ways elements in nums can be
     * added together to equal sum.
     */
    //BIG O: O(2^n)
    public static int countSubSetSumSolutions(int nums[], int targetSum) {
	return countSubSetHelper(nums,targetSum,0);
    }

    public static int countSubSetHelper(int nums[], int targetSum, int index) {
	int count = 0;
	if (nums.length == index) {
	    if (targetSum == 0) {
		return 1;
	    } else {
		return 0;
	    }
	} else {
	    int with = countSubSetHelper(nums,targetSum-nums[index],index+1);
	    int without = countSubSetHelper(nums,targetSum,index+1);

	    return with+without;
	}
	
    }

    
    /*
     * Add testing code to main to demonstrate that each of your 
     * recursive methods works properly.
     */

    /*Allows the user to choose a question to test, and then repeatedly test it with a custom input.
      In the case of both subset sum questions, the array and target are predefined. To test exhaustively,
      the user must change them in the code.
    */
    public static void main(String args[]) {

	//arr and target are used for the subset sum problems. Change here.
	int arr[] = new int[] {3,7,-5,10,4,15,8,20};
	int target = 2;
	
	Scanner in = new Scanner(System.in);
	boolean end = false;
	
	while (end == false) {
	    System.out.println("Welcome to Jonathan's fun testing experience!");
	    System.out.println("Which question (1 through 7) would you like to test?");
	    int question = in.nextInt();
	    boolean done = false;
	    switch (question) {
	    case 1:
		done = false;
		while (done == false) {
		    
		    System.out.println("countCannonballs: how tall is the stack?");
		    int stack = in.nextInt();
		    System.out.println("The stack has " + countCannonballs(stack) + " cannonballs");
		    System.out.println("Repeat? y or n");
		    String answer = in.next();
		    if (answer.equals("n")) {
			done = true;
		    }
		}
		break;
	    case 2:
		done = false;
		while (done == false) {
		    
		    System.out.println("Palindromes: What's the word? ");
		    String word = in.next();
		    System.out.println("isPalindrome(" + word + ") is " + isPalindrome(word));
		    System.out.println("Repeat? y or n");
		    String answer = in.next();
		    if (answer.equals("n")) {
			done = true;
		    }
		}
		break;
	    case 3:
		done = false;
		while (done == false) {
		    
		    System.out.println("Hand me those brackets and stuff! ");
		    String parens  = in.next();
		    System.out.println("isBalanced = " + isBalanced(parens));
		    System.out.println("Repeat? y or n");
		    String answer = in.next();
		    if (answer.equals("n")) {
			done = true;
		    }
		}
		break;
	    case 4:
		done = false;
		while (done == false) {
		    
		    System.out.println("substring: What is the string? ");
		    String str = in.next();
		    substrings(str);
		    System.out.println("Repeat? y or n");
		    String answer = in.next();
		    if (answer.equals("n")) {
			done = true;
		    }
		}
		break;
	    case 5:
		done = false;
		while (done == false) {
		    
		    System.out.println("Print in binary: what is the decimal number to convert? ");
		    int decimal = in.nextInt();
		    System.out.println("The binary representation is: ");
		    printInBinary(decimal);
		    System.out.println();
		    System.out.println("Repeat? y or n");
		    String answer = in.next();
		    if (answer.equals("n")) {
			done = true;
		    }
		}
		break;
	    case 6:
		System.out.println("printSubSetSum(arr,target): ");
		printSubSetSum(arr,target);
		System.out.println();
		break;
	    case 7:
		System.out.println("countSubSetSumSolutions(arr,target) = " + countSubSetSumSolutions(arr,target));
		break;
	    default: System.out.println("Invalid question number, try again.");
		break;
	    }

	    System.out.println("Type e to exit, n to test another problem");
	    String answer = in.next();
	    if (answer.equals("e")) {
		end = true;
	    }
	}
	
    }
    
}
