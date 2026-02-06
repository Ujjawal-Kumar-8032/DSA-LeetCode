class Solution {
    public void nse(int[] nums, int[] nse){
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(st.size()!=0 && nums[st.peek()] > nums[i]){
                st.pop();
            }
            if(st.size()==0) nse[i] = nums.length;
            else nse[i] = st.peek();
            st.push(i);
        }
    }
    public void pse(int[] nums, int[] pse){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(st.size()!=0 && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
    }
    public void nge(int[] nums, int[] nge){
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(st.size()!=0 && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(st.size()==0) nge[i] = nums.length;
            else nge[i] = st.peek();
            st.push(i);
        }
    }
    public void pge(int[] nums, int[] pge){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(st.size()!=0 && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.size()==0) pge[i] = -1;
            else pge[i] = st.peek();
            st.push(i);
        }
    }
    public long subArrayRanges(int[] nums) {
        int n =  nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        int[] nge = new int[n];
        int[] pge = new int[n];
        nse(nums,nse);
        pse(nums,pse);
        nge(nums,nge);
        pge(nums,pge);

        long minSum = 0; long maxSum = 0;
        for(int i=0;i<n;i++){
            int leftMin = i-pse[i];
            int rightMin = nse[i]-i;
            minSum += (long)leftMin*rightMin*nums[i];
            int leftMax = i-pge[i];
            int rightMax = nge[i]-i;
            maxSum += (long)leftMax*rightMax*nums[i];
        }
        return (maxSum-minSum);
    }
}