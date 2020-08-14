import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
class BST{
    class Node{
        int data;
        Node left;
        Node right;
        
        Node(int d)
        {
        this.data = d;
        left = right = null;
        }
    }
    Node root;
    BST(){
        root = null;
    }
    void insert(BST tree,int data)
    {
        tree.root = insertNode(root,data);
    }
    Node insertNode(Node root,int data)
    {
        if(root == null){
            root = new Node(data);
        }
        else {
            if(root.data >= data){
                root.left = insertNode(root.left, data);
            }
            else{
                root.right = insertNode(root.right,data);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        BST obj = new BST();
        for(int i= 0;i<N;i++)
        {
            int k = sc.nextInt();
            obj.insert(obj,k);
        }
        boolean flag = true;
        while(flag){
            System.out.print(" Enter\n 1.Delete\n2.search 3.exit");
            int choice  = sc.nextInt();
            switch(choice){
                case 1:
                    int delitem = sc.nextInt();
                    if(obj.search(obj.root,delitem)){
                        obj.delete(obj,delitem);
                        System.out.print("Deleted Successfully");
                    }
                    else{
                        System.out.print("element not found");
                    }
                    break;
                case 2:
                    int item = sc.nextInt();
                    if(obj.search(obj.root,item)){
                        System.out.print("Found");
                    }
                    else{
                        System.out.print("Not Found");
                    }
                    break;
                default:
                    flag = false;
            }
        }
        obj.inorder(obj.root);
        sc.close();

    }

    private void delete(BST tree,int delitem) {
        tree.root = deleteNode(tree.root,delitem);
    }
    Node deleteNode(Node root,int data){
        if(root != null){
            if(root.data == data){
                if(root.left != null)
                {
                    root = root.left;
                }
                else if(root.right != null)
                {
                    root = root.right;
                }
            }
            else{
                root.left = deleteNode(root.left, data);
                root.right = deleteNode(root.right,data);
            }
        }
        return root;
    }

    private boolean search(Node root, int item) {
        if(root != null){
            if(root.data == item){
                return true;
            }
            if(search(root.left,item) || search(root.right,item)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;

    }

    void inorder(Node root) {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
}