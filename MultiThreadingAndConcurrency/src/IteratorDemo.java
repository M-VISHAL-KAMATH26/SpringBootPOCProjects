import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Using Iterator — remove all even numbers from the list
//Using ListIterator — replace all odd numbers with their square
//Using ListIterator — print the list in reverse order
public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            int num=it.next();
            if(num%2==0){
                it.remove();
            }
        }
        System.out.println("-----After removing the even numbers-----");
        System.out.println(list);


        ListIterator<Integer> lit=list.listIterator();
        while(lit.hasNext()){
            int num=lit.next();
            if(num%2!=0){
                lit.set(num*num);
            }
        }
        System.out.println("-----after replacing odd numbers with their square-----");
        System.out.println(list);


        System.out.println("backward traversal");
        ListIterator<Integer> backlit= list.listIterator(list.size());
        while(backlit.hasPrevious()){
            System.out.print(backlit.previous()+" ");
        }
    }
}
