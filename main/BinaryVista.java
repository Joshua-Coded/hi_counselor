import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryVista {
    // task 1: function to insert a value into the binary tree
    public BinaryTreeNode insert(BinaryTreeNode root, BinaryTreeNode value) {
        // check if the root is empty
        if (root == null) {
            return new BinaryTreeNode(value);
        }

        // initialization of the binary tree
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);


        //  loop through the children

        while (!queue.isEmpty()) {
            BinaryTreeNode currentNode = queue.poll();


            // check the left child
            if(currentNode.left == null) {
                currentNode.left = new BinaryTreeNode(value);
                break;
            } else {
                queue.add(currentNode.left);
            }

            if (currentNode.right == null){
                currentNode.right = new BinaryTreeNode(value);
                break;
            } else {
                queue.add(currentNode.right);
            }

            return root;

        }
        return null;
    }
}