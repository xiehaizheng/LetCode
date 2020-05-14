package Tree;

import java.util.LinkedList;
import java.util.Queue;

/* 来源：leetcode
* 给定一个二叉树，找出其最大深度。
*
* */
public class MaxDepth104 {
    public static void main(String[] args) {
        Object[] obj = {3,9,20,null,null,15,7};
        BinTree binTree = new BinTree();
        binTree.createTree(obj);
        int res = maxDepth(binTree.getRoot());
        int BFSres = maxDepthBFS(binTree.getRoot());
        System.out.println("递归算法：");
        System.out.println("二叉树的深度为：" + res);
        System.out.println("广度优先遍历（BFS）：");
        System.out.println("二叉树的深度为：" + BFSres);
    }
    // 递归 时间复杂度O（N），N是节点的数量。
    public static int maxDepth(BinTree root){
            if (root == null){
                return 0;
            }else{
                int leftDepth = maxDepth(root.getlChild());
                int rightDepth = maxDepth(root.getrChild());
                return Math.max(leftDepth,rightDepth) + 1;
            }
    }
    // 广度优先遍历（BFS）
    public static int maxDepthBFS(BinTree root){
        if(root  == null){
            return 0;
        }
        Queue<BinTree> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < queue.size(); i++) {
                BinTree temp = queue.poll();
                if (temp.getlChild() != null){queue.add(temp.getlChild());}
                if (temp.getrChild() != null){queue.add(temp.getrChild());}
            }
        }
        return depth;
    }

}
