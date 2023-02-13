import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Node{
    char v;
    Node left, right;

    Node(char val){
        this.v = val;
    }
}

class Tree{
    Node root;

    public void createNode(char val, char left, char right){
        if(root==null){
            root = new Node(val);
            root.left = left != '.' ? new Node(left) : null;
            root.right = right != '.' ? new Node(right) : null;
        }
        else
            searchNode(root, val, left, right);
    }

    public void searchNode(Node node, char val, char left, char right){
        if(node==null)
            return;

        if(node.v == val){
            node.left = left != '.' ? new Node(left) : null;
            node.right = right != '.' ? new Node(right) : null;
        }
        else{
            searchNode(node.left, val, left, right);
            searchNode(node.right, val, left, right);
        }
    }

    public void preOrder(Node node){
        if(node!=null){
            System.out.print(node.v);
            if(node.left!=null) preOrder(node.left);
            if(node.right!=null) preOrder(node.right);
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            if(node.left!=null) inOrder(node.left);
            System.out.print(node.v);
            if(node.right!=null) inOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node!=null){
            if(node.left!=null) postOrder(node.left);
            if(node.right!=null) postOrder(node.right);
            System.out.print(node.v);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.createNode(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}
