
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, ans);

        return ans;
    }

    void solve(int index, int[] candidates, int target,
               List<Integer> current, List<List<Integer>> ans) {

        // Base case
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        // Pick the current element
        if (candidates[index] <= target) {

            current.add(candidates[index]);

            // Same index because reuse is allowed
            solve(index, candidates, target - candidates[index],
                  current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }

        // Not pick the current element
        solve(index + 1, candidates, target, current, ans);
    }
}
