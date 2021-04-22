import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class test{
	public static void main(String [] args){
		AdjacencyMatrix ad;
		try{
			File f = new File("Ex1.txt");
			FileReader fr = new FileReader(f);
			
			BufferedReader br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			ad = new AdjacencyMatrix(size);
			String line;
			int i = 0;
			//code here
			
			String [] var = null;
			while((line = br.readLine()) != null){
				
				var = line.split(" ");			
				for(int j = 0 ; j < size ; j++){
					ad.setEgde(i,j,Integer.parseInt(var[j]));
				}
				i++;
			}
			
			
			fr.close();
			br.close();
			ad.printGraph();
			System.out.print(ad.degreeVertex(1));
			System.out.print(ad.checkDirection());

			System.out.print(ad.checkEdge(1,2));
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

//C:/Users/GV/Desktop/lab9/Ex1.txt