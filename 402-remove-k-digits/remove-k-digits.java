class Solution {
    public String removeKdigits(String s, int k) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(st.size()!=0 && k>0 && st.peek()>arr[i]){
                st.pop();
                k--;
            }
            st.push(arr[i]); 
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if(sb.length()==0) return "0";
        else return sb.toString();
    }
}