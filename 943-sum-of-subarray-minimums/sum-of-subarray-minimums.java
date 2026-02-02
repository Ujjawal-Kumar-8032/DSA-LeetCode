class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        int mod = 1000000007;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        //PSE
        for(int i=0;i<n;i++){
            while(st.size()>0&&arr[st.peek()]>arr[i]) st.pop();
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        st.clear();
        //NSE
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        long res=0;
        for (int i=0;i<n;i++){
            int l = i-pse[i];
            int r = nse[i]-i;
            res = (res+(long)arr[i]*l%mod*r%mod)%mod;
        }
        return (int)res;
    }
}