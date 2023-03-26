package com.lyl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简单二叉树结构
 */
public class TreeNode<K,V> {
    public Node root;
    /**
     * 层高
     */
    private int level;
    /**
     * 总数
     */
    private int size;

    public void initFullTree(int level) {
        //设置中间节点
        int midRoot = (int) Math.pow(2, level - 1);
        this.level=level;
        Node root=new Node();
        root.key=midRoot;
        root.value=midRoot;
        this.root=root;
        //遍历生成所有节点，节点按照标准二叉树排列
        traversalNodeByRoot(root,1);
    }

    /**
     * 遍历生成二叉树节点并赋值
     * @param node
     * @param currentLevel
     */
    public void traversalNodeByRoot(Node node,int currentLevel) {
        if(node!=null&&currentLevel<level)
        {
            //生成子节点，并关联
            Node leftNode,rightNode;
            int midNum = (int) Math.pow(2, level - currentLevel - 1);
            leftNode = new Node((Integer) node.getKey() - midNum, (Integer) node.getValue() - midNum);
            rightNode = new Node((Integer) node.getKey() + midNum, (Integer) node.getValue() + midNum);
            leftNode.parent=node;
            rightNode.parent=node;
            node.left=leftNode;
            node.right=rightNode;
            traversalNodeByRoot(leftNode,currentLevel+1);
            traversalNodeByRoot(rightNode,currentLevel+1);
        }
    }

    public int COL_MAX_NUM = 100;
    public int ROW_MAX_NUM = 100;
    /**
     * 画布
     */
    public String[][] data=new String[ROW_MAX_NUM][COL_MAX_NUM];
    /**
     * 显示二叉树
     */
    public void show() {
        //初始化画布
        initData();
        //设置层高
        this.level= getLevel(root);
        //填充画布
        int node_x=(int) Math.pow(2,level-2)*3;
        int splitLength = (int) Math.pow(2, level - 2) * 3;
        traversalFullData(root,node_x,0,splitLength);

        //完善画布
        perfectData();
        //读取画布
        for (int i = 0; i < level*2-1; i++) {
            for (int j = 0; j < COL_MAX_NUM; j++) {
                if(data[i][j]!="|")
                {
                    System.out.printf(data[i][j]);
                }
                else
                {
                    System.out.println();
                    break;
                }
            }
        }
    }

    public int getLevel(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int leftLevel=1,rightLevel=1;
        if(node.left!=null)
        {
            leftLevel= getLevel(node.left)+1;
        }
        if (node.right != null) {
            rightLevel=getLevel(node.right)+1;
        }
        if (leftLevel >= rightLevel) {
            return leftLevel;
        } else {
            return rightLevel;
        }

    }
    /**
     * 初始化画布
     */
    private void initData() {
        for (int i = 0; i < ROW_MAX_NUM; i++) {
            for (int j = 0; j < COL_MAX_NUM; j++) {
                data[i][j]="  ";
            }
        }
    }

    private void traversalFullData(Node root, int node_x, int node_y, int splitLength) {
        if (root != null) {
            int left_x,right_x;
            String value = (Integer) root.value < 10 ? "0" + root.value : "" + root.value;
            data[node_y][node_x]=value;
            if (splitLength != 3) {
                splitLength/=2;
                left_x=node_x-splitLength;
                right_x=node_x+splitLength;
            }
            else
            {
                left_x=node_x-2;
                right_x=node_x+2;
            }
            //填充分值符号
            if (root.left != null) {
                data[node_y + 1][node_x - 1] = "/ ";
            }

            if (root.right != null) {
                data[node_y + 1][node_x + 1] = " \\";
            }
            traversalFullData(root.left,left_x,node_y+2,splitLength);
            traversalFullData(root.right,right_x,node_y+2,splitLength);
        }
    }

    /**
     * 清除多余的列占位
     */
    private void perfectData() {
        for (int i = 0; i < ROW_MAX_NUM; i++) {
            int j=COL_MAX_NUM-1;
            while (j >= 0 && data[i][j] == "  ") {
                j--;
            }
            if (j > -1) {
                data[i][j+1] = "|";
            }
        }
    }

    public void travelsalTreeByNodeKey(K key)
    {
        Node node= getNodeByKey(key);
        if (node == null) {
            System.out.println("K值在树结构中不存在");
        } else {
            travelsalNode(node, key,false);
            travelsalNode(root, key,true);
        }

    }
    private Entry entry;
    private List entryList=new ArrayList();
    /**
     * 二叉树转链表，采用后续方式
     */
    public Entry changeTreeToLinkList() {

       //后续遍历得到数组
        traversalTreeWithAfter(root);
       //遍历数组得到链表
        Entry root=new Entry(),current=null,right;
        for (int i = 0; i < entryList.size(); i++) {

            if(i==0)
            {
                current=new Entry(entryList.get(i));
                root=current;
            }
            else
            {

                    right=new Entry(entryList.get(i));
                    current.right=right;
                    right.left=current;
                    current=right;

            }

        }
        return root;

    }
    private void traversalTreeWithAfter (Node root)
    {
        if(root!=null)
        {
            traversalTreeWithAfter(root.left);
            traversalTreeWithAfter(root.right);
            entryList.add(root.key);
        }

    }

    /**
     * 根据Key值获取对应的节点
     * @param key
     * @return
     */
    private Node getNodeByKey(K key)
    {
        Node node=null;
        Node node1=root;
        while (node1!=null)

        {
            if((Integer)node1.getKey() >(Integer) key)
            {
                node1=node1.left;
            }
            else if((Integer)node1.getKey() <(Integer) key)
            {
                node1=node1.right;
            }
            else
            {
              return node1;
            }

        }
        return node;
    }
    public void travelsalNode(Node root,K key,boolean isRoot)
    {
        if(isRoot)
        {
            if(root!=null&&root.getKey()!=key) {
                System.out.println("节点key：" + root.key + "；节点value：" + root.value);
                travelsalNode(root.left, key, isRoot);
                travelsalNode(root.right, key, isRoot);
            }
        }
        else
        {
            if (root != null) {
                System.out.println("节点key：" + root.key + "；节点value：" + root.value);
                travelsalNode(root.left, key, isRoot);
                travelsalNode(root.right, key, isRoot);
            }

        }
    }

    int[] inorder;
    int[] postorder;
    int postx;
    Map<Integer,Integer> inMap=new HashMap<>();
    public Node handle(int left,int right){
        if(left>right||postx<0)
        {
            return  null;
        }
        Node<Integer, Integer> node = new Node<>(postorder[postx], postorder[postx]);

        int index= inMap.get(postorder[postx]);
        postx--;
        node.right=handle(index+1,right);
        node.left=handle(left,index-1);
        return node;
    }
    public void initByArray()
    {
       int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        int roonum=0;

        this.inorder=inorder;
        this.postorder=postorder;
        int i=0;
        for(Integer iVar :inorder) {
            inMap.put(iVar,i++);
        }
        postx=postorder.length-1;
       root= handle(0,inorder.length-1);
    }
    class Node<K,V> {
        private K key;
        private V value;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node parent;
        public Node left;
        public Node right;
    }

}
