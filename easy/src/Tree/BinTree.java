package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinTree {


    private BinTree lChild;//左孩子
    private BinTree rChild;//右孩子
    private BinTree root;//根节点
    private Object data;//数据域

    public BinTree() {
    }

    public BinTree(BinTree lChrild, BinTree rChild, Object data) {
        this.lChild = lChrild;
        this.rChild = rChild;
        this.data = data;
    }

    public BinTree(Object data) {
        this(null, null, data);
    }

    public void createTree(Object[] objects) {
        List<BinTree> datas = new ArrayList<>();//存储所有节点
        for (Object obj : objects) {
            datas.add(new BinTree(obj));
        }
        root = datas.get(0);//将一个作为根节点
        for (int i = 0; i < objects.length / 2; i++) {
            datas.get(i).lChild = datas.get(2 * i + 1);
            if (2 * i + 2 < objects.length) {//避免偶数的时候，下标越界
                datas.get(i).rChild = datas.get(2 * i + 2);
            }
        }
    }

    //先序遍历
    public void preorder(BinTree root) {
        if (root != null) {
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }
    }

    //中序遍历
    public void inorder(BinTree root) {
        if (root != null) {
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }
    }

    public void afterorder(BinTree root) {
        if (root != null) {
            afterorder(root.lChild);
            afterorder(root.rChild);
            visit(root.getData());
        }
    }

    private void visit(Object obj) {
        System.out.print(obj + " ");
    }

    public Object getData() {
        return data;
    }

    public BinTree getRoot() {
        return root;
    }

    public BinTree getlChild() {
        return lChild;
    }

    public BinTree getrChild() {
        return rChild;
    }

    public void setlChild(BinTree lChild) {
        this.lChild = lChild;
    }

    public void setrChild(BinTree rChild) {
        this.rChild = rChild;
    }

    public static void main(String[] args) {
        Object[] objs = {0, 1, 2, 3, 4, 5, 6, 7};
        BinTree binTree = new BinTree();
        binTree.createTree(objs);

        binTree.inorder(binTree.getRoot());//7 3 1 4 0 5 2 6
        System.out.println();
        binTree.preorder(binTree.getRoot());//0 1 3 7 4 2 5 6
        System.out.println();
        binTree.afterorder(binTree.getRoot());//7 3 4 1 5 6 2 0
    }

}
