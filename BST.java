class Node { 
  int data; 
  Node left, right; 

  public Node(int data) 
  { 
      this.data = data; 
      left = right = null; 
  }
  
  public int getData(){
    return data;
  }
} 
  
  public class BST<E extends Comparable<E>> {
    protected Node root;
    protected int size = 0;
  
    // Insert element e into the binary tree
    // Return true if the element is inserted successfully
    public boolean insert(int value) {
      if (root == null)
        root = new Node(value); // Create a new root
      else {
        // Locate the parent node
        Node parent = null;
        Node current = root;
        while (current != null) {
          if (value < current.data) {
            parent = current;
            current = current.left;
          }
          else if (value > current.data) {
            parent = current;
            current = current.right;
          }
          else
            return false; // Duplicate node not inserted
        }
        // Create the new node and attach it to the parent node
        if (value < parent.data)
          parent.left = new Node(value);
        else
          parent.right = new Node(value);
      }
  
      size++;
      return true; // Element inserted successfully
    }
  
    // Inorder traversal from the root
    public void inorder() {
      inorder(root);
    }
  
    // Inorder traversal from a subtree */
    protected void inorder(Node root) {
      if (root == null)
        return;
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }

    public Node maxElement() {
      return maxElement(root);
    }

    public Node secondLargestElement() {
      return secondLargest(root);
    }

    // find the highest element in the tree
    private Node maxElement(Node root) {
      if (root == null) {
        return null;
      }
      if (root.right == null) { // found max element
        return root;
      }
      return maxElement(root.right);
    } 

    private Node secondLargest(Node node) {

      Node prevNode=null; //2nd largest Element
      Node currNode=node;
      if(null == currNode)
          return prevNode;

      while(currNode.right != null){
          prevNode=currNode;
          currNode=currNode.right;
      }
      if(currNode.left != null){
          currNode=currNode.left;
          while(currNode.right != null){
              currNode=currNode.right;
          }
          prevNode=currNode;
      }

      return prevNode;

  }
  }