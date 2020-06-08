package 字典树前缀树;
/*
*  208.实现Trie（前缀树/字典树）
* 实现一个 TrieTree (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:TrieTree trie = new TrieTree();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:你可以假设所有的输入都是由小写字母 a-z 构成的。保证所有输入均为非空字符串
来源：力扣（LeetCode）
* */
public class Trie208 {
    public static void main(String[] args) {
        Trie208 trie = new Trie208();
        trie.insert("word");
        boolean word = trie.search("word");
        boolean wo = trie.startsWith("wo");
        boolean wo1 = trie.search("wo");
        trie.insert("wo");
        boolean wo2 = trie.search("wo");
        System.out.println(word + "  " + wo + "  " + wo1 + "  " + wo2);

    }
    private boolean isStr = false;
    private Trie208 next[] = new Trie208[26];

    public Trie208() {
    }
    public void insert(String word){//插入单词
        Trie208 root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] - 'a'] == null){
                root.next[w[i] - 'a'] = new Trie208();
            }
            root = root.next[w[i] - 'a'];
        }
        root.isStr = true;
    }
    public boolean search(String word){//查找单词
        Trie208 root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] - 'a'] == null) return  false;
            root = root.next[w[i] - 'a'];
        }
        return root.isStr;
    }
    public boolean startsWith(String prefix){
        Trie208 root = this;
        char[] p = prefix.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (root.next[p[i] - 'a'] == null) return false;
            root =  root.next[p[i] - 'a'];
        }
        return true;
    }
}
