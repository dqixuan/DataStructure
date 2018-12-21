package TreeNode;

/**
 * class TreeNode{
 *     int value;
 *     TreeNode lchild;
 *     TreeNode rchild;
 *     public TreeNode(int value){this.value = value;}
 * }
 */

public class BinarySearchTree {
    //搜索二叉树的插入--递归
    public TreeNode insertBST(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
        }else if(root.value > value)
            root.lchild = insertBST(root.lchild, value);
        else
            root.rchild = insertBST(root.rchild, value);
        return root;
    }
    //二叉搜索树的插入--非递归
    public TreeNode insertIntoBST(TreeNode root, int value){
        if(root == null){
            return new TreeNode(value);
        }
        TreeNode cur = root, pre = null;
        while(cur != null){
            pre = cur;
            if(cur.value > value)
                cur = cur.lchild;
            else
                cur = cur.rchild;
        }
        if( pre.value > value)
            pre.lchild = new TreeNode(value);
        else
            pre.rchild = new TreeNode(value);

        return root;
    }


    //二叉搜索树的查找
    public TreeNode findNode(TreeNode root, int value){
        if(root == null)
            return null;
        else{
            while(root != null){
                if(root.value == value)
                    return root;
                else if(root.value > value)
                    root = root.lchild;
                else
                    root = root.rchild;
            }
            return null;
        }
    }


    //二叉搜索树的删除，自己写的比较繁琐，leetcode上超过48%的人
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
            return null;
        TreeNode cur = root.rchild,pre = null;
        //删除根节点的情况
        if(root.value == key){
            if(root.lchild == null && root.rchild == null)
                return null;
            else if(root.lchild != null && root.rchild == null)
                return root.lchild;
            else if(root.lchild == null && root.rchild != null)
                return root.rchild;
            else{
                //找替换节点，并记录其前驱结点
                while(cur.lchild != null){
                    pre = cur;
                    cur = cur.lchild;
                }
                if(pre == null){
                    cur.lchild = root.lchild;
                    return cur;
                }else{
                    pre.lchild = cur.rchild;
                    cur.lchild = root.lchild;
                    cur.rchild = root.rchild;
                    return cur;
                }
            }
        }else{
            cur = root;
            TreeNode parent = null, target = null;
            //找非根节点的目标节点，及其前驱结点
            while(cur != null){
                if(cur.value == key){
                    target = cur;
                    break;
                }else if(cur.value > key){
                    parent = cur;
                    cur = cur.lchild;
                }
                else{
                    parent = cur;
                    cur = cur.rchild;
                }
            }
            if(target == null) //如果目标节点为空，即没有找到该节点
                return root;
            if(target.lchild == null && target.rchild == null){
                if(parent.value > key)
                    parent.lchild = null;
                else
                    parent.rchild = null;
                return root;
            }else if( target.lchild != null && target.rchild == null){
                if(parent.value > key)
                    parent.lchild = target.lchild;
                else
                    parent.rchild = target.lchild;
                return root;
            }else if( target.lchild == null && target.rchild != null){
                if(parent.value > key)
                    parent.lchild = target.rchild;
                else
                    parent.rchild = target.rchild;
                return root;
            }else{
                cur = target.rchild;
                pre = null;
                while(cur.lchild != null){
                    pre = cur;
                    cur = cur.lchild;
                }
                if(pre == null){
                    cur.lchild = target.lchild;
                    if(parent.value > key)
                        parent.lchild = cur;
                    else
                        parent.rchild = cur;
                    return root;
                }else{
                    pre.lchild = cur.rchild;
                    cur.rchild = target.rchild;
                    cur.lchild = target.lchild;
                    if(parent.value > key)
                        parent.lchild = cur;
                    else
                        parent.rchild = cur;
                    return root;
                }
            }
        }
    }




}
