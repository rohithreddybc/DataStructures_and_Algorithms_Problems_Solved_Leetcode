package com.rohith.leetcode75.arrayAndString;

public class StringCompression {

	public int compress(char[] chars) {
		int newIndex = 0;
		int firstPointer = 0;
		int secondPointer = 0;
		while (firstPointer < chars.length) {
			int count = 0;
			while (secondPointer < chars.length && chars[firstPointer] == chars[secondPointer]) {
				count++; //keeps count of same character
				secondPointer++;
			}
			chars[newIndex++] = chars[firstPointer];

			if (count > 1) { //if same character count is more than 1, we'll add count(num of occurance) to array
				String charCountStr = count + "";
				for (char c : charCountStr.toCharArray()) {
					chars[newIndex++] = c;
				}
			}
			firstPointer = secondPointer;
		}
		return newIndex;
	}

	public static void main(String[] args) {
		StringCompression solution = new StringCompression();

		// Example usage:
		char[] inputArray = { 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c' };
		int compressedLength = solution.compress(inputArray);

		// Displaying the compressed array and its length
		System.out.print("Compressed Array: ");
		for (int i = 0; i < compressedLength; i++) {
			System.out.print(inputArray[i] + " ");
		}
		System.out.println("\nCompressed Length: " + compressedLength);
	}
}
