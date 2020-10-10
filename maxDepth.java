/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int depth=0;
    List<Integer> total =new ArrayList<>();
    public int maxDepth(Node root) {
        if (root==null) {
            return 0;
        }
        recursion(root);
        for (int i = 0; i < Math.floor(total.size()/2); i++) {
            int temp=0;
            if (total.get(i)>total.get(total.size()-i-1)) {
                temp = total.get(i);
            } else {
                temp = total.get(total.size()-i-1);
            }
            if (temp>depth) {
                depth = temp;
            }
        }
        if (total.size()%2!=0 && total.get((int)Math.floor(total.size()/2))>depth) {
            depth = total.get((int)Math.floor(total.size()/2));
        }
        return depth+1;
    }
    public void recursion(Node root) {
        for (int i=0;i<root.children.size();i++) {
            depth++;
            total.add(depth);
            recursion(root.children.get(i));
            depth--;
        }
    }
}
