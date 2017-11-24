package com.liwy.algorithm.binarytree;

/**
 * Created by liwy on 2017/11/23.
 */

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void display(){
        System.out.println("node=" + val);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
