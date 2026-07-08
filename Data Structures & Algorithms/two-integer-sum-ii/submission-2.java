class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i<j){
            while(i<j && numbers[i]+numbers[j] > target){
                j--;
            }
            while(i<j && numbers[i]+numbers[j] < target){
                i++;
            }
            if(numbers[i]+numbers[j] == target){
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }
}
