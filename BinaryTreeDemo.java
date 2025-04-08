import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {
    
    static class Node{
            int data ;
            Node left;
           Node right;

            Node(int data){

                this.data =data;
                this.right=null;
                this.left =null;
            }
    }


    static class BinaryTree{                  // NOTE : for binary tree first complete left child of tree left side then right.
        static int idx = -1;
        public static Node buildNode(int nodes[]){

            idx++;
               if(nodes[idx] == -1){    
                return null;
            }

                Node newNode = new Node(nodes[idx]); /* {  data = 4    
                                                           left =null
                                                           right =null  }   

                                                            Process:
                                                            a. Increment idx to move to next array element
                                                            b. If current element is -1, return null (base case)
                                                            c. Otherwise, create a new Node with the current data
                                                            d. Recursively build left subtree (assign to newNode.left)
                                                            e. Recursively build right subtree (assign to newNode.right)
                                                            f. Return the constructed node*/

            newNode.left = buildNode(nodes); // for left call buildNode(array of nodes), recursive action happen , if (nodes(idx) == null then call next line)

            newNode.right = buildNode(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root){ // in preOrder Traversal first root will come then left subtree and then right

        if(root == null ){
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
       preOrder(root.right);
    }

    public static void inOrder(Node root){  // In InOrder Traversal first left subtree will print then root , then right subtree
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void PostOrder(Node root){  // In postOrder traversal first left subtree will print, then right , then root;
        if (root == null ){
            return ;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

//Level Order Traversal

   public static void levelOrder(Node root){

    if(root == null){
        return;
    }
    Queue <Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
        Node currNode = q.remove();

        if(currNode==null){
            System.out.println();
            if(q.isEmpty()){
                break;
            }else{
                q.add(null);
            }
        }else{
            System.out.print(currNode.data + " ");
            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
            }
        }
    }

   }

// Count of nodes

public static int countOfNodes(Node root){

    if(root == null){
        return 0;
    }
    int leftNode = countOfNodes(root.left);
    int rightNode = countOfNodes(root.right);

    return leftNode + rightNode +1;
}

// Sum of Nodes

public static int sumOfNodes(Node root){
    if(root == null ){
        return 0;
    }
    int leftSum = sumOfNodes(root.left);
    int rightSum = sumOfNodes(root.right);
    return leftSum + rightSum + root.data;
}

// Height of Nodes
public static int hightOfTree(Node root){

    if(root == null){
        return 0;
    }
    int leftHight = hightOfTree(root.left);
    int rightHight = hightOfTree(root.right);

    return Math.max(leftHight, rightHight) +1;

}


// Diameter Of tree, Tc =  O(n^2)

public static int diameter( Node root){
    
    int dia1 = diameter(root.left);
    int dia2 = diameter(root.right);
    int dia3 = hightOfTree(root.left) + hightOfTree(root.right)+1;

    return Math.max(dia3, Math.max(dia1, dia2));
}


// Diameter Of tree, Tc =  O(n) 

static class TreeInfo{
    int ht;
    int diam;

    TreeInfo(int ht , int diam){
        this.ht = ht;
        this.diam= diam;
    }
}


public static TreeInfo diameterObtimized(Node root){

    if (root == null ){

        return new TreeInfo(0, 0);

    }

    TreeInfo left = diameterObtimized(root.left);
    TreeInfo right = diameterObtimized(root.right);


    int myHight = Math.max(left.ht, right.ht);

    int diam1=left.diam;
    int diam2 = right.diam;
    int diam3 = left.ht = right.ht +1;
    int diameter = Math.max(Math.max(diam1, diam2),diam3);

    TreeInfo info = new TreeInfo(myHight, diameter);

    return info;

}


    public static void main(String[] args) {
        int Node[] = {1,2,4,-1,-1,5,-1,-1 ,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildNode(Node);
      //  System.out.println(root.data);
      //  PostOrder(root);
      // levelOrder(root);
      //System.out.println(countOfNodes(root));
      //  System.out.println(sumOfNodes(root));
      //System.out.println(hightOfTree(root));
      System.out.println(diameterObtimized(root).diam);
    }
}
