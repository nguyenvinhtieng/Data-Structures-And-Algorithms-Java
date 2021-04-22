import java.util.*;
import java.io.*;

public class test1{
	public static AdjacencyMatrix read(String file)
	{
		try{
			File f = new File(file);
			FileReader fr = new FileReader(f);
			
			BufferedReader br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			AdjacencyMatrix ad = new AdjacencyMatrix(size);
			String line;
			int i = 0;
			int count = 0;
			while((line = br.readLine()) != null)
			{
				String[] val = null;
				val = line.split(" ");
				for(int j = 0; j < val.length; j++)
				{
					ad.setEgde(i,j,Integer.parseInt(val[j]));
					if (Integer.parseInt(val[j]) == 1)
					{
						count++;
					}
				}
				i++;
			}
			fr.close();
			br.close();
			return ad;
		}catch (Exception ex){
			ex.printStackTrace();
		}	
	return null;
	}
	public static void main(String[] args)
	{
		AdjacencyMatrix ad = read("Graph1.txt");
		ad.printGraph();
	}
}