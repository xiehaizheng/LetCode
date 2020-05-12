package Tree;
/* 来源：leetcode
* 给定一个二叉树，检查它是否是镜像对称的。
*
* */
public class IsSymmetric101 {
    public static void main(String[] args) {
        BinTree binTree = new BinTree();
//        Object[] objs = {1,2,2,3,4,4,3};
        Object[] objs = {1,2,2,null,3,null,3};
        binTree.createTree(objs);
        boolean res = isSymmetric(binTree.getRoot());
        System.out.println("二叉树镜像对称：" + res);
    }
    // 递归 时间复杂度：O(n)
    // 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。因此，该问题可以转化为：两个树在什么情况下互为镜像？
    // 如果同时满足下面的条件，两个树互为镜像：1.它们的两个根结点具有相同的值。2.每个树的右子树都与另一个树的左子树镜像对称。
    public static boolean isSymmetric(BinTree root) {
        return isMirror(root,root);

    }
    public static boolean isMirror(BinTree root1,BinTree root2 ){
        if (root1 == null && root2 == null){ return true;}
        if (root1 == null || root2 == null){ return false;}
        return (root1.getData() == root2.getData())
                &&isMirror(root1.getlChild(),root2.getrChild())
                &&isMirror(root1.getrChild(),root2.getlChild());

    }
}
