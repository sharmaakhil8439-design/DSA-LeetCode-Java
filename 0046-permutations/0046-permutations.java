class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> container=new ArrayList<>();
        boolean[] freq=new boolean[nums.length];
        solve(nums, ans, container, freq);
        return ans;

    }
    void solve(int[] nums,List<List<Integer>> ans,List<Integer> container,boolean[] freq){
        if(container.size()==nums.length){
            ans.add(new ArrayList<>(container));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                container.add(nums[i]);
                solve(nums,ans,container,freq);
                container.remove(container.size()-1);
                freq[i]=false;

            }
        }
    }
}