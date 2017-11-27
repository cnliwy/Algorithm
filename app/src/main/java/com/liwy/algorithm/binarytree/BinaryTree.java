package com.liwy.algorithm.binarytree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by liwy on 2017/11/24.
 */

public class BinaryTree {
    public TreeNode root = null;

    public BinaryTree(TreeNode root) {
        this.root = root;
        this.root.left = null;
        this.root.right = null;
    }

    /**
     * 打印二叉树
     */
    public void printTree(){
        ArrayList<ArrayList<Integer>> sections = new ArrayList<>();
        if (root != null){
            //添加根节点数据
            ArrayList<Integer> rootSection = new ArrayList<>();
            rootSection.add(root.val);
            sections.add(rootSection);
            System.out.println(rootSection);
            // 遍历子节点
            ArrayList<TreeNode> parents = new ArrayList<>();
            parents.add(root);
            while (true){
                ArrayList<TreeNode> childs = new ArrayList<>();
                ArrayList<Integer> childSection = new ArrayList<>();
                if (parents.size() > 0){
                    for (TreeNode parent:parents){
                        if (parent.left != null){
                            childSection.add(parent.left.val);
                            childs.add(parent.left);
                        }
                        if (parent.right != null){
                            childSection.add(parent.right.val);
                            childs.add(parent.right);
                        }
                    }
                    // 添加当前行的子节点数据
                    if (childSection.size() > 0){
                        System.out.println(childSection);
                        sections.add(childSection);
                        parents = childs;
                    }else{
                        break;
                    }
                }else{
                    break;
                }

            }
        }else{
            System.out.println("这是颗绝望的死树！");
        }
    }

    /**
     * 插入二叉树
     * @param value
     */
    public String insert(int value){
        String error = null;
        TreeNode node = new TreeNode(value);
        if (root == null){
            root = new TreeNode(value);
            root.right = null;
            root.left = null;
        }else{
            TreeNode current = root;
            TreeNode parent = null;
            while (true){
                if (value < current.val){
                    parent = current;
                    current = parent.left;
                    if (current == null){
                        parent.left = node;
                        break;
                    }
                }else if (value > current.val){
                    parent = current;
                    current = parent.right;
                    if (current == null){
                        parent.right = node;
                        break;
                    }
                }else{
                    // 已存在值，不能重复插入
                    error = "the same value had been in the binaryTree!";
                }
            }
        }
        return error;
    }

    /**
     * 根据值查找节点
     * 从根节点开始查找
     * @param value
     */
    public TreeNode findKey(int value){
        TreeNode current = root;
        while (true){
            if (current == null)return null;
            if (value == current.val){
                return current;
            }else if (value < current.val){
                current = current.left;
            }else if (value > current.val){
                current = current.right;
            }
        }
    }

    /**
     * 二叉树的遍历分为前序遍历、中序遍历、后序遍历
     * 前中后其实是以根节点为标识的
     * 前序即根-左-右
     * 中序即左-根-右
     * 后序即左-右-根
     */
    /**
     * 前序遍历：按照“根左右”,先遍历根节点，再遍历左子树 ，再遍历右子树
     */
    public void preOrderTraverse(TreeNode node){
        if (node == null)return;
        node.display();
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    public void preOrderByStack(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true){
            while (current != null){
                stack.push(current);
                current.display();
                current = current.left;
            }

            if (!stack.isEmpty()){
                current = stack.pop();
                current = current.right;
            }else{
                break;
            }
        }
    }
    /**
     * 中序遍历：按照“左根右“,先遍历左子树，再遍历根节点，最后遍历右子树
     * 1 调用自身（根节点）来遍历节点的左子树
     * 2 访问自身
     * 3 调用自身来遍历节点的右子树
     *  中序遍历为顺序遍历
     */
    public void inOrderTraverse(TreeNode node){
        if (node == null)return;
        inOrderTraverse(node.left);
        node.display();
        inOrderTraverse(node.right);
    }
    // 中序遍历，非递归方式
    public void inOrderByStack(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true){
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                node.display();
                current = node.right;
            }else{
                break;
            }
        }
    }

    /**
     * 后序遍历：按照“左右根”，先遍历左子树，再遍历右子树，最后遍历根节点
     */
    public void postOrderTraverse(TreeNode node){
        if (node == null)return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        node.display();
    }
    // 后序遍历，非递归方式
    public void postOrderByStack(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode preNode = null;
        while (true){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()){
                current = stack.peek().right;
                if (current == null || current == preNode){
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }else{
                break;
            }
        }
    }

    /**
     * 根据值删除树节点
     * @param value
     */
    public void deleteValue(int value){
        System.out.println("正在删除节点："+ value);
        TreeNode parentNode = null;//父节点
        boolean isLeft = false;//自身相对于父节点是左子节点还是右子节点
        TreeNode current = root;//当前节点
        // 遍历查出该值所在的节点位置及其父节点
        while (true){
            if (current != null){
                if (current.val == value){
                    break;
                }else if (value < current.val){
                    parentNode = current;
                    current = current.left;
                    isLeft = true;
                }else if (value > current.val){
                    parentNode = current;
                    current = current.right;
                    isLeft = false;
                }
            }else{
                break;
            }
        }
        // 根据查出来的结果开始删除此节点
        if (current == null){
            System.out.println("不存在此节点");
        }else{
            if (parentNode == null){
                System.out.println("删除整棵树");
                root = null;
            }else{

                if (current.left == null && current.right == null){
                    // 如果是叶子节点,直接删除
                    if (isLeft)parentNode.left = null;
                    if (!isLeft)parentNode.right = null;
                }else if (current.left != null && current.right == null){
                    // 如果左孩子不为空，右孩子为空
                    if (isLeft)parentNode.left = current.left;
                    if (!isLeft)parentNode.right = current.left;
                }else if (current.right != null && current.left == null){
                    // 如果右孩子不为空，左孩子为空
                    if (isLeft)parentNode.left = current.right;
                    if (!isLeft)parentNode.right = current.right;
                }else if (current.right != null && current.left != null){
                    TreeNode successor = getSuccessor(current);
                    System.out.println("继承节点==================>" + successor.val);
                    // 左右均不为空
                    if (isLeft){
                        parentNode.left = successor;
                        successor.left = current.left;
                    }else{
                        parentNode.right = successor;
                        successor.left = current.left;
                    }
                }
                current = null;
            }
        }
    }

    /**
     * 获取删除节点的继承节点
     * @param delNode
     * @return
     */
    public TreeNode getSuccessor(TreeNode delNode){
        TreeNode successor = delNode;
        TreeNode successorParent = null;
        TreeNode current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        //如果后继节点不是删除节点的右子节点时，
        if (successor != delNode.right) {
            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.left = successor.right;
            //并将删除节点的右子节点指向后继结点的右子节点
            successor.right = delNode.right;
        }
        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.left = delNode.left;

        return successor;
    }
}
