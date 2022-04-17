package leetcode02;

import java.util.Deque;
import java.util.LinkedList;

public class new7 {

	public static void main(String[] args) {
		String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
		System.out.println("Êä³ö½á¹û£º"+ checkValidString(s));
	}
	public static boolean checkValidString(String s) {
		   Deque<Integer> leftStack = new LinkedList<Integer>();
	        Deque<Integer> asteriskStack = new LinkedList<Integer>();
	        int n = s.length();
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            if (c == '(') {
	                leftStack.push(i);
	            } else if (c == '*') {
	                asteriskStack.push(i);
	            } else {
	                if (!leftStack.isEmpty()) {
	                    leftStack.pop();
	                } else if (!asteriskStack.isEmpty()) {
	                    asteriskStack.pop();
	                } else {
	                    return false;
	                }
	            }
	        }
	        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
	            int leftIndex = leftStack.pop();
	            int asteriskIndex = asteriskStack.pop();
	            if (leftIndex > asteriskIndex) {
	                return false;
	            }
	        }
	        return leftStack.isEmpty();
	    }

}


