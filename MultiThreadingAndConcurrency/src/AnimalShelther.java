import java.util.ArrayList;
import java.util.List;

class Shelther<T>{
    public List<T> animals;

    public Shelther(List<T> animals){this.animals=animals;}

    public void add(T animal){
        animals.add(animal);
    }

    public List<T> getAll(){
        return animals;
    }

    public  void printAll(List<? extends T> list){
        for(T o:list){
            System.out.println(o);
        }
    }
    public void transferTo(List<? super T> dest){
        for (T animal : animals) {
            dest.add(animal);
        }
    }
}

public class AnimalShelther {
    public static void main(String[] args) {
        Shelther<String> shelter = new Shelther<>(new ArrayList<>());

        shelter.add("Dog");
        shelter.add("Cat");
        shelter.add("Rabbit");

        shelter.printAll(shelter.getAll());

        List<Object> bigList = new ArrayList<>();
        shelter.transferTo(bigList);
        System.out.println(bigList);

    }
}
