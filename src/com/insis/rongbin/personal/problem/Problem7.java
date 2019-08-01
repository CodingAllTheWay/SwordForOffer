package com.insis.rongbin.personal.problem;


public class Problem7 {

    public BinaryTreeNode solution(int[] preOrder, int[] midOrder, int leftInPre, int rightInPre,
                                   int leftInMid, int rightInMid){
        int rootValue = preOrder[leftInPre];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        int rootIndexInMid = 0;
        for(int i = 0 ; i < midOrder.length; i++){
            if(rootValue == midOrder[i]){
                rootIndexInMid = i;
                break;
            }
        }
        if(rootIndexInMid == leftInMid){
            root.left = null;
        }else{
            BinaryTreeNode leftNode = solution(preOrder, midOrder, leftInPre+1,
                    leftInPre+rootIndexInMid-leftInMid, leftInMid, rootIndexInMid-1);
            root.left = leftNode;
        }
        if(rootIndexInMid == rightInMid){
            root.right = null;
        }else{
            BinaryTreeNode rightNode = solution(preOrder, midOrder, leftInPre+rootIndexInMid-leftInMid+1,
                    rightInPre, rootIndexInMid+1, rightInMid);
            root.right = rightNode;
        }
        return root;
    }

    public void preOrderTraversal(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args){
        int []preOrder = {1,2,4,7,3,5,6,8};
        int []midOrder = {4,7,2,1,5,3,8,6};
        Problem7 p = new Problem7();
        BinaryTreeNode root = p.solution(preOrder, midOrder, 0, 7, 0, 7);
        p.preOrderTraversal(root);
    }
}

class BinaryTreeNode{
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;
    public BinaryTreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}