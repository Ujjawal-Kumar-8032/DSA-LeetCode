class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
       if (n == 0) return 0;
        HashSet<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int count=1;
        int maxCount=1;
        for(int num : set){
            if(!set.contains(num-1)){
                int nnum = num;
                count=1;
                while(set.contains(nnum+1)){
                    count++;
                    nnum++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}