package review;

import java.util.Arrays;
import java.util.HashMap;

public class 哈希表_两数之和 {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  // rest, inx
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return new int[]{map.get(nums[i]), i};
			}else {
				map.put(target-nums[i], i);
			}
		}
		return new int[]{-1, -1};
    }
	public static void main(String[] args) {
		int[] twoSum = twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(twoSum));
	}
}
