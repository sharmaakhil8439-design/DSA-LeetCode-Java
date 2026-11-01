class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(nums, 0, current, ans);

        return ans;
    }

    void solve(int[] nums, int index,
               List<Integer> current,
               List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include current element
        current.add(nums[index]);

        solve(nums, index + 1, current, ans);

        // Backtracking
        current.remove(current.size() - 1);

        // Choice 2: Exclude current element
        solve(nums, index + 1, current, ans);
    }
}