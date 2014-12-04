public class SuperDriver{
    public static void main(String[]args){
	SuperArray a=new SuperArray();
       
	a.add("zebra");
	System.out.println(a);
	a.add("apple");

        
	
	a.add("falcon");
	a.add("gater");
	a.add("peach");

	a.add("cat");
	a.insertionSort();
	System.out.println(a.toString());
    }
}
