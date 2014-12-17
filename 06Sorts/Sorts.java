import java.util.*;
public class Sorts{
   

    public static void bubbleSort(int[]array){	
	int temp=0;
	for (int j=0;j<array.length-1;j++){
	    boolean check=true;
	    for (int i=0;i<array.length-1;i++){
		if (array[i]>array[i+1]){
		    temp=array[i+1];
		    array[i+1]=array[i];
		    array[i]=temp;
		    check=false;
		}
	    }
	    if (check){
		break;
	    }
	}
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

    public static void main(String[]args){
	Random rand = new Random();
	int[] array=new int[10];
	for (int i=0;i<10;i++){
	    array[i]=rand.nextInt(20);
	}
	System.out.println(toString(array));
	bubbleSort(array);
	System.out.println(toString(array));
	
    }
}
