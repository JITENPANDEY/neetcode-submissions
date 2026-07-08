class Solution {
    public int trap(int[] height) {
        /** with O(2N) space

        int ans = 0, n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i=0;i<n;i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            ans += water;
        }
        return ans;
        */

        // with O(1) space using two pointer 
         int ans = 0, n = height.length;
         int leftMax = 0, rightMax = 0;
         int i =0, j=n-1;
         while(i<=j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if(height[i] < height[j]){
                int water = leftMax - height[i];
                ans += water;
                i++;
            } else {
                int water = rightMax - height[j];
                ans += water;
                j--;
            }
            
         }
         return ans;
    }
}
