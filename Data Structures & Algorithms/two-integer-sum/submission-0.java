class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int search = target - nums[i];
            if(map.containsKey(search)){
                if(i<map.get(search))
                    return new int[]{i, map.get(search)};
                else 
                    return new int[]{map.get(search), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
