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
	    s=s+(superArray[i]+"");
	    if (i!=currentLength-1){
		s+=" , ";
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

    public void add(Object e){
        setLength(currentLength+1);
	resize(currentLength);
	superArray[currentLength-1]=e;
    }

    public void setLength(int len){
	this.currentLength=len;
    }

    public int size(){
	return currentLength;
    }

    public void setArray(Object[] a){
	this.superArray=a;
    }

    public Object get(int index){
	if ((index<0)||index>=size()){
	    for (int i=0;i<size();i++){
		if (i==index){
		    return superArray[i];
		}
	    }
	}
	return null;	
    }

}
