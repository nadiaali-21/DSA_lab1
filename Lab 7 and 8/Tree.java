package tree;
import java.util.*;

public class Tree {    
    class Node {
        int data;
        Node left, right;        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNode(root.left);
        int rightNodes = countNode(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int SumofNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = SumofNode(root.left);
        int rightSum = SumofNode(root.right);
        return leftSum + rightSum + root.data;
    }

    public void insert(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.left = tree.new Node(6);
        root.right.right = tree.new Node(7);

        System.out.println("In-Order Traversal:");
        tree.inOrder(root);
        System.out.println();
        
        System.out.println("\nPre-Order Traversal:");
        tree.preOrder(root);
        System.out.println();
        
        System.out.println("\nPost-Order Traversal:");
        tree.postOrder(root);
        System.out.println();
        
        System.out.println("\nLevel-Order Traversal:");
        tree.levelOrder(root);
        System.out.println();
        
        System.out.println("Count of Nodes: ");
        System.out.println(countNode(root));
        
        System.out.println("Sum of Nodes: ");
        System.out.println(SumofNode(root));
        
        System.out.println("\nInserting nodes:");
        tree.insert(root, 8);
        tree.insert(root, 9);
        tree.insert(root, 10);
        tree.insert(root, 11);
        
        System.out.println("\nIn-Order Traversal after Insertion:");
        tree.inOrder(root);
        System.out.println();
        
        System.out.println("\nLevel-Order Traversal after Insertion:");
        tree.levelOrder(root);
    }
}
