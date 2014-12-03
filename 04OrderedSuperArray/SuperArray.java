public class SuperArray{
    String[] superArray;
    int currentLength;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int len){
	setLength(len);
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
	for (int i=0;i<currentLength;i++){
	    a[i]=superArray[i];
	}
	String[]superArray=new String[newCapacity];
	for (int i=0;i<currentLength;i++){
	    superArray[i]=a[i];
	}
	setLength(newCapacity);
	setArray(superArray);
    }

  

    public void add(String e){
	for (int i=0;i<currentLength;i++){
	    if (superArray[i]==null){
		superArray[i]=e;
		break;
	    }
	}
	if (size()*2>getLength()){
	    resize(currentLength*2);
	}
	
    }

    public void add(int index, String o){
	if (index>=size()){
	    add(o);
	    resize(currentLength*2);
	}else{
	    resize(currentLength*2);	    
	    for (int i=index;i<=currentLength-index;i++){
		superArray[i+1]=superArray[i];
	    }
	    superArray[index]=o;
	}
    }

    public String set(int index,String o){
	if ((index<0) || (index>=getLength())){
	    throw new IndexOutOfBoundsException();
	   
	}else{
	    String original=superArray[index];
	    superArray[index]=o;
	    return original;
	}
    }

    public void setLength(int len){
	this.currentLength=len;
    }

    public int getLength(){
	return currentLength;
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
	int s=0;
	for (int i=0;i<superArray.length;i++){
	    if (superArray[i]!=null){
		s++;
	    }
	}
	return s;
    }
    public String get(int index){
	if ((index<0)||index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	for (int i=0;i<getLength();i++){
	    if (i==index){
		return superArray[i];
	    }
	}
	return null;
    }

    public String remove(int index){
	if ((index<0)||(index>=getLength())){
	    throw new IndexOutOfBoundsException();
	}else if (superArray[index]==null){
	    return null;
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
	    if (size()*4<=getLength()){
		setLength(getLength()/2);
		setArray(newArray);
		return original;
	    }
	} 
	return null;
    }
}
