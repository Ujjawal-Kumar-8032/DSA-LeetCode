
class Solution {
    public void path(TreeNode root, String s, ArrayList<String> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s += root.val;
            ans.add(s);
            return;
        }
        path(root.left,s+root.val+"->",ans);
        path(root.right,s+root.val+"->",ans);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        if(root==null) return ans;
        path(root,"",ans);
        return ans;
    }
}