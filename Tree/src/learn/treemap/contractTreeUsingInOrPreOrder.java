package learn.treemap;

import java.util.ArrayList;
import java.util.List;

public class contractTreeUsingInOrPreOrder {

    private static TreeNode contractTree(int idx , int[] preorder, int[] inorder){
        if(inorder.length == 1) return new TreeNode(preorder[idx] , null , null);
        //left
        List<Integer> left = new ArrayList<>();

        int i = 0;
        while(i < inorder.length){
            if(inorder[i] == preorder[idx]){
                break;
            }
            left.add(inorder[i]);
            i++;
        }
        int[] firstInOrder = left.stream().mapToInt(Integer::intValue).toArray();
        TreeNode leftNode = contractTree(idx+1, preorder,firstInOrder);

        //Right
        List<Integer> right = new ArrayList<>();

        int j = i+1;
        while(j < inorder.length){
            right.add(inorder[j]);
            j++;
        }
        int[] secondInOrder = right.stream().mapToInt(Integer::intValue).toArray();
        TreeNode rightNode = contractTree(idx+2, preorder,secondInOrder);

        //Root
        TreeNode root = new TreeNode(preorder[idx]);
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0] , null , null);

        TreeNode root = contractTree(0 , preorder , inorder);
        List<Integer> list = new ArrayList<>();
        treeTraversal(root , list);
        System.out.println(list);

        return root;
    }

    private static void treeTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        treeTraversal(root.left, list);
        list.add(root.val);
        treeTraversal(root.right, list);
    }

    public static void main(String[] args) {
        buildTree(new int[]{1 , 2 , 4 , 5 , 7 , 3 , 6}  , new int[]{4 , 2 , 7 , 5 , 1 , 3 , 6});
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
