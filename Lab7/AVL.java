public class AVL{
	public class Node{
		Integer key;
		Node left,right;
		int height;
		public Node(Integer key){
			this.key = key;
			this.height = 0;
			this.left = this.right = null;
		}
		public Node(){
			this.key = 0;
			this.height = 0;
			this.left = this.right = null;
		}
	}
	public int height(Node node){
		if (node == null)
			return -1;
		return node.height;
	}
	public int height(){
		Node t = new Node();
		t = root;
		return height(t);
	}
	
private void updateHeight(Node x){
	x.height=1+Math.max(height(x.right),height(x.left));
}
	
	public static Node root;
	public AVL(){
		root=null;
	}
	
	private int checkBalance(Node x) {
		return height(x.left) - height(x.right);
	}
	
	private Node rotateLeft(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}
	public Node rotateLeft(){
		return rotateLeft(root);
	}
	
	private Node rotateRight(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}
	public Node rotateRight(){
		return rotateRight(root);
	}
	
	private Node balance(Node x) {
		if (checkBalance(x) < -1) {
			if (checkBalance(x.right) > 0) {
				x.right = rotateRight(x.right);
			}
			x = rotateLeft(x);
		}
		else if (checkBalance(x) > 1) {
			if (checkBalance(x.left) < 0) {
				x.left = rotateLeft(x.left);
			}
			x = rotateRight(x);
		}
		return x;
	}
	public Node balance(){
		return balance(root);
	}

	private Node insert(Node x, Integer key){
		if(x == null){
			return new Node(key);
		}
		int tmp = key.compareTo(x.key);
		if(tmp < 0){
			x.left = insert(x.left, key);
			updateHeight(x);
		}
		else if(tmp > 0){
			x.right = insert(x.right, key);
			updateHeight(x);
		}
		else{
			key = x.key;
		}
		return balance(x);
	}	
	public void insert(Integer key){
		root = insert(root,key);
	}
	
	private void NLR(Node x){
		if(x != null){
			System.out.print(x.key+" ");
			NLR(x.left);
			NLR(x.right);
		}
	}
	public void NLR(){
		NLR(root);
	}
	
	private void LNR(Node x){
		if(x != null){
			LNR(x.left);
			System.out.print(x.key+" ");
			LNR(x.right);
		}
	}	
	public void LNR(){
		LNR(root);
	}
	
	private void LRN(Node x){
		if(x != null){
			LRN(x.left);
			LRN(x.right);
			System.out.print(x.key+" ");
		}
	}	
	public void LRN(){
		LRN(root);
	}
	
	private Node search(Node x, Integer key){
		if(x == null){
			return null;
		}
		int tmp = key.compareTo(x.key);
		if(tmp < 0){
			return search(x.left, key);
		}
		else if(tmp > 0){
			return search(x.right, key);
		
	    }
		return x;
	
	}
	public boolean search(Integer key){
		Node t = new Node();
		t = search(root, key);
		if(t == null) 
			return false;
		return true;
	}
	
	private Node min(Node x){
		if(x.left == null){
			return x;
		}
		return min(x.left);
	}
	public int min(){
		Node t = new Node();
		t = min(root);
		return t.key;
	}
	
	private Node max(Node x){
		if(x.right == null){
			return x;
		}
		return max(x.right);
	}
	public int max(){
		Node t = new Node();
		t = max(root);
		return t.key;
	}
	
	private Node deleteMin(Node x){
		if(x.left == null){
			return x.right;
		}
		x.left = deleteMin(x.left);
		return balance(x);
	}
	public void deleteMin(){
		deleteMin(root);
	}
	
	private Node deleteMax(Node x){
		if(x.right == null){
			return x.left;
		}
		x.right = deleteMax(x.right);
		return balance(x);
	}
	public void deleteMax(){
		deleteMax(root);
	}
	
	private Node delete(Node x, Integer key){
		if(x == null){
			return null;
		}
		int tmp = key.compareTo(x.key);
		if(tmp < 0){
			x.left = delete(x.left, key);
		}
		else if(tmp > 0){
			x.right = delete(x.right, key);
		}
		else{
			if(x.left == null){
				return x.right;
			}
			if(x.right == null){
				return x.left;
			}
			x.key = min(x.right).key;
			x.right = deleteMin(x.right);
		}
		return balance(x);
	}
	public void delete(Integer key){
		root = delete(root,key);	
	}
	
	private void createTree(String strKey){
		root = null;
		String[] str = strKey.split(" ");
		for(int i = 0; i < str.length; i++){
			insert(Integer.parseInt(str[i]));
		}
	}
	
	public Integer sum(Node x){
		if(x == null)
		{
			return 0;
		}
		return x.key + sum(x.left) + sum(x.right);
	}
	public Integer sum(){
		Node t = new Node();
		t = root;
		return sum(t);
	}
	
	public static void main(String[] args)	{
		AVL avl = new AVL();
		System.out.println("Create Tree");
		String CreateInput = "2 45 6 24 78 12 1 9 16 37";
		avl.createTree(CreateInput);
		avl.LRN();
		System.out.println();
		
		/* System.out.println("Delete");
		avl.delete(45);
		avl.LRN();
		 */
	}
}