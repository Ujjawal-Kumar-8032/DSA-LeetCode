class Solution {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int max = Integer.MIN_VALUE;
        while(q.size()>0){
            Pair p = q.remove();
            TreeNode n = p.node;
            int lvl = p.level;
            max = Math.max(max,lvl);
            map.put(lvl,n.val);
            if(n.left!=null) q.add(new Pair(n.left,lvl+1));
            if(n.right!=null) q.add(new Pair(n.right,lvl+1));
        }
        for(int i=0;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}