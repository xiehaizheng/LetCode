package String;
/* 49.字母异位词分组  相关标签：哈希表、字符串
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:输入: ["eat", "tea", "tan", "ate", "nat", "bat"]输出:
[["ate","eat","tea"],["nat","tan"],["bat"]]
说明：所有输入均为小写字母。不考虑答案输出的顺序。
来源：力扣（LeetCode）
* */

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res =  groupAnagrams(strs);
        System.out.println(res);
    }
//方法二：按计数分类
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
//                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

//方法一：排序数组分类
//    private static List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return  new ArrayList();
//        Map<String,List> ans = new HashMap<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key = String.valueOf(chars);
//            if (!ans.containsKey(key)) ans.put(key,new ArrayList());
//            ans.get(key).add(str);
//        }
//        return new ArrayList(ans.values());
//    }
}
