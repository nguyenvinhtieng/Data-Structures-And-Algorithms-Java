import java.util.*;
public class BST {
    public Node root;
	
   private Node insert(Node x, int key) {
		if (x == null)
			return new Node(key);
		
		int cmp = key - (x.key);
		if (cmp < 0)
			x.left = insert(x.left, key);
		else if (cmp > 0)
			x.right = insert(x.right , key);
		else
			x.key = key;
		
		return x;
	}
	
	public void insert(int key){
		root = insert(root,key);
	}
	
	
	
	
	
    private void createTree(String strkey){
        String[] strArr = strkey.split(" ");
        for(int i = 0;i < strArr.length ;i++){
			//int k = Interger.parseInt(strArr[i]);
            insert(Integer.parseInt(strArr[i]));
        }
    }
	private int compareTo(int x, int y){
		return x - y;
	}
	
	private Node search(Node x, Integer key) { 
		if (x == null) 
			return null; 
		int cmp = compareTo(key,x.key); 
		if (cmp < 0) 
			return search(x.left, key); 
		else if (cmp > 0) 
			return search(x.right, key); 
		else 
			return x; 
	}
	public boolean search(Integer key){
		Node t = new Node();
		t = search(root,key);
		if(t == null)
			return false;
		return true;
	}
	public void NLR(Node x) { 
		if (x != null) { 
			System.out.print(x.key + " "); 
			NLR(x.left); 
			NLR(x.right);
		}
	}
	public void NLR() { 
		NLR(root);
	}
	
	public void LNR(Node x) { 
	  if (x != null) { 
			LNR(x.left);
			System.out.print(x.key + " "); 
			LNR(x.right);
		}
	}
	
	public void LNR() { 
		LNR(root);
	}
	
	public void LRN(Node x) {
		if (x != null) { 
			LRN(x.left);
			LRN(x.right);
			System.out.print(x.key + " "); 
		}
	}
	public void LRN() { 
		LRN(root);
	}
	private Node min(Node x) { 
		if (x.left == null) 
			return x; 
		else 
		return min(x.left); 
	} 
	public Integer min(){
		return min(root).key;
	}
	 private Node max(Node x) { 
		if (x.right == null) 
			return x; 
		else 
		return max(x.right); 
	 }
	 public Integer max(){
		return max(root).key;
	}

	 private Node deleteMin(Node x) { 
		 if (x.left == null) 
			 return x.right; 
		 x.left = deleteMin(x.left); 
		 return x; 
	 }
	 public boolean deleteMin(){
		 if(root == null) return false;
		 deleteMin(root);
		 return true;
	 }
	  private Node deleteMax(Node x) { 
		 if (x.right == null) 
			 return x.left; 
		 x.right = deleteMax(x.right); 
		 return x; 
	 }
	 public boolean deleteMax(){
		 if(root == null) return false;
		 deleteMax(root);
		 return true;
	 }
	 /* private Node delete(Node x, Key key) { 
		 if (x == null) 
			 return null; 
		 int cmp = key.compareTo(x.key); 
		 if (cmp < 0) 
			 x.left = delete(x.left, key); 
		 else if (cmp > 0) 
			 x.right = delete(x.right , key); 
		 else { 
			if (x.right == null) 
				return x.left; 
			if (x.left == null) 
				return x.right; 
			Node t = x; 
			x = min(t.right); 
			x.right = deleteMin(t.right); 
			x.left = t.left;
		} 
		return x; 
	}
	public boolean delete(Integer key){
		if(root == null) return false;
		delete(key);
		return true;
	} */

  
    public static void main(String[] args){
		BST tree = new BST();
		
		System.out.println("BST :");
		tree.createTree("1 41 34 14 241 415");
        System.out.println();
		System.out.println(tree.search(41));
		System.out.print("NLR :");
		tree.NLR();
		System.out.println();
		System.out.print("LNR :");
		tree.LNR();
		System.out.println();
		System.out.print("LRN :");
		tree.LRN();
		System.out.println();
		System.out.print("max :");
		System.out.print(tree.max());
		System.out.println();
		System.out.print("min :");
		System.out.print(tree.min());
		tree.deleteMin();
		tree.deleteMax();
		
		
    }
}