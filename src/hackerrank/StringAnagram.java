package hackerrank;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by mishrk3 on 4/5/2017.
 */
public class StringAnagram {

	private static final int MAX_POSSIBLE_ASCII = 256;

	public boolean compare(int[] count, int[] txt) {
		for (int i = 0; i < MAX_POSSIBLE_ASCII; i++) {
			if (count[i] != txt[i]) {
				return false;
			}
		}
		return true;
	}

	public void findAnagram(char[] text, char[] pattern) {
		int[] count = new int[MAX_POSSIBLE_ASCII];
		int[] txt = new int[MAX_POSSIBLE_ASCII];
		int m = pattern.length;
		int n = text.length;

		for (int i = 0; i < m; i++) {
			count[pattern[i]]++;
			txt[text[i]]++;
		}

		for (int i = m; i < n; i++) {
			if (compare(count, txt)) {
				System.out.println("Anagram found at index: " + (i - m));
			}
			txt[text[i]]++;
			txt[text[i - m]]--;
		}
		if (compare(count, txt)) {
			System.out.println("Anagram found at index: " + (n - m));
		}
	}

	public static void main(String[] args) {
		String text = "BACDGABCDA";
		String pattern = "ABCD";
		StringAnagram sa = new StringAnagram();
		sa.findAnagram(text.toCharArray(), pattern.toCharArray());
		System.out.println(reverseWord("Hello World! krishna Mishra", 1));
		System.out.println(sum("one two three ten"));
	}

	static String reverseWord(String s, int index) {
		String [] words = s.split(" ");
		int len = words.length;
		if(index >= words.length){
			return s;
		}
		words[index] = reverse(words[index]);
		String result = "";
		for(int i = 0; i < len; i++){
			result = words[i];
			if(i != len-1){
				result+= " ";
			}
		}
		return result;
	}

	private static String reverse(String word){
		int len = word.length();
		String reversed = "";
		for(int i = len-1; i >=0; i--){
			reversed +=word.charAt(i);
		}
		return reversed;
	}

	static int sum1(String s) {
		String [] numbers = s.split(" ");
		Map<String, Integer> map = populateMap();
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			sum += map.get(numbers[i]);
		}
		return sum;
	}

	static int sum(String s) {
		String [] numbers = s.split(" ");
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			switch (numbers[i].toLowerCase()){
			case "one":
				sum = sum + 1;
				break;
				case "two":
				sum = sum + 2;
					break;
				case "three":
				sum = sum + 3;
					break;
				case "four":
				sum = sum + 4;
					break;
				case "five":
				sum = sum + 5;
					break;
				case "six":
				sum = sum + 6;
					break;
				case "seven":
				sum = sum + 7;
					break;
				case "eight":
				sum = sum + 8;
					break;
				case "nine":
				sum = sum + 9;
					break;
				case "ten":
				sum = sum + 10;
			}
		}
		return sum;
	}

	private static Map<String, Integer> populateMap(){
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		return map;
	}


}
