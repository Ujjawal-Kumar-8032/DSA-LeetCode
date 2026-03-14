class Solution {
    public void invert(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        if(p.val!=q.val) return false;
        if(isSame(p.left,q.left)==false) return false;
        if(isSame(p.right,q.right)==false) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        invert(root.right);
        return isSame(root.left,root.right);
    }
}