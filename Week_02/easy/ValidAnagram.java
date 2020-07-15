package easy;

import java.util.Arrays;

public class ValidAnagram {

    //242. 有效的字母异位词
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    //
    //示例 1:
    //
    //输入: s = "anagram", t = "nagaram"
    //输出: true

    //示例 2:
    //
    //输入: s = "rat", t = "car"
    //输出: false
    //说明:
    //你可以假设字符串只包含小写字母。

    // 排序后按顺序比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    // 字母做 hash 字典， 两两相抵
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] ++;
            chars[t.charAt(i) - 'a'] --;
        }

        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    // charAt() 会比较消耗时间
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];

        for (char ch : s.toCharArray()) {
            chars[ch - 'a'] ++;
        }
        for (char ch : t.toCharArray()) {
            chars[ch - 'a'] --;
        }

        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
