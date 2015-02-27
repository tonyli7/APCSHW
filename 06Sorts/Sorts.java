import java.util.*;
import java.lang.*;
public class Sorts{
   
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
	int power=1;
	int max=a[0]%10;
	for (int i=0;;i++){
	    ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>(10);
	    for (int z=0;z<10;z++){
		ArrayList<Integer> al=new ArrayList<Integer>();
		l.add(al);
	    }
	    for (int j=0;j<a.length;j++){
		l.get((a[j]/power)%10).add(a[j]);
		if (a[j]%10>max){
		    max=a[j]%10;
		}
	    }
	    int index=0;
	    int ctr=0;
	    for (int x=0;x<a.length;){
		if (l.get(ctr).size()>index){
		    a[x]=l.get(ctr).get(index);
		    index++;
		    x++;
		}else{
		    index=0;
		    ctr++;
		}
	    }
	    if (i==max){
		break;
	    }
	    power=power*10;
	}
	
    }

    public static void MergeSort(int[] a){
	MergeSort(a, 0, a.length/2);
    }

    public static void MergeSort(int[] a, int start1, int start2){
	if (start1==start2){
	    //compare and merge
	}
	else{
	    //split 
	}
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

    public static int digits(int a){
	if (a/10==0){
	    return 1;
	}
	return digits(a/10)+1;
    }
  
    public static String toString(int[]a){
	String s="[";
	for (int i=0;i<a.length;i++){
	    s=s+(a[i]+"");
	    if (i!=a.length-1){
		s+=" , ";
	    }  
	}
	s+="]";
	return s;
    }

}
