public class SuperDriver{
    public static void main(String[]args){
	OrderedSuperArray a=new OrderedSuperArray();
	a.set(0,"apple");
	a.set(1,"banana");
	a.set(2,"falcon");
	a.set(3,"gater");
	a.set(4,"peach");

	a.add("cat");
	System.out.println(a.toString());
    }
}
