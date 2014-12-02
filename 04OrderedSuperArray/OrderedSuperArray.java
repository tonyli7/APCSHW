public class OrderedSuperArray extends SuperArray{
  
    public OrderedSuperArray(){
	this(10);
    }

    public OrderedSuperArray(int len){
	super(len);
    }
    
    public void add(String element){
	for (int i=0;i<size();i++){
	    if ((element.compareTo(this.getArray()[i])<0)&&//if element after this word AND
		(element.compareTo(this.getArray()[i])>0)){//element before next word
		add(i,element);
	    }
	}
    }
}
