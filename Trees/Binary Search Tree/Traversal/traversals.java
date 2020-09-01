import java.util.*;

class traversals{

    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            left = right = null;
        }
    }
    Node root;
    traversals(){
        root = null;
    }
    void insert(traversals tree,int data)
    {
        tree.root = insertNode(tree.root,data);
    }
    Node insertNode(Node root,int data){
        if(root == null)
        {
            root = new Node(data);
        }
        else{
            if(root.data >= data)
            {
                root.left = insertNode(root.left, data);
            }
            else{
                root.right = insertNode(root.right, data);
            }
        }
        return root;
    }
    void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    void preOrder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    void postOrder(Node root)
    {
        if(root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        traversals tree = new traversals();
        int N = sc.nextInt();
        for(int i=0;i<N;i++)
        {
            int k = sc.nextInt();
            tree.insert(tree,k);
        }
        System.out.println("-----Inorder Traversal---------");
        tree.inOrder(tree.root);
        System.out.println("");
        System.out.println("-----Preorder Traversal---------");
        tree.preOrder(tree.root);
        System.out.println("");
        System.out.println("-----Preorder Traversal---------");
        tree.postOrder(tree.root);


    }
}