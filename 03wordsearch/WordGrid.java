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
		data[i][j]=' ';
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
     public boolean addWordHorizontal(String word,int row,int col){
	 boolean a=true;
	 if (word.length()>data.length-col){
	     return false;
	 }
	 for (int i=0;i<word.length();i++){     
	     if (((data[row][col+i]+"").equals(" "))||
		 ((data[row][col+i]+"").equals(word.charAt(i)+""))){
		 a=true;
	     }else{
		 a=false;
	     }
	 } 
	 if (a==false){
	     for (int i=0;i<word.length();i++){     
		 if (((data[row][col+i]+"").equals(" "))||
		     ((data[row][col+i]+"").equals(word.charAt(word.length-i)+""))){
		     a=true;
		 }else{
		     a=false;
		 }
	     } 
	 }
	 
	 for (int j=0;j<word.length();j++){
	     data[row][col+j]=word.charAt(j);
	 }
     
	 
	 return a;
     }

    public boolean addWordVertical(String word, int row, int col){
	boolean a=true;
	if (word.length()>data[0].length-row){
	     return false;
	 }
	 for (int i=0;i<word.length();i++){
	     if (((data[row+i][col]+"").equals(" "))||
		 ((data[row+i][col]+"").equals(word.charAt(i)+""))){
		 a=true;
	     }else{
		 a=false;
	     }
	 }
	 if (a==false){
	     for (int i=0;i<word.length();i++){
		 if (((data[row+i][col]+"").equals(" "))||
		     ((data[row+i][col]+"").equals(word.charAt(word.length()-i)+""))){
		     a=true;
		 }else{
		     return false;
		 }
	     }
	     for (int j=0;j<word.length();j++){
		 data[row+j][col]=word.charAt(word.length()-j);
	     }
	 }else{
	     for (int j=0;j<word.length();j++){
		 data[row+j][col]=word.charAt(j);
	     }
	 }
	 return a;
    }
    
    //add diagonal from NW to SE
    public boolean addWordDiagonal(String word, int row, int col){
	Random rand=new Random();
        if ((addWordVertical(word,row,col))&&
	    (addWordHorizontal(word,row,col))){
	    if (rand.nextInt(2)==0){
		for (int i=0;i<word.length();i++){
		    data[row+i][col+i]=word.charAt(i);
		}
	    }else{
		for (int i=0;i>word.length();i++){
		    data[row+i][col+i]=word.charAt(word.length()-i);
		}
	    }
	    return true;
	}
	return false;	
    }


    public void fill(){
	Random rand=new Random();
	String alpha="abcdefghijklmnopqrstuvwxyz";
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		if ((data[i][j]+"").equals(" ")){
		    int index=rand.nextInt(26);
		    data[i][j]=alpha.charAt(index);
		}
	    }
	}
    }

   

    public static void main(String[]args){
	WordGrid a=new WordGrid();
	
	System.out.println(a.addWordHorizontal("cat",1,1));
	System.out.println(a.addWordVertical("sad",0,2));
	System.out.println(a.addWordDiagonal("lard",0,0));
	a.fill();
	System.out.println(a.toString());
	System.out.println(a.addWordHorizontal("bummy",1,2));
    }
}
