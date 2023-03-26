package com.lyl;

import javafx.beans.binding.StringBinding;

import java.util.List;

public class Application {
    public static void main(String[] args) {
         Solution solution = new Solution();
         TreeNode treeNode1 = new TreeNode();
         treeNode1.val=1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val=2;
        treeNode1.left=treeNode2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val=3;
        treeNode1.right=treeNode3;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val=4;
        treeNode3.left=treeNode4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.val=5;
        treeNode3.right=treeNode5;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.val=6;
        treeNode5.left=treeNode6;
        TreeNode treeNode7 = new TreeNode();
        treeNode7.val=7;
        treeNode5.right=treeNode7;
        TreeNode treeNode8 = new TreeNode();
        treeNode8.val=8;
        treeNode7.left=treeNode8;
        TreeNode treeNode9 = new TreeNode();
        treeNode9.val=9;
        treeNode7.right=treeNode9;
       List<List<Integer>> lst= solution.levelOrderBottom(treeNode1);
        for (List<Integer> parent:
             lst) {
            StringBuilder str=new StringBuilder();
            str.append("[");
            for (Integer child:
                 parent) {
                str.append(child+",");
            }
            str.substring(0,str.length()-2);
            str.append("]");
            System.out.println(str);

        }
    }
}
