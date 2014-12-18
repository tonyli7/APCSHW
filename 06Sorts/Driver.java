import java.util.*;
public class Driver{
    public static void main(String[]args){
	long start,end;
	Random rand = new Random(20);
	Random rand1 = new Random(20);
	Random rand2 = new Random(20);
	Random rand3 = new Random(20);
	
	SuperArray a=new Sorts();
	SuperArray b=new Sorts();
	SuperArray c=new Sorts();
	int[]d=new int[10000];

	for (int x = 0; x < 10000; x++){
	    a.add(rand.nextInt(2000000));
	    b.add(rand1.nextInt(2000000));
	    c.add(rand2.nextInt(2000000));
	    d[x]=rand3.nextInt(2000000);	
	}

	
	start = System.currentTimeMillis();
	a.bubbleSort();
	end = System.currentTimeMillis();
	System.out.println("bubble");
	System.out.println(end-start);

	start = System.currentTimeMillis();
	b.insertionSort();
	end = System.currentTimeMillis();
	System.out.println("insertion");
	System.out.println(end-start);
	
	start = System.currentTimeMillis();
	c.selectionSort();
	end = System.currentTimeMillis();
	System.out.println("selection");
	System.out.println(end-start);
	
	start = System.currentTimeMillis();
	Arrays.sort(d);
	end = System.currentTimeMillis();
	System.out.println("double quicksort");
	System.out.println(end-start);
	
    }
}
