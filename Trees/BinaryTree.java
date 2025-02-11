public class BinaryTree{

    private class Node{
        
        private Integer value;
        private Node left, right;
        
        private Node(Integer value){
            this.value = value;
            this.left = this.right = null;
        }

        private void add(Integer value){
            if(this.value == value) return;
            if(this.value > value)
                if(this.left != null) this.left.add(value);
                else this.left = new Node(value);
            else
                if(this.right != null) this.right.add(value);
                else this.right = new Node(value);
        }

        private Boolean lookup(Integer key){
            if(this.value == key) return true;
            if(this.value > key)
                if(this.left != null) return this.left.lookup(key);
                else return false;
            else
                if(this.right != null) return this.right.lookup(key);
                else return false;
        }

        private void printTree(){
            if(this != null){
                if(this.left != null) this.left.printTree();
                System.out.print(this.value + " ");
                if(this.right != null) this.right.printTree();
            }
        }
    }
    
    private Node root;

    public BinaryTree(){root = null;}

    public void add(Integer value){
        if(root == null) root = new Node(value);
        else root.add(value);
    }

    public void addon(Integer value){
        Node leaf = new Node(value);
        if(root == null){ 
            root = leaf;
            return;
        }
        Node cur = root;
        Node pre = null;
        while(cur != null){
            pre = cur;
            if(cur.value > value) cur = cur.left;
            else if(cur.value < value) cur = cur.right;
            else return;
        }
        if(pre.value > value) pre.left = leaf;
        else pre.right = leaf;
    }

    public Boolean lookup(Integer key){
        if(root.value == key) return true;
        else return root.lookup(key);
    }

    /* *
    public void remove(Integer key){
        Node cur = root;
        Node pre = null;
        while(cur != null){
            pre = cur;
            if(cur.value > key) cur = cur.left;
            else if(cur.value < key) cur = cur.right;
            else break;
        }
        if(pre.right.value == key) pre.right = null;
        else pre.left = null;
    }
    //*/

    public void printTree(){
        if(root != null){
            if(root.left != null) root.left.printTree();
            System.out.print(root.value + " ");
            if(root.right != null) root.right.printTree();
        }
    }
}
