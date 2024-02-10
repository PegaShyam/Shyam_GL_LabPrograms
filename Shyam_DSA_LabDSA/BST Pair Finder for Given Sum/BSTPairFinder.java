import java.util.LinkedHashSet;
import java.util.Set;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
}

public class BSTPairFinder {
    BinarySearchTree bst;
    Integer sum;
    Set<Integer> previouslyVisitedNodes;

    public BSTPairFinder(BinarySearchTree bst, Integer sum) {
        this.bst = bst;
        this.sum = sum;
        this.previouslyVisitedNodes = new LinkedHashSet<>();
    }

    public void findPairs() {
        preOrderTraversal();
        if (previouslyVisitedNodes.isEmpty()) {
            System.out.println("No pairs found with sum " + sum);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversalInternal(bst.getRoot());
    }

    public void preOrderTraversalInternal(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        Integer difference = (sum - currentNode.data);
        if (previouslyVisitedNodes.contains(difference)) {
            System.out.println("Match Identified");
            System.out.printf("[%d, %d]%n", currentNode.data, difference);
        }

        this.previouslyVisitedNodes.add(currentNode.data);

        preOrderTraversalInternal(currentNode.left);
        preOrderTraversalInternal(currentNode.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(30);
        bst.insert(50);
        bst.insert(70);
        
        int targetSum = 130;
        System.out.println("Sum = 130");
        BSTPairFinder pairFinder = new BSTPairFinder(bst, targetSum);
        pairFinder.findPairs();
    }
}
