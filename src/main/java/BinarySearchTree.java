import java.util.Stack;
import java.util.concurrent.Semaphore;

/**
 * Implementation of binary search tree
 *
 * @param <K> can be any object extends Comparable
 */
public class BinarySearchTree<K extends Comparable> {

    /**
     * An object of type TreeNode represents one node in a binary tree
     */
    class Node {
        K key;
        Node left, right;
        Semaphore mutex = new Semaphore(1); //only one thread can use at a time, permit is set to 1

        public Node(K item) {
            key = item;
            left = right = null;
        }
    }

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    /**
     * @param key to be added to binary search tree
     * @throws InterruptedException
     */
    public void insert(K key) throws InterruptedException {
        root = insertNodeIterative(root, key);
    }

    /**
     * A iterative function to insert a new key in BST
     *
     * @param root root of the binary tree
     * @param key  node to be added to binary tree
     * @return root of the binary search tree
     * @throws InterruptedException
     */
    private Node insertNodeIterative(Node root, K key) throws InterruptedException {

        if (root == null) {
            root = new Node(key);
            return root; // if BST is empty, creating a node with the key and making it as root
        }

        Node tmpNode = root;
        Node parent = null;

        while (tmpNode != null) {
            parent = tmpNode;
            if (key.compareTo(tmpNode.key) < 0) {
                tmpNode = tmpNode.left;
            } else if (key.compareTo(tmpNode.key) >= 0) {
                tmpNode = tmpNode.right;
            }
        }

        Node node = new Node(key);

        parent.mutex.acquire();

        if (parent.key.compareTo(node.key) > 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        parent.mutex.release();

        return root;
    }

    /**
     * calculates the number of nodes using stack data structure
     *
     * @return number of nodes of the binary search tree
     * @throws InterruptedException
     */
    public int size() throws InterruptedException {
        if (root == null) {
            return 0;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        int count = 0;
        Node node = null;

        while (!stack.isEmpty()) {
            try {
                node = (Node) stack.pop();
                node.mutex.acquire(); // locking the node
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (node != null) {
                    node.mutex.release(); // must be released in case of any exception
                }
            }
        }

        return count;
    }

    /**
     * writes the nodes of the binary tree by using inorder traversal
     */
    void inorder() {
        inorderRec(root);
    }

    /**
     * A utility function to do inorder traversal of binary search tree
     *
     * @param root
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key);
            System.out.print(" ");
            inorderRec(root.right);
        }
    }
}