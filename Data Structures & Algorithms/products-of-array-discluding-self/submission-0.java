class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int left = 1;
        for(int i=0;i<nums.length;i++){
            ans[i] *= left;
            left = nums[i]*left;
        }

        int right = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i] *= right;
            right = nums[i]*right;
        }
        return ans;
    }
}  
