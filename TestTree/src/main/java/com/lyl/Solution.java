package com.lyl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private  LinkedList<List<Integer>> lstQueue=new LinkedList();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
        {
            return lstQueue;

        }

        traversalLeverBySorts(root,1);
        return lstQueue;
    }
    public void traversalLeverBySorts(TreeNode root,int level){
        if(root!=null)
        {
            if(lstQueue.size()<level)
            {
                List<Integer> newList=new ArrayList();
                lstQueue.addFirst(newList);
            }
            Integer val=root.val;
            lstQueue.get(0).add(val);

            traversalLeverBySorts(root.left,level+1);


            traversalLeverBySorts(root.right,level+1);


        }
    }
}
