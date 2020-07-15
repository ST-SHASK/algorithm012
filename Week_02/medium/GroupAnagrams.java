package medium;

import java.util.*;

public class GroupAnagrams {

    //49. 字母异位词分组

    //给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    //
    //示例:
    //
    //输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出:
    //[
    //  ["ate","eat","tea"],
    //  ["nat","tan"],
    //  ["bat"]
    //]
    //说明：
    //
    //所有输入均为小写字母。
    //不考虑答案输出的顺序。

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        List<String> list;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (map.containsKey(sortStr)) {
                list = map.get(sortStr);
                list.add(str);
                map.put(sortStr, list);
            } else {
                list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);

            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    // 简化
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(str);
        }
        return new ArrayList<>(map.values());
    }


    // 简化
    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            List<String> orDefault = map.getOrDefault(sortStr, new ArrayList<>());
            orDefault.add(str);
            map.put(sortStr, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    // 26 个字母 hash 字典
    public List<List<String>> groupAnagrams4(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams3(strs));
    }
}
