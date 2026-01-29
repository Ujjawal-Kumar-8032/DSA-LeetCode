class Solution {
    public void setZeroes(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j]==0){
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(set1.contains(i) || set2.contains(j)){
                    nums[i][j] = 0;
                }
            }
        }
    }
}