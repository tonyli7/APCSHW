public class SuperArray{
    String[] superArray;
    int currentLength;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int len){
	currentLength=0;
	setNew(len);
    }

    public String toString(){
	String s="[";
	for (int i=0;i<size();i++){
	    if (superArray[i]!=null){
		s=s+(superArray[i]+"");
		if (i!=size()-1){
		    s+=" , ";
		}
	    }
	}
	s+="]";
	return s;
    }

    public void resize(int newCapacity){
	String[]a=new String[newCapacity];
	for (int i=0;i<superArray.length;i++){
	    a[i]=superArray[i];
	}
	superArray=a;
    }

  

    public void add(String e){
	if (size()*2>superArray.length){
	    resize(superArray.length*2);
	}
	superArray[size()]=e;
	currentLength+=1;
    }

    public void add(int index, String o){
	if (index>=size()){
	    add(o);
	    resize(superArray.length*2);
	}else{
	    resize(superArray.length*2);	
	    
	    for (int i=size()-1;i>=index;i--){
		superArray[i+1]=superArray[i];
	    }
	    superArray[index]=o;
	    currentLength+=1;
	}
    }

    public String set(int index,String o){
	if ((index<0) || (index>=superArray.length)){
	    throw new IndexOutOfBoundsException();
	}else{
	    String original=superArray[index];
	    superArray[index]=o;
	    return original;
	}
    }

   

    public void setArray(String[] a){
	this.superArray=a;
    }

    public void setNew(int len){
	superArray=new String[len];
    }

    public String[] getArray(){
	return superArray;
    }

    public int size(){
	return currentLength;
    }

    public String get(int index){
	if ((index<0)||index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	for (int i=0;i<size();i++){
	    if (i==index){
		return superArray[i];
	    }
	}
	return null;
    }

    public String remove(int index){
	if ((index<0)||(index>=size())){
	    throw new IndexOutOfBoundsException();
	}else{
	    String original=superArray[index];
	    String[]newArray=new String[size()-1];
	    for (int i=0;i<size()-1;i++){
		if (i>=index){
		    newArray[i]=superArray[i+1];
		}else{
		    newArray[i]=superArray[i];
		}
	    }
	    currentLength-=1;
	    if (size()*4<=superArray.length){
		resize(superArray.length/2);
		setArray(newArray);
	    }
	    return original;
	} 
	
    }

    public void selectionSort(){
	String min;
	String temp;
	for (int j=0;j<size()-1;j++){
	    min=superArray[j];
	    int i=j+1;
	    for (;i<size();i++){
		if (superArray[i].compareTo(min)<0){
		    min=superArray[i];
		}
	    }
	    superArray[find(min)]=superArray[j];
	    superArray[j]=min;
	}
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
   

    public void insertionSort(){
	String temp="";
	for (int i=0;i<size()-1;i++){
	    if (superArray[i+1].compareTo(superArray[i])<0){
		temp=superArray[i+1];
		int j=i;
	
		for (;(j>=0)&&(temp.compareTo(superArray[j])<0);j--){
		    superArray[j+1]=superArray[j];
		}
	
		superArray[j+1]=temp;
	    }
	}
    }
    /*starts with second element and stores
      it temporarily. Then while the stored 
      element precedes the current element,
      the current element shifts to the right.
      When the current element precedes the
      stored element, the stored element replaces
      the current. Then the process repeats 
      to sort the next element.*/

    //insertionSort does indeed work because it prints the same thing as the built-in

    /*insertionSort can be tested by comparing how many milliseconds it would take
      to sort a list of 1000 random "words" to how many it would take the 
      badInsertionSort.*/

    public int find(String target){
	for (int i=0;i<size();i++){
	    if (target.equals(superArray[i])){
		return i;
	    }
	}
	return -1;
    }
}
