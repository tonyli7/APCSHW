public class SuperArray{
    private Object[] superArray;
    private int currentLength;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int len){
	currentLength=len;
	superArray=new Object[len];
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
	Object[]a=new Object[newCapacity];
	for (int i=0;i<currentLength;i++){
	    a[i]=superArray[i];
	}
	Object[]superArray=new Object[newCapacity];
	for (int i=0;i<currentLength;i++){
	    superArray[i]=a[i];
	}
	setLength(newCapacity);
	setArray(superArray);
    }

    public void add(){
    }

    public void add(Object e){
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

    public void add(int index, Object o){
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

    public Object set(int index,Object o){
	if ((index<0) || (index>=getLength())){
	    throw new IndexOutOfBoundsException();
	   
	}else{
	    Object original=superArray[index];
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

    public void setArray(Object[] a){
	this.superArray=a;
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
    public Object get(int index){
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

    public Object remove(int index){
	if ((index<0)||(index>=getLength())){
	    throw new IndexOutOfBoundsException();
	}else if (superArray[index]==null){
	    return null;
	}else{
	    Object original=superArray[index];
	    Object[]newArray=new Object[size()-1];
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
