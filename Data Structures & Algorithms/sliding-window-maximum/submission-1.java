class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        int[] ans = new int[nums.length - k + 1];

        int i = 0;
        for(int  j = 0; j<nums.length; j++){
            pq.add(nums[j]);

            if(j-i+1 == k){
                ans[i] = pq.peek();
                pq.remove(nums[i]);
                i++;
            }  
        }
        return ans;
    }
}
