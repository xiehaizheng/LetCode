package Tree;
//二叉搜索树（BST）/二叉排序树：对于任何一个非叶子节点，要求左子节点的值比当前节点的值小，
// 右子节点的值比当前节点的值大
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }

    //创建Node节点
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        //添加节点的方法：递归的形式添加节点
        public void add(Node node) {
            if (node == null) return;
            //判断传入的节点的值和当前子树的根节点的关系
            if (node.val < this.val) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {//添加的Node的值>=当前节点的值
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }

            }
        }

        //中序遍历
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this.val);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }
    }

    //创建二叉排序树
    static class BinarySortTree {
        private Node root;

        //添加节点的方法
        public void add(Node node) {
            if (root == null) {
                root = node;
            } else {
                root.add(node);
            }
        }

        //中序遍历
        public void infixOrder() {
            if (root != null) {
                root.infixOrder();
            } else {
                System.out.println("二叉排序树为空");
            }
        }
    }
}
