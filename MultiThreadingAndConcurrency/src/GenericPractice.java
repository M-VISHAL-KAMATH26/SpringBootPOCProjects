class Boxer<T>{
    private T value;

    Boxer(){}
    public void setValue(T value){
        this.value=value;
    }
    public T getValue(){
        return value;
    }


}

public class GenericPractice {

    public static <T> T print(T data){
        return data;
//        System.out.println(data);
    }
    public static void main(String[] args) {

        Boxer<Integer> box=new Boxer<>();
        box.setValue(22);
        int x=box.getValue();
        System.out.println(x);

        System.out.println(print(21));

        System.out.println(print("laude"));
        System.out.println(print(false));

    }
}
