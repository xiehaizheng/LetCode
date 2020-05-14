package Tree;

/*
 * 顺序存储二叉树
 * */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建一个 ArrBinaryTree
//        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

    }

}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrBinaryTree {
    int[] arr;//存储数据结点的数组
    ArrBinaryTree left;
    ArrBinaryTree right;
    ArrBinaryTree root;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public ArrBinaryTree(int[] arr, ArrBinaryTree left, ArrBinaryTree right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    public ArrBinaryTree(ArrBinaryTree root) {
        this.root = root;
    }

    public void setRoot(ArrBinaryTree root) {
        this.root = root;
    }

    public ArrBinaryTree getRoot() {
        return root;
    }

    public ArrBinaryTree getLeft() {
        return left;
    }

    public void setLeft(ArrBinaryTree left) {
        this.left = left;
    }

    public ArrBinaryTree getRight() {
        return right;
    }

    public void setRight(ArrBinaryTree right) {
        this.right = right;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
