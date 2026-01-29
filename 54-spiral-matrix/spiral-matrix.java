class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int erow = nums.length-1;
        int ecol = nums[0].length-1;
        int srow = 0;
        int scol = 0;
        while(srow<=erow && scol<=ecol){
            //top
            for(int i=scol;i<=ecol;i++){
                list.add(nums[srow][i]);
            }
            //right
            for(int i=srow+1;i<=erow;i++){
                list.add(nums[i][ecol]);
            }
            //bottom
            for(int i=ecol-1;i>=scol;i--){
                if(srow==erow) break;
                list.add(nums[erow][i]);
            }
            //left
            for(int i=erow-1;i>=srow+1;i--){
                if(scol==ecol) break;
                list.add(nums[i][scol]);
            }
            srow++;
            ecol--;
            scol++;
            erow--;
        }
        return list;
    }
}