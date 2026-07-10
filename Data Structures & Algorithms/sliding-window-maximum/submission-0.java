class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        int[] ans = new int[nums.length - k + 1];

        int i = 0, j = 0;
        while(j<nums.length){
            while(j<nums.length && j-i+1 <= k){
                pq.add(nums[j]);
                j++;
            }

            ans[i] = pq.peek();
            pq.remove(nums[i]);
            i++;
        }
        return ans;
    }
}
