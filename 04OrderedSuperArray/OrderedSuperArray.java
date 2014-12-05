public class OrderedSuperArray extends SuperArray{
  
    public void add(String element){
	if (size()==0){
	    super.add(element);
	}else{
	    for (int i=0;i<size();i++){
		if (element.compareTo(superArray[i])<0){
		    super.add(i,element);
		    break;
		}else if(i==size()-1){
		    super.add(element);
		    break;
		}
		
	    }
	}
    }

    public String set(int index,String s){
	String original=remove(index);
	add(s);
	return original;
    }

    public int find(String target){
	for (int i=size()/2;i<size();){
	    if (target.equals(superArray[i])){
		return i;
	    }else if (target.compareTo(superArray[i])<0){
		i=i/2;
	    }else{
		i=i+i/2;
	    }
	}
	return -1;
    }

 
}
