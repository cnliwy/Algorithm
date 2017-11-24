package com.liwy.algorithm;

import com.liwy.algorithm.binarytree.BinaryTree;
import com.liwy.algorithm.binarytree.TreeNode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void binaryTree() {
        TreeNode root = new TreeNode(5);
        BinaryTree tree = new BinaryTree(root);

        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(10);
        tree.insert(11);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.insert(13);

        tree.printTree();//打印二叉树

//        tree.preOrderTraverse(tree.root);// 前序遍历
//        tree.preOrderByStack();

//        tree.inOrderTraverse(tree.root);//中序遍历,递归方式
//        tree.inOrderByStack();

//        tree.postOrderTraverse(tree.root);// 后序遍历
//        tree.postOrderByStack();

//        TreeNode node8 = tree.findKey(8);
//        TreeNode node3 = tree.findKey(3);
//        node3.left.display();
//        node3.right.display();
        tree.deleteValue(5);
        tree.printTree();
    }
}