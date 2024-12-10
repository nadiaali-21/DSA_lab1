package avltree;

class AVLTreeNode {
    int key;
    AVLTreeNode left, right;
    int height;

    public AVLTreeNode(int key) {
        this.key = key;
        this.left = this.right = null;
        this.height = 1;
    }
}

public class AVLTree {
    private AVLTreeNode root;

    private int height(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int balanceFactor(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private AVLTreeNode leftRightRotate(AVLTreeNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLTreeNode rightLeftRotate(AVLTreeNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public AVLTreeNode insert(AVLTreeNode node, int key) {
        if (node == null) {
            return new AVLTreeNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node;
    }

    public AVLTreeNode delete(AVLTreeNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                AVLTreeNode temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                AVLTreeNode temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);

        if (balance > 1 && balanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance < -1 && balanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance > 1 && balanceFactor(node.left) < 0) {
            return leftRightRotate(node);
        }

        if (balance < -1 && balanceFactor(node.right) > 0) {
            return rightLeftRotate(node);
        }

        return node;
    }

    private AVLTreeNode minValueNode(AVLTreeNode node) {
        AVLTreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean search(AVLTreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    public void inorder(AVLTreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(20);
        tree.insert(30);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        System.out.println("In-order traversal of the AVL tree:");
        tree.inorder(tree.root);

        System.out.println("\n\nSearch for key 15 in the AVL tree:");
        System.out.println(tree.search(15));

        System.out.println("\nDelete key 20 from the AVL tree:");
        tree.delete(20);

        System.out.println("In-order traversal after deletion:");
        tree.inorder(tree.root);
    }
}
