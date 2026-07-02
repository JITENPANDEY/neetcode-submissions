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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Interval firstInterval = intervals.get(0);
        for(int i = 1; i<intervals.size(); i++){
            Interval secondInterval = intervals.get(i);
            if(secondInterval.start < firstInterval.end){
                return false;
            }
            firstInterval = secondInterval;
        }
        return true;
    }
}
