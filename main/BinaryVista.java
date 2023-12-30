package BinaryVistaproject.Application.treeProject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryVista {

    // Task 1: Function to insert a value into the binary tree
    public  BinaryTreeNode insert(BinaryTreeNode root, int value) { 
             // Check if the tree is empty
        if (root == null) {
            // The tree is empty, create a new node as the root
            return new BinaryTreeNode(value);
        }

        // Initialize a queue for level-order traversal
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root); // Add the root to the queue

        // Level-Order Traversal using a while loop
        while (!queue.isEmpty()) {
            // Dequeue a node from the queue
            BinaryTreeNode currentNode = queue.poll();

            // Check and process the left child
            if (currentNode.left == null) {
                // Create a new node with the given value and set it as the left child
                currentNode.left = new BinaryTreeNode(value);
                break; // Exit the loop
            } else {
                // Left child is not null, enqueue it for further exploration
                queue.add(currentNode.left);
            }

            Check and process the right child
            if (currentNode.right == null) {
                // Create a new node with the given value and set it as the right child
                currentNode.right = new BinaryTreeNode(value);
                break; // Exit the loop
            } else {
                // Right child is not null, enqueue it for further exploration
                queue.add(currentNode.right);
            }
        }
        // Return the modified root of the binary tree
        return root;
    }
        return null;
    }


    // Task 1: Function to perform in-order traversal
    public void inOrderTraversal(BinaryTreeNode root, List<Integer> result) {
        // Check if the tree is empty
        if (root == null) {
            // The tree is empty, return without further action
            return;
        }
        // Initialize a stack for in-order traversal
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root; // Temporarily store the root
        // In-Order Traversal using a while loop
        while (current != null || !stack.isEmpty()) {
            // Nested while loop to traverse the left subtree until the current node is null
            while (current != null) {
                stack.push(current); // Push the current node onto the stack
                current = current.left; // Move to the left child
            }
            // When the left subtree is fully traversed, pop nodes from the stack
            current = stack.pop();
            result.add(current.value); // Add the value to the result list
            // Explore the right subtree
            current = current.right;
        }
    }
    
    //Task 2: Iterative function to perform pre-order traversal
    public  void preOrderTraversal(BinaryTreeNode root,List<Integer> result) {
         // Check if the tree is empty
        if (root == null) {
            // The tree is empty, return without further action
            return;
        }
        // Initialize two stacks for post-order traversal
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        // Commence the traversal with the root node
        stack.push(root);

        //  Post-Order Waltz using a while loop
        while (!stack.isEmpty()) {
            // Pop a node from the primary stack
            BinaryTreeNode current = stack.pop();
            // Push the node's value onto the resultStack
            resultStack.push(current.value);

            // Push the left child onto the primary stack if not null
            if (current.left != null) {
                stack.push(current.left);
            }
            // Push the right child onto the primary stack if not null
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        //Second while loop to extract values from the resultStack
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }
    }

    //Task 3: Iterative function to perform post-order traversal
    public  void postOrderTraversal(BinaryTreeNode root,List<Integer> result) {
         // Step 1: Check if the tree is empty
        if (root == null) {
            // The tree is empty, return without further action
            return;
        }

        // Step 2: Initialize two stacks for post-order traversal
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        // Step 3: Commence the traversal with the root node
        stack.push(root);

        // Step 4: Post-Order Waltz using a while loop
        while (!stack.isEmpty()) {
            // Pop a node from the primary stack
            BinaryTreeNode current = stack.pop();

            // Push the node's value onto the resultStack
            resultStack.push(current.value);

            // Push the left child onto the primary stack if not null
            if (current.left != null) {
                stack.push(current.left);
            }

            // Push the right child onto the primary stack if not null
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // Step 5: Second while loop to extract values from the resultStack
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }
    }

    //Task 4: Function to delete a value from the binary tree
    public BinaryTreeNode delete(BinaryTreeNode root, int value) {
        // Step 1: Check if the tree is empty
        if (root == null) {
            System.out.println("Node with value " + value + " not found for deletion in the binary tree.");
            return null;
        }

        // Step 2: Initialize a queue for level-order traversal
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root); // Add the root to the queue

        // Step 3: Declare the variable for the node to delete
        BinaryTreeNode nodeToDelete = null;

        // Step 4: Level-Order Traversal using a while loop
        while (!queue.isEmpty()) {
            // Dequeue a node from the queue
            BinaryTreeNode current = queue.poll();

            // Check for the target value
            if (current.value == value) {
                nodeToDelete = current;
                break;
            }

            // Enqueue left and right children for further exploration
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        // Step 5: Check if the node to delete is found
        if (nodeToDelete == null) {
            System.out.println("Node with value " + value + " not found for deletion in the binary tree.");
            return root;
        }

        // Step 6: Find the deepest node and its value
        BinaryTreeNode deepestNode = getDeepestNode(root);
        int deepestNodeValue = deepestNode.value;

        // Step 7: Delete the deepest node
        root = deleteDeepest(root, deepestNode);

        // Step 8: Replace the node to delete with the deepest node
        nodeToDelete.value = deepestNodeValue;

        System.out.println("Node with value " + value + " successfully deleted from the binary tree.");

        // Step 9: Return the modified root
        return root;
    }
            return null;

    // Task 4: Helper function to get the deepest node in the binary tree
        private  BinaryTreeNode getDeepestNode(BinaryTreeNode root) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode deepestNode = null;

        while (!queue.isEmpty()) {
            deepestNode = queue.poll();
            if (deepestNode.left != null) {
                queue.add(deepestNode.left);
            }
            if (deepestNode.right != null) {
                queue.add(deepestNode.right);
            }
        }
        return deepestNode;
        }

        //Task 4: Helper function to delete the deepest node in the binary tree
        private  BinaryTreeNode deleteDeepest(BinaryTreeNode root, BinaryTreeNode deepestNode) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();

            if (current.right != null) {
                if (current.right == deepestNode) {
                    current.right = null;
                    break;
                } else {
                    queue.add(current.right);
                }
            }
            if (current.left != null) {
                if (current.left == deepestNode) {
                    current.left = null;
                    break;
                } else {
                    queue.add(current.left);
                }
            }
        }
        return root;
        }

    // Task 5: Function to search for a value in the binary tree
    public  boolean search(BinaryTreeNode root, int value) {
        // Step 1: Check if the tree is empty
        if (root == null) {
            // The tree is empty, return false
            return false;
        }

        // Step 2: Initialize a queue for level-order traversal
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root); // Add the root to the queue

        // Step 3: Level-Order Traversal using a while loop
        while (!queue.isEmpty()) {
            // Dequeue a node from the queue
            BinaryTreeNode current = queue.poll();

            // Check for the target value
            if (current.value == value) {
                // The value is found, return true
                return true;
            }

            // Enqueue left and right children for further exploration
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        // Step 4: If the loop completes without finding the target value, return false
        return false;
    }

    //Task 6: Function to calculate the height of the binary tree
    public  int calculateHeight(BinaryTreeNode root) {
        // Step 1: Check if the tree is empty
        if (root == null) {
            // The tree is empty, return 0
            return 0;
        }

        // Step 2: Initialize a queue for level-order traversal
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root); // Add the root to the queue

        // Step 3: Initialize the height variable
        int height = 0;

        // Step 4: Level-Order Traversal using a while loop
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int levelSize = queue.size();
            // Inner loop for processing nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                // Dequeue a node from the queue
                BinaryTreeNode current = queue.poll();
                // Enqueue left child if it exists
                if (current.left != null) {
                    queue.offer(current.left);
                }
                // Enqueue right child if it exists
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // Increment the height after processing all nodes at the current level
            height++;
        }
        // Return the calculated height of the binary tree
        return height;
    }
    // Main method
    public static void main(String[] args) {
    	System.out.println("Binary Tree Project");
    }