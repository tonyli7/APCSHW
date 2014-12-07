import java.util.*;
public class SuperDriver{
    public static void main(String[]args){
	SuperArray a=new SuperArray();

	Random rand=new Random(20);
	int i=0;

	while (i<10000){
	    a.add(""+rand.nextInt());
	    i++;
	}

	long start=System.currentTimeMillis();
	a.insertionSort();
	long end=System.currentTimeMillis();
	long time=end-start;
	System.out.println(time);
    }

   
}
