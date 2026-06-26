class Box<T>{
    private T item;
    public Box(T item){
        this.item=item;
    }
    public T getItem(){return item;}
    public void setItem(T item){
        this.item=item;
    }

    public static void printBoxInfo(Box<?> box){
        System.out.println(box.getItem());
    }

    public static <T extends Comparable<T>> T getMax(T val1,T val2){
        if(val1.compareTo(val2)>0){return val1;}else{return val2;}
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        Box<Integer> box1=new Box<>(42);
        Box.printBoxInfo(box1);
        Box<String> box2=new Box<>("Hello");
        Box.printBoxInfo(box2);
        System.out.println( Box.getMax(10,25));
        System.out.println(Box.getMax("vishal","delson"));
    }
}
