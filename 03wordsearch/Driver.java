import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;
public class Driver{
    public static void main(String[]args)throws FileNotFoundException{

	int rows=Integer.valueOf(args[0]);
	int cols=Integer.valueOf(args[1]);
	long seed=Long.valueOf(args[2]);
       
	WordGrid a=new WordGrid(rows,cols);

	ArrayList<String>wordlist=new ArrayList<String>(10);

	File text=new File("words.txt");
	Scanner in=new Scanner(text);
	
	Random rand=new Random();
	rand.setSeed(seed);


	while (in.hasNextLine()){
	    final int randxCor=rand.nextInt(cols);
	    final int randyCor=rand.nextInt(rows);
	    final int randDx=rand.nextInt(2)-1;
	    final int randDy=rand.nextInt(2)-1;
	    String word=in.nextLine();
	    if (a.checkWord(word,randyCor,randxCor,randDx,randDy)){
		System.out.println(a.checkWord(word,randyCor,randxCor,randDx,randDy));
		a.addWord(word,randyCor,randxCor,randDx,randDy); 
		wordlist.add(word);
	
	    }	    
	}

	//	a.fill();

	System.out.println(a.wordsInPuzzle(wordlist));
	System.out.println(a.toString());
    }
}
