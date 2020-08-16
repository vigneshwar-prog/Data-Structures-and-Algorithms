import java.util.*;

class AVL{

    class Node{
        int data;
        Node left,right;
        int height;
        Node(int data)
        {
            this.data = data;
            left = right = null;
            height = 1;

        }
    }
    Node root;
    AVL(){
        root = null;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        AVL tree = new AVL();
        for(int i=0;i<N;i++)
        {
            int k = sc.nextInt();
            tree.insert(tree,k);
        }
        tree.inOrder(tree.root);
    }
    void insert(AVL tree,int data)
    {
        tree.root = insertNode(tree.root,data);
    }
    int getHeight(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return root.height;
    }
    Node insertNode(Node root,int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        else {
            if(root.data > data)
            {
                root.left = insertNode(root.left, data);
            }
            else{
                root.right = insertNode(root.right,data);
            }
        }
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));

        int balance = getBalance(root);
        if(balance > 1 && data < root.left.data){
            root = RR(root);//Right Rotation
        }
        else if(balance > 1 && data > root.left.data){
            root.left = LL(root); //Left rotation
            root = RR(root); // Right rotation
        }
        else if(balance < 1 && data > root.right.data)
        {
            root = LL(root); //Left rotation
        }
        else if(balance < -1 && data < root.right.data){
            root.right = RR(root.right); // Right Rotation
            root = LL(root); // Left Rotation
        }
        return root;
    }
    int getBalance(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        else{
            return getBalance(root.left) - getBalance(root.right);
        }
    }
    Node LL(Node root){
        Node temp = root.right;
        temp.left = root;
        root = temp;
        if(root.left!=null)
        root.left.height = 1+Math.max(getHeight(root.left.left),getHeight(root.left.right));
        if(root.right!=null)
        root.right.height = 1+Math.max(getHeight(root.right.left),getHeight(root.right.right));

        root.height = 1+Math.max(getHeight(root.left),getHeight(root.right));
        return root;

    }
    Node RR(Node root)
    {
        Node temp = root.left;
        temp.right = root;
        root = temp;
        if(root.left!=null)
        root.left.height = 1+Math.max(getHeight(root.left.left),getHeight(root.left.right));
        if(root.right!=null)
        root.right.height = 1+Math.max(getHeight(root.right.left),getHeight(root.right.right));
        root.height = 1+Math.max(getHeight(root.left),getHeight(root.right));
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

}