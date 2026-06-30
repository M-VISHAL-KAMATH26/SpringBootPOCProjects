import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPOC {
    public static void main(String[] args) {
        List<String>names =List.of("vishal","rahul","tanvi","shreya","raman");
//        convert all names to uppercase, sort them alphabetically, and print each on a new line
        names.stream().map(String::toUpperCase).sorted().forEach(s-> System.out.println(s));
//        Given the same list, count how many names have more than 5 characters
long res=names.stream().filter(s->s.length()>5).count();
        System.out.println(res);

//        Given List<Integer> nums = List.of(1, 2, 2, 3, 4, 4, 5, 1), remove duplicates, sort them, and collect the result into a new List<Integer>.
        List<Integer> nums = List.of(1, 2, 2, 3, 4, 4, 5, 1);
        List<Integer> res1=nums.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(res1);

List<Integer> numbers=List.of(10,20,30,40,50);
int result1=numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(result1);
        int result2=numbers.stream().mapToInt(n->n).sum();
        System.out.println(result2);

    }
}
