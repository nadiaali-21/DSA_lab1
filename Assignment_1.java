package assignment_1;

public class Assignment_1 {   
    class Node {
        int key;
        Node left, right;

        Node(int value) {
            key = value;
            left = right = null;
        }
    }   
    private Node root;
    
    public Assignment_1() {
        root = null;
    }
    public Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
    public Node delNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = delNode(root.left, key);
        } else if (root.key < key) {
            root.right = delNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node successor = getSuccessor(root);
            root.key = successor.key;
            root.right = delNode(root.right, successor.key);
        }
        return root;
    }
    public Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Assignment_1 tree = new Assignment_1();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Inorder traversal before deletion:");
        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.delNode(tree.root, 20);
        System.out.println("\nInorder traversal after deletion of 20:");
        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.delNode(tree.root, 30);
        System.out.println("\nInorder traversal after deletion of 30:");
        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.delNode(tree.root, 50);
        System.out.println("\nInorder traversal after deletion of 50:");
        tree.inorder(tree.root);
        System.out.println();
    }
}
