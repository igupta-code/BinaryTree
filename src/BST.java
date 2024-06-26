import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Isha Gupta
 * @version: April 5th, 2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return search(val, root);
    }
    public boolean search(int val, BSTNode n){
        // It's not in the tree if n is null bc we've checked all nodes
        if(n == null){
            return false;
        }
        // If we've found val, return true
        if(val == n.getVal()){
            return true;
        }
        // Recurse to the right and left
        return search(val, n.getLeft()) || search(val, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        return getInorder(nodes, root);
    }
    public ArrayList<BSTNode> getInorder(ArrayList<BSTNode> nodes, BSTNode n){
        // Base case: when n is null, code has traversed through entire array
        if(n == null)
            return nodes;
        // Order = left, root, right
        getInorder(nodes, n.getLeft());
        nodes.add(n);
        getInorder(nodes, n.getRight());
        return nodes;
    }


    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        return getPreorder(nodes, root);
    }
    public ArrayList<BSTNode> getPreorder(ArrayList<BSTNode> nodes, BSTNode n){
        // Base case: when n is null, code has traversed through entire array
        if(n == null)
            return nodes;
        // order: root, left, right
        nodes.add(n);
        getPreorder(nodes, n.getLeft());
        getPreorder(nodes, n.getRight());
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        return getPostorder(nodes, root);
    }
    public ArrayList<BSTNode> getPostorder(ArrayList<BSTNode> nodes, BSTNode n){
        // Base case: when n is null, code has traversed through entire array
        if(n == null)
            return nodes;
        // order: left, right, root
        getPostorder(nodes, n.getLeft());
        getPostorder(nodes, n.getRight());
        nodes.add(n);
        return nodes;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insert(val, root);
    }
    public void insert(int val, BSTNode node){
        // Checks if val is already in the tree -- doesn't do anything
        if(node.getVal() == val){
            return;
        }
        // If either child is empty, check if value fits there(ie if it's smaller than node it goes to the left)
        else if(node.getLeft() == null && val < node.getVal()){
            node.setLeft(new BSTNode(val));
            return;
        }
        else if(node.getRight() == null && val > node.getVal()){
            node.setRight(new BSTNode(val));
            return;
        }
        // Recurse to left or right depending on if val is greater or less than the node
        if(val < node.getVal())
            insert(val, node.getLeft());
        if(val > node.getVal())
            insert(val, node.getRight());
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
