package SortAlgorithm;
public class BST{
    private Node root;

    BST(){
        root=null;
    }

    public Node getRoot(){
        return root;
    }

    public void insert(int key)
    {
        root = insertRec(root, key);
    }

    public Node insertRec(Node node, int key){
        if(node==null){
            node=new Node(key);
            return node;
        }
        if(key<node.key){
            node.left=insertRec(node.left,key);
        }else {
            node.right=insertRec(node.right,key);
        }
        return node;
    }

    public void buildByArray(int []arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            insert(arr[i]);
        }
    }

    public void printSortResult(Node root){
        if(root!=null){
            printSortResult(root.left);
            System.out.print(root.key+",");
            printSortResult(root.right);
        }
    }


}