class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i % n])
                st.pop();
            if (i < n) {
                if (st.size() == 0)
                    res[i] = -1;
                else
                    res[i % n] = st.peek();
            }
            st.push(nums[i % n]);
        }
        return res;
    }
}