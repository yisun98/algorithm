package review;

import java.util.HashMap;

public class 哈希表_无重复字符的最长子串 {
	public static int lengthOfLongestSubstring(String s) {
		int maxlen = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0; 
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++, end++) {
			if(map.containsKey(c[i])) {
				start = Math.max(start, map.get(c[i])+1); //最新s的位置  ，防止abba这种情况出现
			}
			maxlen = Math.max(maxlen, end-start+1);
			map.put(c[i], end);
//			System.out.println("s = " + start + ", e = " + end);
		}
		
		return maxlen;
    }
	
	public static void main(String[] args) {
		int lengthOfLongestSubstring = lengthOfLongestSubstring("dvdf");
		System.out.println(lengthOfLongestSubstring);
	}
}
