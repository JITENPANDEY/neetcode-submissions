class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        //Add all in set
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int ans = 0;
        for(int num : nums){
            //if num-1 present in the set it means num cannot be the starting point of the sequence.
            //So we will check only if num-1 is not present in set so the current name can be considered
            //as starting point.
            //from this starting point make the seq as long as possible
            // at the end check if this sequence is longer than my seq length in ans then update the ans;
            if(!set.contains(num-1)) {
                int seq = 1;
                while(set.contains(num+1)){
                    num++;
                    seq++;
                }
                ans = Math.max(ans, seq);
            }
        }
        return ans;
    }
}
