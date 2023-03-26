package com.lyl;

import java.util.*;

public class TreeApplication {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext())
//        {
//            System.out.println("请输入一个整数");
//            int i=sc.nextInt();
//            System.out.println(i);
//        }

//        List<ArrayList<Integer>> lstTree = new ArrayList<>();
//        System.out.println(lstTree.size());
//        TreeNode treeNode=new TreeNode();
//        List<Integer> lst = new ArrayList<>();
//        lst=null;
//        TreeNode node=new TreeNode();
//        if( Objects.isNull(node))
//        {
//            System.out.println("1"+true);
//        }
//        if (lst!=null) {
//            System.out.println(true);
//        }
//        Entry parent=null;
//        Entry preEntry=null;
//        Entry currentEntry=null;
//        for (int i=0;i<10;i++)
//        {
//            Entry<Integer> objectEntry = new Entry<>(i);
//            if(currentEntry==null)
//            {
//
//                parent = preEntry = currentEntry=objectEntry;
//            }
//            else
//            {
//
//                currentEntry=objectEntry;
//                preEntry.right=currentEntry;
//                currentEntry.left=preEntry;
//                preEntry=currentEntry;
//            }
//        }
//       while (parent!=null)
//       {
//           System.out.println(parent.getValue());
//           parent=parent.right;
//       }

//        treeNode.initFullTree(5);
//       List<List<Integer>> levelOrder =tarversalLevel(treeNode.root,1);
//        treeNode.initByArray();
//        treeNode.show();
      //  System.out.println(levelOrder.toString());
//        TreeNode treeNode=new TreeNode();
//        treeNode.initFullTree(5);
//        treeNode.show();
//        treeNode.travelsalTreeByNodeKey(6);
//        Entry entry= treeNode.changeTreeToLinkList();
//        entry.show();
//        Set<Integer> set = new HashSet<>();
//        int k=5;
//       int[] nums=new int[]{1,2,3,4,5,6,7,1,1};
//        for (int j = 0; j < nums.length; j++) {
//            if(j>k)
//            {
//                set.remove(nums[j - k - 1]);
//            }
//            if(!set.add(nums[j])){
//
//            }
//        }
//        boolean isHas = contain();
//        System.out.println(isHas);
//
//        System.out.println( maxArraySum());
//        print();
    }

    public List<Integer> lst = new ArrayList<>();
    public void tarversalTreeNodeByMid(TreeNode1 node)
    {
        if(node!=null)
        {
            tarversalTreeNodeByMid(node.left);
            lst.add(node.val);
            tarversalTreeNodeByMid(node.right);
        }
    }

    public List<TreeNode1> treeLst = new ArrayList<>();
    public void init(int i)
    {
        if(i==0)
        {
            TreeNode1 node1=new TreeNode1(i);
            treeLst.add(node1);
        }
        getType(1,i);
    }
    public List<TreeNode1> getType(int start,int end)
    {
        List<TreeNode1> allTreelst = new ArrayList<>();
        if (start > end) {
            allTreelst.add(null);
            return allTreelst;
        }
        if(start<end)
        {
            for (int i = start; i < end; i++) {
                List<TreeNode1> leftTreeLst= getType(start,i-1);
                List<TreeNode1> rightTreeLst= getType(i+1,end);

            for (TreeNode1 leftTree:leftTreeLst
                 ) {
                for (TreeNode1 rightTree:rightTreeLst
                     ) {
                    TreeNode1 node1 = new TreeNode1(i);
                    node1.left=leftTree;
                    node1.right=rightTree;
                    allTreelst.add(node1);
                }
                
            }
            }
        }
        return allTreelst;
    }
    public static  void print()
    {
        int[][] nums= {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> lst=new ArrayList<>();

        print1(0,nums.length-1,0,nums[0].length-1,0,0,1,nums, lst);
    }
    public static void print1(int topnum,int downnum,int leftnum,int right,int x,int y,int dir, int[][] nums,List<Integer> lst)
    {

        if(topnum!=downnum||leftnum!=right) {

            switch (dir) {
                case 1:
                    if (x < right) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum, right, x + 1, y, dir, nums,lst);
                    } else if (x == right) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum + 1, downnum, leftnum, right, x, y + 1, 2, nums,lst);
                    }
                    break;
                case 2:
                    if (y < downnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum, right, x, y + 1, dir, nums,lst);
                    } else if (y == downnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum, right - 1, x - 1, y, 3, nums,lst);
                    }
                    break;
                case 3:
                    if (x > leftnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum, right, x - 1, y, dir, nums,lst);
                    } else if (x == leftnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum - 1, leftnum, right, x, y - 1, 4, nums,lst);
                    }
                    break;
                case 4:
                    if (y > topnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum, right, x, y - 1, dir, nums,lst);
                    } else if (y == topnum) {
                        System.out.println(nums[y][x]);
                        lst.add(nums[y][x]);
                        print1(topnum, downnum, leftnum + 1, right, x+1, y , 1, nums,lst);
                    }
                    break;

            }
        }
        else
        {
            System.out.println(nums[topnum][leftnum]);
            lst.add(nums[y][x]);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode.Node root) {
        List<List<Integer>> lstQueue = new ArrayList<>();
        if(root==null)
        {
            return lstQueue;
        }
         lstQueue= tarversalLevel(root,1);
        return lstQueue;

    }

    public static List<List<Integer>> tarversalLevel(TreeNode.Node node,int level)
    {
        List<List<Integer>> lstQueue = new ArrayList<>();

            if(node!=null)
            {
                if(lstQueue.size()<level)
                {
                    lstQueue.add(new ArrayList<Integer>());
                }
               Integer value= (Integer) node.getValue();
                lstQueue.get(level-1).add(value);
                if(node.left!=null)
                {
                    lstQueue.addAll(tarversalLevel(node.left,level+1));
                }
                if(node.right!=null){
                    lstQueue.addAll(tarversalLevel(node.right, level + 1));
                }
            }
            return lstQueue;
    }
    public static int getdir(int dir)
    {
        if(dir<4)
        {
          return   dir++;
        }
        else
        {
            return 1;
        }
    }
    public static int maxArraySum() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int current, beforSum, currentSum, max;
        current = beforSum=currentSum = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果相加的值小于0，则抛除之前所有值。
            currentSum= beforSum+nums[i];
            if(currentSum<0)
            {
                beforSum=0;
            }
            else
            {
                beforSum=currentSum;
            }
            if(max<currentSum)
            {
                max=currentSum;
            }
            //当前值和max作比较，大于则替换。
        }
        return max;
    }

    public static boolean contain()
    {
        int[] nums=new int[]{1,2,3,4,5,7,3,1,6};
        int k=3,t=0;
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i <nums.length ; i++) {
            //首先满足j-i<k
            if(i>k)
            {
                map.remove(i-k-1);
            }
//            //对比内容
//           Optional<Integer> max= map.values().stream().max((a, b)->a-b);
//            Optional<Integer> min= map.values().stream().min((a, b)->a-b);
//         if(max.orElse(new Integer(0))-min.orElse(new Integer(0))<t)
//         {
//             return true;
//         }
            for (Integer value:
                 map.values()) {
                if (Math.abs(value - nums[i]) <= t) {
                    return true;
                }
            }
            map.put(i,nums[i]);
            //再满足//nums[j]-num[i]<k
        }
        return false;
    }
}
