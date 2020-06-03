package Tree;
/* 114.二叉树展开为链表
*  给定一个二叉树，原地将它展开为一个单链表。
 *  来源：Leetcode
 * */
public class FlattenTree114 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;treeNode2.left = treeNode3;treeNode2.right = treeNode4;
        treeNode1.right = treeNode5;treeNode5.right = treeNode6;
//        vist(treeNode1);//前序遍历二叉树
        flatten(treeNode1);

    }
    //二叉树展开为链表:方法一
    //展开的顺序其实就是二叉树的先序遍历.
    //1.将左子树插入到右子树的地方
    //2.将原来的右子树接到左子树的最右边节点
    //3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
    public static void flatten(TreeNode root){
        while (root != null){
            //左子树为null，直接考虑下一个节点
            if (root.left == null){
                System.out.print(root.val+ " ");
                root = root.right;
            }else{
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                //将原来的右子树接到左子树最右边的节点
                pre.right = root.right;
                //将左子树插到右子树的地方
                root.right = root.left;
                root.left = null;
                System.out.print(root.val + " ");
                //考虑下一个节点
                root = root.right;
            }
        }

    }
    //定义二叉树
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //前序遍历二叉树
    public static void vist(TreeNode root){
        if (root != null){
            System.out.print(root.val + "-->");
            vist(root.left);
            vist(root.right);
        }
    }
}
