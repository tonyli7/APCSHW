import java.util.*;
import java.lang.*;
public class Sorts{
    public static void main(String[]args){
	Random rand = new Random();
	int[]x=new int[10];
	for (int i=0;i<10;i++){
	    x[i]=rand.nextInt(20000);
	}
	System.out.println(toString(x));
	try{
	    radixSort(x);
	}
	catch(Exception e){
	    System.out.println("FUCK");
	}
	System.out.println(toString(x));
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
	for (int i=0;;i++){
	    int max=a[0];
	    ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>(a.length);
	    for (int j=0;j<a.length;j++){
		l.add((((int)a[j]/Math.pow(10,i))%((int)Math.pow(10,i+1))),a[j]);
		if (a[j]>max){
		    max=a[j];
		}
	    }
	    int index=0;
	    int ctr=0;
	    for (int x=0;x<a.length;x++){
		if (l.get(ctr).size()>index){
		    a[x]=l.get(ctr).get(index);
		    index++;
		}else{
		    index=0;
		    ctr++;
		}
	    }
	    if (i==max){
		break;
	    }
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
