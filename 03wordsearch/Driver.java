import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;
public class Driver{
    public static void main(String[]args)throws FileNotFoundException{

	int rows=Integer.valueOf(args[0]);
	int cols=Integer.valueOf(args[1]);
	long seed=Long.valueOf(args[2]);

	WordGrid a=new WordGrid(rows,cols,seed);
	


	
	a.loadWordsFromFile("words.txt",Integer.valueOf(args[3]));
	System.out.println(a.wordsInPuzzle(a.getList()));
	System.out.println(a.toString());
    }
}
