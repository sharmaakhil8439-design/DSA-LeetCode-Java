
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, ans);
        return ans;
    }

    void solve(int index, int[] candidates, int target,
               List<Integer> current, List<List<Integer>> ans) {

        
            if (target == 0) {
                ans.add(new ArrayList<>(current));
                return;
            }
           
            for(int i=index;i<candidates.length;i++){
                if(i>index&& candidates[i]==candidates[i-1]){
                    continue;
                }
                if(target<candidates[i]){
                    break;
                }
                current.add(candidates[i]);
               solve(i + 1, candidates, target - candidates[i], current, ans);
               current.remove(current.size() - 1);

            }
        

        
      
    }
}
