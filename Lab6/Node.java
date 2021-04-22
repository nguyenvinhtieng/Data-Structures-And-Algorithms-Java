 public class Node {
    public Integer key;
    public Node left, right;
        
        public Node(Integer key) {
            this.key = key;
            this.left = this.right = null;
        }
		public Node() {
            this.key = 0;
            this.left = this.right = null;
        }
 }