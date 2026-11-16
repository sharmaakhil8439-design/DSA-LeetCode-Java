import java.util.*;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: XOR numbers appearing twice
        int ans = 0;

        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                ans ^= key;
            }
        }

        return ans;
    }
}