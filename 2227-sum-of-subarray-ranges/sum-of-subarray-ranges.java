class Solution {
    public long subArrayRanges(int[] arr) {
        int n= arr.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int min = arr[i];
            int max = arr[i];
            for(int j=i;j<n;j++){
                min = Math.min(min,arr[j]);
                max = Math.max(max,arr[j]);
                ans += (long)(max-min);
            }
        }
        return ans;
    }
}