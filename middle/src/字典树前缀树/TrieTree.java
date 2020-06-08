package 字典树前缀树;

import java.io.StringReader;

/* 字典树模版，默认只包含26个小写字母
* Trie树，即字典树，又称单词查找树或键树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计和排序大量的字符串
* （但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较。
* Trie的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
* 前缀树的3个基本性质：
1.根节点不包含字符，除根节点外每一个节点都只包含一个字符。
2.从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
3.每个节点的所有子节点包含的字符都不相同。
字典树的空间相比较hash还是比较浪费的
* */
public class TrieTree {
    private final int SIZE = 26;//每个节点能包含的子节点数，即需要SIZE个指针来指向其孩子
    private Node root;//字典树的根节点

    public Node getRoot() {
        return root;
    }

    //字典树节点类
    private class Node{
        private boolean isStr;//标识该节点是否为某一字符串终端节点
        private int num;// 标识经过该节点的字符串数，在计算前缀包含的时候会用到
        private Node[] child;//该节点的子节点

        public Node() {
            isStr = false;
            num = 1;
            child = new Node[SIZE];
        }
    }

    public TrieTree() {
        root = new Node();
    }
    //检查字典树中是否完全包含字符串word
    public boolean hasStr(String word){
        Node pNode = this.root;
        //逐个字符去检查
        for (int i = 0; i < word.length() ; i++) {
            int index =  word.charAt(i) - 'a';
            //在字典树中没有对应的节点，或者word字符串的最后一个字符在字典树中检测对应节点的isStr属性为false，返回
            //false
            if (pNode.child[index] == null || (i + 1 == word.length() && pNode.child[index].isStr == false)){
                return false;
            }
            pNode = pNode.child[index];
        }
        return true;
    }
    // 在字典树中插入一个单词
    public void insert(String word){
        if (word == null || word.isEmpty()){return;}
        Node pNode = this.root;
        for (int i = 0; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            if (pNode.child[index] == null){//如果不存在节点，则new一个节点插入字典树
                Node tmpNode = new Node();
                pNode.child[index] = tmpNode;
            }else {//如果字典树中该路径上存在节点，则num+1，表示在该节点上有一个新的单词经过
                pNode.child[index].num++;
            }
            pNode = pNode.child[index];
        }
        pNode.isStr = true;
    }
    //统计在字典树中有多少个单词是以str为前缀的
    public int countPrefix(String str){
        Node pNode = this.root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (pNode.child[index] == null){
                return 0;
            }else {
                pNode = pNode.child[index];
            }
        }
        return pNode.num;
    }
    //先序遍历
    public void preWalk(Node root){
        Node pNode = root;
        for (int i = 0; i < SIZE; i++) {
            if (pNode.child[i] != null){
                System.out.println((char)('a' + i) + "--");
                preWalk(pNode.child[i]);
            }
        }
    }
}
