import java.util.*;
public class Sorts extends SuperArray{

    public void bubbleSort(){
	int temp=0;
	for (int j=0;j<size()-1;j++){
	    boolean check=true;
	    for (int i=0;i<size()-1;i++){
		if (superArray[i]>superArray[i+1]){
		    temp=superArray[i+1];
		    superArray[i+1]=superArray[i];
		    superArray[i]=temp;
		    check=false;
		}
	    }
	    if (check){
		break;
	    }
	}
    }

    public void selectionSort(){
	int min;
	int temp;
	for (int j=0;j<size()-1;j++){
	    min=superArray[j];
	    int i=j+1;
	    for (;i<size();i++){
		if (superArray[i]<min){
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
	int temp=0;
	for (int i=0;i<size()-1;i++){
	    if (superArray[i+1]<superArray[i]){
		temp=superArray[i+1];
		int j=i;
	
		for (;(j>=0)&&(temp<superArray[j]);j--){
		    superArray[j+1]=superArray[j];
		}
	
		superArray[j+1]=temp;
	    }
	}
    }

  
}
