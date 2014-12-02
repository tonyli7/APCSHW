public class SuperDriver{
    public static void main(String[]args){
	OrderedSuperArray a=new OrderedSuperArray(10);
	a.add(0,"apple");
	a.add(1,"banana");
	a.add(2,"falcon");
	a.add(3,"gater");
	a.add(4,"peach");

	System.out.println(a.size());
	System.out.println(a.toString());
    }
}
