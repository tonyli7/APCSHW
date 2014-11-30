import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;
public class WordGrid{
    private char[][]data;

  
    public WordGrid(){
	this(4,4);
    }

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols){
	data=new char[rows][cols];
	clear();
    }
   
    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		data[i][j]='-';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String grid="";
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		grid=grid+(""+data[i][j]);
		if (j!=data[i].length-1){
		    grid+=" ";
		}
	    }
	    grid+="\n";
	}
	return grid;
    }

     /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean checkWord(String word, int row, int col, int dx, int dy){
	if ((dx==1)&&(dy==1)){
	    if ((word.length()>=row)&&
		(word.length()>=col)){
		return false;
	    }
	}else if((dx==1)&&(dy==-1)){
	    if ((word.length()>=data.length-row)&&
		(word.length()>=col)){
		return false;
	    }
	}else if((dx==-1)&&(dy==1)){
	    if ((word.length()>=row)&&
		(word.length()>=data[0].length-col)){
		return false;
	    }
	}else if((dx==-1)&&(dy==-1)){
	     if ((word.length()>=data.length-row)&&
		(word.length()>=data[0].length-col)){
		return false;
	    }
	}else if((dx==1)&&(dy==0)){
	    if (word.length()>=col){
		return false;
	    }
	}else if((dx==0)&&(dy==1)){
	    if (word.length()>=row){
		return false;
	    }
	}else if((dx==-1)&&(dy==0)){
	    if (word.length()>=data[0].length-col){
		return false;
	    }
	}else if((dx==0)&&(dy==-1)){
	    if (word.length()>=data.length-row){
		return false;
	    }
	}else{
	    return false;
	}
	for (int i=0;i<word.length();i++){
	    if ((!(word.charAt(i)+"").equals(data[row-i*dy][col+i*dx]))&&
		(!(data[row-i*dy][col+i*dx]+"").equals("-"))){
		return false;
	    }
	}
	return true;
    }

    public void addWord(String word, int row, int col, int dx, int dy){
	if (checkWord(word,row,col,dx,dy)){
	    for (int i=0;i<word.length();i++){
		data[row-i*dy][col+i*dx]=word.charAt(i);
	    }	
	}
    }

   

    public void fill(){
	Random rand=new Random();
	String alpha="abcdefghijklmnopqrstuvwxyz";
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		if ((data[i][j]+"").equals("-")){
		    int index=rand.nextInt(26);
		    data[i][j]=alpha.charAt(index);
		}
	    }
	}
    }

    public String wordsInPuzzle(ArrayList<String>a){
	String words="";
	int tempVal=4;
	for (int i=0;i<a.size();i++){
	    words+=a.get(i)+"    ";
	    tempVal-=1;
	    if (tempVal==0){
		words+="\n";
		tempVal=4;
	    }
	}
	return words;
    }

    

   

    public static void main(String[]args)throws FileNotFoundException{
	WordGrid a=new WordGrid(10,10);
	ArrayList<String>wordlist=new ArrayList<String>(10);

	File text=new File("words.txt");
	Scanner in=new Scanner(text);
	
	Random rand=new Random();


	while (in.hasNextLine()){
	    final int randxCor=rand.nextInt(9);
	    final int randyCor=rand.nextInt(9);
	    final int randDx=rand.nextInt(2)-1;
	    final int randDy=rand.nextInt(2)-1;
	    String word=in.nextLine();
	    if (a.checkWord(word,randxCor,randyCor,randDx,randDy)){
		System.out.println(a.checkWord(word,randxCor,randyCor,randDx,randDy));
		a.addWord(word,randxCor,randyCor,randDx,randDy); 
		wordlist.add(word);
	
	    }	    
	}
	a.addWord("hell",5,5,1,1);
	//	a.fill();

	System.out.println(a.wordsInPuzzle(wordlist));
	System.out.println(a.toString());
    }
}

