import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeImplementation {
    public static Scanner sc;

    public static Node createTree(Node root) {
        System.out.println("Enter the node value");
        int data = sc.nextInt();
        root = new Node(data);

        if (data == -1) {
            return null;
        }

        // insert data in left
        System.out.println("Enter the left node value for " + data);
        root.left = createTree(root.left);
        // insert data in right
        System.out.println("Enter the right node value for " + data);
        root.right = createTree(root.right);
        return root;
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }

    public static Node buildTreeUsingLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        System.out.println("Enter root data: ");
        int data = sc.nextInt();
        if (data != -1) {
            root = new Node(data);
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                System.out.println("Enter left node data of " + temp.val);
                data = sc.nextInt();
                if (data != -1) {
                    temp.left = new Node(data);
                    queue.add(temp.left);
                }

                System.out.println("Enter right node data of " + temp.val);
                data = sc.nextInt();
                if (data != -1) {
                    temp.right = new Node(data);
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = null;

        // create the tree
        // root = createTree(root);

        // create tree using level order traversal
        root = buildTreeUsingLevelOrder(root);

        // level order traversal
        System.out.println("Level Order Traversal: ");
        levelOrderTraversal(root);

        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);

        System.out.println("PreOrder Traversal: ");
        preorderTraversal(root);

        System.out.println("PostOrder Traversal: ");
        postorderTraversal(root);
    }
}