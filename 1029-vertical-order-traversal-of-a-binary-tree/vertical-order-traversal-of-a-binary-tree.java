class Solution {
    class Triplet implements Comparable<Triplet>{
        TreeNode node;
        int h;
        int v;
        public Triplet(TreeNode node, int h, int v){
            this.node=node;
            this.h=h;
            this.v=v;
        }
        public int compareTo(Triplet t) {
            if (this.v != t.v) return this.v - t.v;
            if (this.h != t.h) return this.h - t.h; 
            return this.node.val - t.node.val;
        }
    }
    public void traverse(TreeNode root,int h, int v,ArrayList<Triplet> set){
        if(root==null) return;
        set.add(new Triplet(root,h,v));
        traverse(root.left,h+1,v-1,set);
        traverse(root.right,h+1,v+1,set);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Triplet> set = new ArrayList<>();
        traverse(root,0,0,set);
        Collections.sort(set);
        int ver = Integer.MIN_VALUE;
        for(Triplet t : set){
            if(ver!=t.v){
            ans.add(new ArrayList<>());
            ver=t.v;
            }
            ans.get(ans.size()-1).add(t.node.val);
        }
        return ans;
    }
}