package anagrams;
import java.io.*;
import java.util.ArrayList;
public class Start {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		  try
		  {
		    br = new BufferedReader(new FileReader(args[0]));
		    
		  }
		  catch (Exception e){System.out.println("Error: " + e);}
		String s = "";
		//s = br.readLine();
		int skippednum = 0;
		int currLine = 1;
		int maxNumLines = 0;
		
		
		try {
			while((s=br.readLine()) != null){
				maxNumLines++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean lineRead[] = new boolean[maxNumLines];
		boolean startnewBF = false;
		int nline = 0;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((s=br.readLine()) != null && !s.equals("")){
				if(startnewBF){
					startnewBF = false;
					for(int i = 1; i<nline-1; i++){
						br.readLine();
					}
					if(nline != 1)
						s = br.readLine();
					currLine = nline;
				}
				//System.out.println("currline-1 is "+(currLine-1));
				lineRead[currLine-1] = true;
				if(s.equals("NEXT")){
					
					currLine++;
				}else{
					String tempnum = s.substring(5);
					nline = Integer.parseInt(tempnum);
					if(lineRead[nline-1]){
						//then you have a loop
						break;
					}else if(nline > currLine){ //if you goto line furthur down
						int n = nline-currLine-1;
						
						for(int i = 0; i<n; i++){ //skip to that line
							br.readLine();
							currLine++;
						}
						currLine++;
						//System.out.println("ccccurrLine is " + currLine);
						
					}else{
						startnewBF = true;
						br = new BufferedReader(new FileReader(args[0]));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printUnusedLines(lineRead, maxNumLines);
	}
	
	public static void printUnusedLines(boolean[] arr, int max){
		for(int i = 0; i<max; i++){
			if(!arr[i]){
				System.out.println(i+1);
			}
		}
		
	}
}
