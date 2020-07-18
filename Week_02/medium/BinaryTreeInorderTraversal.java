package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    //94. 二叉树的中序遍历

    //给定一个二叉树，返回它的中序 遍历。
    //
    //示例:
    //
    //输入: [1,null,2,3]
    //   1
    //    \
    //     2
    //    /
    //   3
    //
    //输出: [1,3,2]
    //进阶: 递归算法很简单，你可以通过迭代算法完成吗？

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        loop(root, res);
        return res;
    }

    void loop(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        loop(root.left, res);
        res.add(root.val);
        loop(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
