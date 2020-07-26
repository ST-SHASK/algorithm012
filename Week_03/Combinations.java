import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

//    77. 组合
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    //
    //示例:
    //
    //输入: n = 4, k = 2
    //输出:
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        asd(n, k, 1, new Stack<>());
        return result;
    }

    private void asd(int n, int k, int begin, Stack<Integer> res) {

        if (k == res.size()) {
            result.add(new ArrayList<>(res));
            return;
        }

        for (int i = begin; i <= n - (k - res.size()) + 1; i++) {
            res.add(i);
            asd(n, k, i + 1, res);
            res.pop();
        }
    }
}
