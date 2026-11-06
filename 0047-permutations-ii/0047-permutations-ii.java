class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] freq=new boolean[nums.length];
        solve( nums, ans , ds , freq);
        return ans;

    }
    void solve(int[] nums,List<List<Integer>> ans, List<Integer> ds,  boolean[] freq){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<nums.length;i++){
         if(i > 0 && nums[i] == nums[i - 1] && !freq[i - 1]) {
          continue;
        }
        if (!freq[i]) {
        ds.add(nums[i]);
        freq[i]=true;
        solve( nums, ans , ds , freq);
        ds.remove(ds.size()-1);
        freq[i]=false;
        }

        }
    }
}