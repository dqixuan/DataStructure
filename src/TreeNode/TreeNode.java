package TreeNode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class TreeNode {
    int value;
    TreeNode lchild;
    TreeNode rchild;

    public TreeNode(int value) {
        this.value = value;
        lchild = null;
        rchild = null;
    }

    //非递归前序遍历
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.value);
            while (temp != null) {
                if (temp.lchild != null)
                    System.out.print(temp.lchild.value);
                if (temp.rchild != null)
                    stack.push(temp.rchild);
                temp = temp.lchild;
            }
        }
        System.out.println();
    }

    //非递归中序遍历
    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            while (stack.peek() != null)
                stack.push(stack.peek().lchild);
            stack.pop();
            if (!stack.isEmpty()) {
                temp = stack.pop();
                System.out.print(temp.value);
                stack.push(temp.rchild);
            }
        }
        System.out.println();
    }

    //非递归后序遍历
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root;
        TreeNode pre = null;
        boolean flag;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            while (stack.peek() != null)
                stack.push(stack.peek().lchild);
            stack.pop();
            while (!stack.isEmpty()) {
                temp = stack.peek();
                if (temp.rchild == null || temp.rchild == pre) {
                    System.out.print(temp.value);
                    stack.pop();
                    pre = temp;
                    flag = true;
                } else {
                    stack.push(temp.rchild);
                    flag = false;
                }
                if (!flag)
                    break;
            }
        }
        System.out.println();
    }

    //层次遍历
    public static void levelOrder(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.value);
            if (temp.lchild != null)
                queue.add(temp.lchild);
            if (temp.rchild != null)
                queue.add(temp.rchild);
        }
        System.out.println();
    }

    //之字打印二叉树
    public static void zigLevelOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root;
        int line = 1;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextStack = new LinkedList<TreeNode>();
        stack.push(temp);
        while (!stack.isEmpty() || !nextStack.isEmpty()) {
            if (line % 2 == 1) {
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    System.out.print(temp.value);
                    if (temp.lchild != null)
                        nextStack.push(temp.lchild);
                    if (temp.rchild != null)
                        nextStack.push(temp.rchild);
                }
            } else {
                while (!nextStack.isEmpty()) {
                    temp = nextStack.pop();
                    System.out.print(temp.value);
                    if (temp.rchild != null)
                        stack.push(temp.rchild);
                    if (temp.lchild != null)
                        stack.push(temp.lchild);
                }
            }
            line++;
        }
        System.out.println();
    }

    //求二叉树的宽度
    public static int getWidth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp = root;
        queue.add(temp);
        int width = queue.size();
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.lchild != null)
                queue.add(temp.lchild);
            if (temp.rchild != null)
                queue.add(temp.rchild);
            width = Math.max(width, queue.size());
        }
        return width;
    }

    //非递归计算二叉树深度
    public static int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        int len = 0, deep = 0;
        while(!queue.isEmpty()){
            len = queue.size();
            for(int i = 0; i < len; ++i){
                temp = queue.poll();
                if(temp.lchild != null)
                    queue.add(temp.lchild);
                if(temp.rchild != null)
                    queue.add(temp.rchild);
            }
            deep++;
        }
        return deep;
    }

    //非递归中序遍历-- 不借助栈实现(Morris Algorithm)
    public static void inOrderOfMorris(TreeNode root){
        if(root == null)
            return;

    }


    //test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.lchild = node1;
        root.rchild = node2;
        node1.rchild = node3;
        node1.lchild = node7;
        node2.lchild = node4;
        node2.rchild = node5;
        node5.rchild = node6;

        System.out.println(getWidth(root));
        System.out.println(getDepth(root));
        preOrder(root);
        inOrder(root);
        postOrder(root);
        levelOrder(root);
        zigLevelOrder(root);
    }
}
