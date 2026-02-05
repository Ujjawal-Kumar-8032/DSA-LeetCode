class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        boolean shouldPush = false;
        for(int num : nums){
            shouldPush = true;
            while(st.size()!=0 && st.peek()>0 && num<0){
                int peek = st.peek();
                if(peek>0 && peek == num * -1){
                    st.pop();
                    shouldPush = false;
                    break;
                }
                else if (Math.abs(peek)>Math.abs(num)){
                    shouldPush = false;
                    break;
                }
                else if (Math.abs(peek)<Math.abs(num)){
                    st.pop();
                }
            }
            if(shouldPush){
            st.push(num);
            }
        }
        int[] res = new int[st.size()];
        for(int i = res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}