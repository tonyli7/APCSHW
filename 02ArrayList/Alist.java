import java.util.*;
public class Alist{
    public static void main(String[]args){
	ArrayList<Integer> a=new ArrayList<Integer>(10);
	a.add(1);
	a.add(2);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(4);
	a.add(4);
	a.add(5);
	a.add(6);
	a.add(1);
	System.out.println(a);
	collapseDuplicates(a);
	System.out.println(a);
    }

    public static void collapseDuplicates(ArrayList<Integer>L){
	for (int i=0;i<L.size()-1;i++){
	    if (L.get(i)==L.get(i+1)){
		L.remove(i+1);
		i--;
	    }
	}
    }
}
