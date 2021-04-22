public class AdjacencyMatrix{
	private int[][] adj;
	private final int NUMBER_OF_VERTICES;
	
	public AdjacencyMatrix(int vertices){
		//code here
		NUMBER_OF_VERTICES = vertices;
		adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
		
	}
	
	public void setEgde(int vertexSource, int vertexDestination, int weight){
		//code here
		try {
			adj[vertexSource][vertexDestination] = weight;
			adj[vertexDestination][vertexSource] = weight;
		}
		catch(ArrayIndexOutOfBoundsException indexBounce) {
			System.out.println("The vertex is invalid ");
		}
		
	}
		

	
	public int getEgde(int vertexSource, int vertexDestination){
		try{
			return adj[vertexSource][vertexDestination];
			
		}catch (ArrayIndexOutOfBoundsException indexBounce){
			System.out.print("The vertex is invalid");
		}
		return -1;	
	}
	
	public void printGraph(){
		for(int i = 0; i < NUMBER_OF_VERTICES; i++){
			for(int j = 0; j < NUMBER_OF_VERTICES; j++)
			{
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
	public int degreeVertex(int i)
	{
		//code here
		int dem = 0;
		for(int j = 0 ; j < NUMBER_OF_VERTICES; j++){
			if(adj[i][j] != 0 ){
				dem ++;
			}
		}
		return dem;
	}
	public boolean checkDirection()
	{
		//code here
		for(int i=0 ; i < NUMBER_OF_VERTICES ; i++){
			for(int j = 0 ; j <NUMBER_OF_VERTICES;j++){
				if(adj[i][j] != adj[j][i] ){
					return false;
				}
			}
		}
		return true;
	
	}
	public boolean checkEdge(int u, int v)
	{
		//code here
		if(adj[u-1][v-1] != 0){
			return true;
		}
		return false;
	}
	
}





