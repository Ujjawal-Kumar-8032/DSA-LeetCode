class Solution {
    int max = 0;
    public int level(TreeNode root){
        if(root==null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        int dia = left+right;
        max = Math.max(dia,max);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        level(root);
        return max;
    }
}