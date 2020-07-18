package easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversal {

    // 589. N叉树的前序遍历

    // 给定一个 N 叉树，返回其节点值的前序遍历

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

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        loop(root, res);
        return res;
    }

    void loop(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            loop(node, res);
        }
    }
}
