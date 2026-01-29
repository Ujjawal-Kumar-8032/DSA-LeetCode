class Solution {
    public void setZeroes(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        boolean col=false;
        boolean row=false;
        for(int i=0;i<m;i++){
            if(nums[i][0]==0){
                col=true;
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[0][j]==0){
                row=true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(nums[i][j]==0){
                    nums[i][0]=0;
                    nums[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(nums[i][0]==0 || nums[0][j]==0){
                    nums[i][j]=0;
                }
            }
        }
        if(row){
            for(int i=0;i<n;i++){
                nums[0][i]=0;
            }
        }
        if(col){
            for(int i=0;i<m;i++){
                nums[i][0]=0;
            }
        }
    }
}