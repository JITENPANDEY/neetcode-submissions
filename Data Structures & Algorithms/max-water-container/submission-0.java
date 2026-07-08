class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length-1;
        int ans = Integer.MIN_VALUE;
        while(i<j){
            int waterArea = (j-i) * Math.min(heights[i], heights[j]);
            ans = Math.max(ans, waterArea);
            if(heights[i] <= heights[j]){
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
