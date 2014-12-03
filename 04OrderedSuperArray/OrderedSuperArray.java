public class OrderedSuperArray extends SuperArray{
  
    public void add(String element){
	if (size()==0){
	    super.add(element);
	}else if(size()==1){
	    if (element.compareTo(superArray[0])<0){
		super.add(element);
	    }else{
		super.add(0,element);
	    }
	}
	for (int i=0;i<size();i++){
	    if ((compare(element,superArray[i])<0)&&//if element after this word AND
		(compare(element,superArray[i+1])>0)){//element before next word
		super.add(i,element);

	    }
	}
    }

    public void insertionSort(){
	String temp="";
	for (int i=0;i<size()-1;i++){
	    if (compare(superArray[i+1],superArray[i])>0){
		temp=superArray[i+1];
		remove(i+1);
		add(temp);
	    }
	}
    }

    public int compare(String word1,String word2){
	int val=0;
	int len1=word1.length();
	int len2=word2.length();
	if (len1<len2){
	    for (int i=0;i<len1;i++){
		if (word1.charAt(i)>word2.charAt(i)){
		    return -1;
		}else if(word1.charAt(i)<word2.charAt(i)){
		    return 1;
		}
	    }
	    return -1;
	}else if (len1>len2){
	    for (int i=0;i<len2;i++){
		if (word1.charAt(i)>word2.charAt(i)){
		    return -1;
		}else if(word1.charAt(i)<word2.charAt(i)){
		    return 1;
		}
	    }
	    return -1;
	}else{
	    return 0;
	}
    }
}
