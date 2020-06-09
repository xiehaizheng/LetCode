package Tree;

import java.util.HashMap;
import java.util.Map;

/* 105.从前序与中序遍历构造二叉树 （树、深度优先搜索、数组）
* 根据一棵树的前序遍历与中序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
例如，给出  前序遍历 preorder = [3,9,20,15,7]   中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
* */
public class BuildTree105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree =  buildTree(preorder,inorder);
        preshow(tree);
    }
    //定义二叉树节点
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    //先序遍历二叉树
    public static void preshow(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + "-->");
        preshow(root.left);
        preshow(root.right);
    }

    //从前序与中序遍历构造二叉树
    static Map<Integer,Integer> indexMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构建哈希映射表，帮助我们快速定为根节点
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                        int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        //前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定为根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        //递归构建左子树，并连接根节点
        //先序遍历中从  左边界+1 开始的 size_left_subtree个元素对应了中序遍历中从  左边界开始 到根节点定位-1 的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,
                preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,
                inorder_root+1,inorder_right);
        return root;

    }


}
