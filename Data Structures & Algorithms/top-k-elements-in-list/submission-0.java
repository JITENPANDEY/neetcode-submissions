class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num , map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        map.forEach((key, value) -> {
            pq.offer(key);
        });
        int[] ans  = new int[k];
        int i = 0;
        while(!pq.isEmpty() && i<k) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
