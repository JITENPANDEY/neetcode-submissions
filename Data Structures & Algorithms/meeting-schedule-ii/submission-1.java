/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals.size();
        intervals.sort((a, b)-> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Interval first = intervals.get(0);
        pq.add(first.end);

        int count = 1;
        for(int i=1; i<intervals.size(); i++){
            Interval second = intervals.get(i);
            if(second.start < pq.peek()){
                count++;
            } else {
                pq.poll();
            }
            pq.add(second.end);
            first = second;
        }
        return count;
    }
}

