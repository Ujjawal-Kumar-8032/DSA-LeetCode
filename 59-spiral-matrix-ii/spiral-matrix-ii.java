class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int erow = n-1;
        int ecol = n-1;
        int srow = 0;
        int scol = 0;
        int val=1;
        while(val<=n*n){
            //top
            for(int i=scol;i<=ecol;i++){
                nums[srow][i] = val++;
            }
            //right
            for(int i=srow+1;i<=erow;i++){
                nums[i][ecol]=val++;
            }
            //bottom
            for(int i=ecol-1;i>=scol;i--){
                if(srow==erow) break;
                nums[erow][i]=val++;
            }
            //left
            for(int i=erow-1;i>=srow+1;i--){
                if(scol==ecol) break;
                nums[i][scol]=val++;
            }
            srow++;
            ecol--;
            scol++;
            erow--;
        }
        return nums;
    }
}