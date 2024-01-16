package com.rohith.leetcode.stack;

import java.util.Stack;

public class Decode_String {
    	
    	    public String decodeString(String s) {
    	        Stack<Integer> numStack = new Stack<>();
    	        Stack<StringBuffer> strStack = new Stack<>();
    	        
    	        StringBuffer str=new StringBuffer();
    	        int num=0;

    	        for(int i: s.toCharArray()){
    	        	System.out.println(i+" = i ");
    	            if(i>='0' && i<='9'){
    	                num = num*10+(i-'0');
    	            }
    	            if(i == '['){
    	            	strStack.push(str);
    	                str = new StringBuffer();

    	                numStack.push(num);
    	                num=0;

    	            }
    	            if(i == ']'){
    	                StringBuffer temp=str;
    	                int count = numStack.pop();
    	                str = strStack.pop();
    	                while(count-->0){
    	                    str.append(temp);
    	                }
    	            }
    	            else{
    	                str.append(i);
    	            }
    	        }

    	        return str.toString();
    	
    	        // below code is not optimal for java(memory overflows), it works for python. 
//        Stack<Character> st = new Stack<>();
//        StringBuffer substr = new StringBuffer();
//        StringBuffer numstr = new StringBuffer();
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != ']') {
//                st.push(s.charAt(i));
//            } else {
//                substr.setLength(0);
//                while (!st.empty() && st.peek() != '[') {
//                    substr.insert(0, st.pop());
//                }
//                st.pop();
//                numstr.setLength(0);
//                while (!st.empty() && Character.isDigit(st.peek())) {
//                    numstr.insert(0, st.pop());
//                }
//            }
//            num = numstr.length() > 0 ? Integer.parseInt(numstr.toString()) : 1;
//            String repeated = substr.toString().repeat(num);
//            for (char c : repeated.toCharArray()) {
//                st.push(c);
//            }
//        }
//        StringBuffer result = new StringBuffer();
//        while (!st.empty()) {
//            result.append(st.pop());
//        }
//        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Decode_String decoder = new Decode_String();

        // Test cases
        String result1 = decoder.decodeString("3[a]2[bc]");
        System.out.println("Result 1: " + result1);  // Expected: "aaabcbc"

        String result2 = decoder.decodeString("3[a2[c]]");
        System.out.println("Result 2: " + result2);  // Expected: "accaccacc"

        String result3 = decoder.decodeString("2[abc]3[cd]ef");
        System.out.println("Result 3: " + result3);  // Expected: "abcabccdcdcdef"
    }
}
