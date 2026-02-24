class Solution {
    class Pair{
        int level;
        TreeNode TreeNode;
        public Pair(TreeNode TreeNode, int level){
            this.TreeNode=TreeNode;
            this.level=level;
        }
    }
    public void levelTraverse(TreeNode root,List<List<Integer>> ans){
        Queue<Pair> q = new LinkedList<>();
        if(root!=null) q.add(new Pair(root,0));
        while(q.size()>0){
            Pair front = q.remove();
            int lvl = front.level;
            TreeNode node = front.TreeNode;
            if(lvl==ans.size()) ans.add(new ArrayList<>());
            if(lvl%2==0){
                ans.get(lvl).add(node.val);
            }else{
                ans.get(lvl).add(0,node.val);
            }
            if(node.left!=null) q.add(new Pair(node.left,lvl+1));
            if(node.right!=null) q.add(new Pair(node.right,lvl+1));

        }

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelTraverse(root,ans);
        return ans;
    }
}