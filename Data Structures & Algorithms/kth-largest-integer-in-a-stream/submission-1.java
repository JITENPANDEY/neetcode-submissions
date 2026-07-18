class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums) {
            pq.add(n);
        }
    }
    
    public int add(int val) {
        int count = k;
        pq.add(val);
        List<Integer> arr = new ArrayList<>();
        while(count-- > 1){
            arr.add(pq.poll());
        }
        int ans = pq.poll();
        for(int a : arr){
            pq.add(a);
        }
        pq.add(ans);
        return ans;
    }
}
