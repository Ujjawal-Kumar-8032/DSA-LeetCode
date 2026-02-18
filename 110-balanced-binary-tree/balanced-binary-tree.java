class Solution {
    boolean flag = true;
    public int level(TreeNode root){
        if(root==null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        int diff = Math.abs(left-right);
        if(diff > 1) flag = false;
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        level(root);
        return flag;
    }
}