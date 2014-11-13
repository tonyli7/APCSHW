public class Dsuper{
    public static void main(String[]args){
	SuperArray a=new SuperArray();
	a.resize(11);
	a.add("hi");
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(10,8008);
	for (int i=0;i<a.size();i++){
	    try{
		System.out.println(a.set(i,i+1));
	    }
	    catch(IndexOutOfBoundsException e){
		System.out.println("You suck");
	    }
	}
	System.out.println(a.remove(5));
	System.out.println(a.get(2));

	System.out.println(a.size());
	System.out.println(a.toString());
    }
}

