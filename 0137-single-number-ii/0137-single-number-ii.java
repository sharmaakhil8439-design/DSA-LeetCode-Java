class Solution {
    public int singleNumber(int[] nums) {

        int ans = 0;

        // Check all 32 bit positions
        for (int i = 0; i < 32; i++) {

            int count = 0;

            // Count set bits at position i
            for (int num : nums) {
                count += (num >>> i) & 1;
            }

            // If remainder is 1, set that bit in answer
            if (count % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}