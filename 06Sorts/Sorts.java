import java.util.*;
public class Sorts{
    public static void main(String[]args){
	
    }
    public static void bubbleSort(int[] a){
	int temp=0;
	for (int j=0;j<a.length-1;j++){
	    boolean check=true;
	    for (int i=0;i<a.length-1;i++){
		if (a[i]>a[i+1]){
		    temp=a[i+1];
		    a[i+1]=a[i];
		    a[i]=temp;
		    check=false;
		}
	    }
	    if (check){
		break;
	    }
	}
    }

    public static void selectionSort(int[] a){
	int min;
	int temp;
	for (int j=0;j<a.length-1;j++){
	    min=a[j];
	    int i=j+1;
	    for (;i<a.length;i++){
		if (a[i]<min){
		    min=a[i];
		}
	    }
	    a[find(min,a)]=a[j];
	    a[j]=min;
	}
    }
   

    public static void insertionSort(int[] a){
	int temp=0;
	for (int i=0;i<a.length-1;i++){
	    if (a[i+1]<a[i]){
		temp=a[i+1];
		int j=i;
	
		for (;(j>=0)&&(temp<a[j]);j--){
		    a[j+1]=a[j];
		}
	
		a[j+1]=temp;
	    }
	}
    }

    public static void radixSort(int[] a){
    }

    //helpers
    public static int find(int target, int[] a){
	for (int i=0;i<a.length;i++){
	    if (target==a[i]){
		return i;
	    }
	}
	return -1;
    }

  
}
