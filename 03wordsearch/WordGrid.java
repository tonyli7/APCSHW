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
	 if (word.length()>data.length){
	     return false;
	 }
	 for (int i=0;i<word.length();i++){
	     if ((!(data[row][col+1]+"").equals(" "))&&
		 (!word.substring(i,i+1).equals(data[row][col+i]))){
		 return false;
	     }
	 }
	 return true;
     }

    public boolean addWordVertical(String word, int row, int col){
	if (word.length()>data[0].length-row){
	     return false;
	 }
	 for (int i=0;i<word.length();i++){
	     if ((!(data[row+1][col]+"").equals(" "))&&
		 (!word.substring(i,i+1).equals(data[row+i][col]))){
		 return false;
	     }
	 }
	 return true;
    }
    
    //add diagonal from NW to SE
    public boolean addWordDiagonalRD(String word, int row, int col){
        if ((word.length()>data[0].length-row)&&
	    (word.length()>data.length)){
	    return false;
	}
	for (int i=0;i<word.length();i++){
	    if ((!(data[row-1][col-1]+"").equals(" "))&&
		(!word.substring(i,i+1).equals(data[row-i][col-i]))){
		return false;
	    }
	}
	return true;
    }


    public boolean contains(String c, char[]q){
	for (int i=0;i<q.length;i++){
	    if (c.equals(q[i])){
		return true;
	    }
	}
	return false;
    }

    public boolean contains(String c,char[][]q){
	for (int i=0;i<q.length;i++){
	    if (contains(c,q[i])){
		return true;
	    }
	}
	return false;
    }

    public static void main(String[]args){
	WordGrid a=new WordGrid();

	System.out.println(a.toString());
	System.out.println(a.addWordHorizontal("bummy",1,2));
    }
}
